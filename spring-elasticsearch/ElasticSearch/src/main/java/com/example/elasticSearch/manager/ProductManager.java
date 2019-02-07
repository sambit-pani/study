package com.example.elasticSearch.manager;

import java.io.IOException;
import java.util.List;

import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.action.update.UpdateResponse;
import org.elasticsearch.common.xcontent.XContentBuilder;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.aggregations.Aggregation;
import org.elasticsearch.search.aggregations.Aggregations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.ResultsExtractor;
import org.springframework.data.elasticsearch.core.query.DeleteQuery;
import org.springframework.data.elasticsearch.core.query.NativeSearchQuery;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import org.springframework.data.elasticsearch.core.query.UpdateQuery;
import org.springframework.data.elasticsearch.core.query.UpdateQueryBuilder;
import org.springframework.stereotype.Component;

import com.example.elasticSearch.model.Product;
import com.example.elasticSearch.repository.ProductRepository;

import static org.elasticsearch.common.xcontent.XContentFactory.*;

@Component
public class ProductManager {

	@Autowired
	private ProductRepository repository;
	
	@Autowired
	private ElasticsearchTemplate template;
	
	public List<Product> getProductByName(String name) {
		return repository.findByName(name);
	}
	
	public Product getProductById(Long id) {
		return repository.findById(id).get();
	}
	
	public void deleteProduct(DeleteQuery query) {
		template.delete(query);
	}
	
	public UpdateResponse updateProduct(UpdateQuery query) throws IOException {
		UpdateResponse response = template.update(query);
		return response;
	}
	
	public List<Product> termQueryProduct(SearchQuery query) {
		List<Product> products = template.queryForList(query, Product.class);
		Page<Product> productPage = template.queryForPage(query, Product.class);
		System.out.println("page size:" + productPage.getSize() + " " + productPage.getTotalElements() + " "
				+ productPage.getTotalPages());
		return products;
	}
	
	public List<Product> queryProduct(SearchQuery query){
/*		SearchResponse response = template.getClient().prepareSearch("product").setTypes("default")
				.setQuery(query.getQuery()).setSize(0).get();
		System.out.println(response.getHits().getTotalHits());
*/		System.out.println("Total Count "+template.count(query,Product.class));
		return template.queryForList(query, Product.class);
	}
	
	public Aggregations aggregationQuery(SearchQuery query) {
		Aggregations aggregations = template.query(query, new ResultsExtractor<Aggregations>() {
			@Override
			public Aggregations extract(SearchResponse response) {
				return response.getAggregations();
			}
		});
		return aggregations;
	}
	public ProductRepository getRepository() {
		return repository;
	}

	public void setRepository(ProductRepository repository) {
		this.repository = repository;
	}

	public ElasticsearchTemplate getTemplate() {
		return template;
	}

	public void setTemplate(ElasticsearchTemplate template) {
		this.template = template;
	}
	
	
	
	
}
