package com.example.elasticSearch.service;

import static org.elasticsearch.common.xcontent.XContentFactory.jsonBuilder;

import java.io.IOException;
import java.util.List;

import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.action.update.UpdateResponse;
import org.elasticsearch.common.unit.Fuzziness;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.Operator;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.aggregations.Aggregation;
import org.elasticsearch.search.aggregations.AggregationBuilders;
import org.elasticsearch.search.aggregations.Aggregations;
import org.elasticsearch.search.aggregations.BucketOrder;
import org.elasticsearch.search.aggregations.bucket.filter.Filter;
import org.elasticsearch.search.aggregations.bucket.filter.FilterAggregationBuilder;
import org.elasticsearch.search.aggregations.bucket.filter.Filters;
import org.elasticsearch.search.aggregations.bucket.filter.FiltersAggregationBuilder;
import org.elasticsearch.search.aggregations.bucket.filter.FiltersAggregator.KeyedFilter;
import org.elasticsearch.search.aggregations.bucket.histogram.Histogram;
import org.elasticsearch.search.aggregations.bucket.range.Range;
import org.elasticsearch.search.aggregations.bucket.terms.Terms;
import org.elasticsearch.search.aggregations.bucket.terms.TermsAggregator;
import org.elasticsearch.search.aggregations.metrics.avg.Avg;
import org.elasticsearch.search.aggregations.metrics.cardinality.Cardinality;
import org.elasticsearch.search.aggregations.metrics.max.Max;
import org.elasticsearch.search.aggregations.metrics.min.Min;
import org.elasticsearch.search.aggregations.metrics.stats.Stats;
import org.elasticsearch.search.aggregations.metrics.sum.Sum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.elasticsearch.core.query.DeleteQuery;
import org.springframework.data.elasticsearch.core.query.FetchSourceFilter;
import org.springframework.data.elasticsearch.core.query.NativeSearchQuery;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import org.springframework.data.elasticsearch.core.query.SourceFilter;
import org.springframework.data.elasticsearch.core.query.UpdateQuery;
import org.springframework.data.elasticsearch.core.query.UpdateQueryBuilder;
import org.springframework.stereotype.Service;

import com.example.elasticSearch.manager.ProductManager;
import com.example.elasticSearch.model.Product;

@Service
public class ProductService {

	@Autowired
	private ProductManager productManager;

	public void getProduct() {
		String productName = "Lobster";
		List<Product> product = productManager.getProductByName(productName);
		System.out.println(product.size());
	}

	public void getProductById() {
		Long id = 2l;
		Product product = productManager.getProductById(id);
		System.out.println(product);
	}

	public void deleteProductByQuery() {
		QueryBuilder builder = QueryBuilders.matchQuery("name", "sambit");
		DeleteQuery query = new DeleteQuery();
		query.setQuery(builder);
		productManager.deleteProduct(query);
	}

	public void updateProduct() {
		try {
			UpdateRequest updateRequest = new UpdateRequest("product", "default", "1");
			updateRequest.doc(jsonBuilder().startObject().field("price", 200).endObject());
			UpdateQuery query = new UpdateQueryBuilder().withClass(Product.class).withId("1")
					.withUpdateRequest(updateRequest).build();
			UpdateResponse response = productManager.updateProduct(query);
			System.out.println(response.status());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void termQueryProduct() {
		SearchQuery query = new NativeSearchQuery(QueryBuilders.termQuery("is_active", true));
		List<Product> product = productManager.termQueryProduct(query);
		System.out.println(product.size());
	}

	public void matchQueryProduct() {
		SearchQuery query = new NativeSearchQuery(QueryBuilders.matchQuery("name", "Lobster"));
		List<Product> product = productManager.queryProduct(query);
		System.out.println(product.size());
	}

	public void termsQueryProduct() {
	    SearchQuery query = new NativeSearchQuery(QueryBuilders.termsQuery("tags.keyword", "Soup", "Cake"));;
		List<Product> product = productManager.queryProduct(query);
		System.out.println(product.size());

	}

	public void idsQueryProduct() {
		SearchQuery query = new NativeSearchQuery(QueryBuilders.termsQuery("_id", new int[] { 1, 2, 3 }));
		List<Product> product = productManager.queryProduct(query);
		System.out.println(product.size());
	}

	public void rangeQuery() {
		SearchQuery query = new NativeSearchQuery(QueryBuilders.rangeQuery("price").from(100).to(200));
		productManager.queryProduct(query);
	}

	public void dateRangeQuery() {
		SearchQuery query = new NativeSearchQuery(
				QueryBuilders.rangeQuery("created").from("2007/01/01").to("2007/12/31"));
		productManager.queryProduct(query);
	}

	public void existQuery() {
		SearchQuery query = new NativeSearchQuery(QueryBuilders.existsQuery("tags"));
		productManager.queryProduct(query);
	}

	public void prefixQuery() {
		SearchQuery query = new NativeSearchQuery(QueryBuilders.prefixQuery("tags.keyword", "Veg"));
		productManager.queryProduct(query);
	}

	public void wildCardQuery() {
		SearchQuery query = new NativeSearchQuery(QueryBuilders.wildcardQuery("name", "me?t"));
		productManager.queryProduct(query);
	}

	public void matchAndQuery() {
		SearchQuery query = new NativeSearchQuery(
				QueryBuilders.matchQuery("name", "pasta Spaghetti").operator(Operator.AND).fuzziness(Fuzziness.AUTO));
		productManager.queryProduct(query);
	}

	public void matchPrefix() {
		SearchQuery query = new NativeSearchQuery(QueryBuilders.matchPhraseQuery("name", "pasta with"));
		productManager.queryProduct(query);
	}

	public void multimatchQuery() {
		SearchQuery query = new NativeSearchQuery(QueryBuilders.multiMatchQuery("pasta", "name", "description"));
		productManager.queryProduct(query);
	}

	public void boolQuery() {
		BoolQueryBuilder queryBuilder = QueryBuilders.boolQuery();
		queryBuilder.must(QueryBuilders.matchQuery("name", "pasta"));
		queryBuilder.should(QueryBuilders.matchQuery("name", "Spaghetti"));
		queryBuilder.filter(QueryBuilders.rangeQuery("price").gt(100));
		queryBuilder.mustNot(QueryBuilders.termQuery("price", 125));
		SearchQuery query = new NativeSearchQuery(queryBuilder);
		productManager.queryProduct(query);
	}

	public void sourceFilteringQuery() {
		SearchQuery query = new NativeSearchQuery(QueryBuilders.termQuery("is_active", true));
		String[] includes = {"Aa"};
		String[] excludes = {"aa"};
		FetchSourceFilter sourceFilter = new FetchSourceFilter(includes, excludes);
		query.addSourceFilter(sourceFilter);
	}
	public void pageQuery() {
		SearchQuery query = new NativeSearchQuery(QueryBuilders.matchAllQuery());
		Pageable page = PageRequest.of(0, 2);
		query.setPageable(page);

		List<Product> products = productManager.queryProduct(query);
		products.stream().forEach(pro -> {
			System.out.println(pro.getName());
		});
	}

	public void sortQuery() {
		SearchQuery query = new NativeSearchQuery(QueryBuilders.matchAllQuery());
		query.addSort(Sort.by(Direction.DESC, "price"));

		List<Product> products = productManager.queryProduct(query);
		products.stream().forEach(pro -> {
			System.out.println(pro.getPrice());
		});
	}

	public void merticsAggregationQuery() {
		SearchQuery query = new NativeSearchQueryBuilder().withQuery(QueryBuilders.matchAllQuery())
				.addAggregation(AggregationBuilders.avg("price_avg").field("price"))
				.addAggregation(AggregationBuilders.sum("sum_price").field("price"))
				.addAggregation(AggregationBuilders.max("max_price").field("price"))
				.addAggregation(AggregationBuilders.min("min_price").field("price"))
				.addAggregation(AggregationBuilders.cardinality("card").field("price")).build();

		Aggregations aggregations = productManager.aggregationQuery(query);
		Avg avgAgg = aggregations.get("price_avg");
		Sum sumAgg = aggregations.get("sum_price");
		Max maxAgg = aggregations.get("max_price");
		Min minAgg = aggregations.get("min_price");
		Cardinality cardAgg = aggregations.get("card");

		System.out.println("Avg :" + avgAgg.getValue() + " ;Sum :" + sumAgg.getValue() + " ;Max :" + maxAgg.getValue()
				+ " ;Min :" + minAgg.getValue() + " ;Cardinality :" + cardAgg.getValue());

		SearchQuery searchQuery = new NativeSearchQueryBuilder().withQuery(QueryBuilders.matchAllQuery())
				.addAggregation(AggregationBuilders.stats("price_stats").field("price")).build();

		Aggregations statsAggs = productManager.aggregationQuery(searchQuery);
		Stats stats = statsAggs.get("price_stats");
		System.out.println(stats.getAvg() + "  " + stats.getSum() + " " + stats.getMax() + "  " + stats.getMin() + "  "
				+ stats.getCount());
	}

	public void termBucketAggregation() {
		SearchQuery query = new NativeSearchQueryBuilder().withQuery(QueryBuilders.matchAllQuery())
				.addAggregation(AggregationBuilders.terms("active_bucket").field("is_active").order(BucketOrder.count(true))).build();

		Aggregations aggs = productManager.aggregationQuery(query);
		Terms terms = aggs.get("active_bucket");
		for (Terms.Bucket bucket : terms.getBuckets()) {
			System.out.println("Key " + bucket.getKeyAsString() + " value " + bucket.getDocCount());
		}
	}

	public void termBucketAggregationWithSort() {
		SearchQuery query = new NativeSearchQueryBuilder().withQuery(QueryBuilders.matchAllQuery())
				.addAggregation(
						AggregationBuilders.terms("active_bucket").field("is_active").order(BucketOrder.count(true)))
				.build();

		Aggregations aggs = productManager.aggregationQuery(query);
		Terms terms = aggs.get("active_bucket");
		for (Terms.Bucket bucket : terms.getBuckets()) {
			System.out.println("Key " + bucket.getKeyAsString() + " value " + bucket.getDocCount());
		}
	}
	
	public void termsSubAggregation() {
		SearchQuery query = new NativeSearchQueryBuilder().withQuery(QueryBuilders.matchAllQuery())
				.addAggregation(AggregationBuilders.terms("active_bucket").field("is_active")
						.subAggregation(AggregationBuilders.sum("sum_price").field("price")))
				.build();
		
		Aggregations aggs = productManager.aggregationQuery(query);
		Terms terms = aggs.get("active_bucket");
		for (Terms.Bucket bucket : terms.getBuckets()) {
			System.out.println("Key " + bucket.getKeyAsString() + " value " + bucket.getDocCount());
			Sum sumAgg = bucket.getAggregations().get("sum_price");
			System.out.println(sumAgg.getValue());
		}
	}
	
	public void filterAggregation() {
		QueryBuilder filterQuery = QueryBuilders.rangeQuery("price").from(150);
		SearchQuery query = new NativeSearchQueryBuilder().withQuery(QueryBuilders.matchAllQuery())
				.addAggregation(AggregationBuilders.filter("filter_price",filterQuery )).build();
		
		Aggregations aggs = productManager.aggregationQuery(query);
		Filter filterAgg = aggs.get("filter_price");
		System.out.println("Filter Aggregation :"+filterAgg.getDocCount());
	}
	
	public void filtersAggregation() {
		QueryBuilder filterQuery1 = QueryBuilders.rangeQuery("price").from(0).to(50,false);
		QueryBuilder filterQuery2 = QueryBuilders.rangeQuery("price").from(50).to(100,false);
		QueryBuilder filterQuery3 = QueryBuilders.rangeQuery("price").from(100).to(150,false);
		QueryBuilder filterQuery4 = QueryBuilders.rangeQuery("price").from(150).to(200,false);
		QueryBuilder filterQuery5 = QueryBuilders.rangeQuery("price").from(200);
		
		SearchQuery query = new NativeSearchQueryBuilder().withQuery(QueryBuilders.matchAllQuery())
				.addAggregation(AggregationBuilders.filters("price_filters", filterQuery1, filterQuery2, filterQuery3,
						filterQuery4, filterQuery5))
				.build();
		
		Aggregations aggs = productManager.aggregationQuery(query);
		Filters filtersAgg = aggs.get("price_filters");
		for(Filters.Bucket bucket:filtersAgg.getBuckets()) {
			System.out.println(bucket.getKeyAsString()+" "+bucket.getDocCount());
		}
	}

	public void filtersKeyAggregation() {
		QueryBuilder filterQuery1 = QueryBuilders.rangeQuery("price").from(0).to(50,false);
		QueryBuilder filterQuery2 = QueryBuilders.rangeQuery("price").from(50).to(100,false);
		QueryBuilder filterQuery3 = QueryBuilders.rangeQuery("price").from(100).to(150,false);
		QueryBuilder filterQuery4 = QueryBuilders.rangeQuery("price").from(150).to(200,false);
		QueryBuilder filterQuery5 = QueryBuilders.rangeQuery("price").from(200);
		
		KeyedFilter filter1 = new KeyedFilter("range1", filterQuery1);
		KeyedFilter filter2 = new KeyedFilter("range2",filterQuery2);
		KeyedFilter filter3 = new KeyedFilter("range3",filterQuery3);
		KeyedFilter filter4 = new KeyedFilter("range4",filterQuery4);
		KeyedFilter filter5 = new KeyedFilter("range5",filterQuery5);
		
		SearchQuery query = new NativeSearchQueryBuilder().withQuery(QueryBuilders.matchAllQuery())
				.addAggregation(AggregationBuilders.filters("price_filters",filter1,filter2,filter3,filter4,filter5))
				.build();
		Aggregations aggs = productManager.aggregationQuery(query);
		Filters filtersAgg = aggs.get("price_filters");
		for(Filters.Bucket bucket:filtersAgg.getBuckets()) {
			System.out.println(bucket.getKeyAsString()+" "+bucket.getDocCount());
		}
	}
	
	
	public void rangeAggregation() {
		
		SearchQuery query = new NativeSearchQueryBuilder().withQuery(QueryBuilders.matchAllQuery())
				.addAggregation(AggregationBuilders.range("price_range").field("price").keyed(true)
						.addUnboundedTo("low", 50).addRange("medium", 50, 150).addUnboundedFrom("high",150)
						.subAggregation(AggregationBuilders.sum("sum_price").field("price")))
				.build();
		
		Aggregations aggs = productManager.aggregationQuery(query);
		Range rangeAgg = aggs.get("price_range");
		for(Range.Bucket bucket :rangeAgg.getBuckets()) {
			System.out.print(bucket.getKeyAsString()+"  "+bucket.getDocCount());
			Aggregations subAgg = bucket.getAggregations();
			Sum sum = subAgg.get("sum_price");
			System.out.println("Sum of price: "+sum.getValue());
		}
	}
	public void histogramAggregation() {
		SearchQuery query = new NativeSearchQueryBuilder().withQuery(QueryBuilders.matchAllQuery())
							.addAggregation(AggregationBuilders.histogram("price_histo").field("price").interval(50)
									.subAggregation(AggregationBuilders.sum("sum_price").field("price")))
							.build();
		Aggregations aggs = productManager.aggregationQuery(query);
		Histogram histAgg = aggs.get("price_histo");
		for(Histogram.Bucket bucket : histAgg.getBuckets()) {
			System.out.print(bucket.getKeyAsString()+"  "+bucket.getDocCount());
			Aggregations subAgg = bucket.getAggregations();
			Sum sumAgg = subAgg.get("sum_price");
			System.out.println(" Sum of histogram: "+sumAgg.getValue()+"  name "+sumAgg.getName());
		}
	}
	
	public ProductManager getProductManager() {
		return productManager;
	}

	public void setProductManager(ProductManager productManager) {
		this.productManager = productManager;
	}

}
