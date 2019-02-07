package com.example.elasticSearch;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

import com.example.elasticSearch.service.OrderService;
import com.example.elasticSearch.service.ProductService;
import com.example.elasticSearch.service.UserService;

@SpringBootApplication
public class ElasticSearchApplication implements CommandLineRunner{
	 private static Logger LOG = LoggerFactory
		      .getLogger(ElasticSearchApplication.class);
	 
	@Autowired
	private UserService userService;
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private OrderService orderService;

	public static void main(String[] args) {
		 LOG.info("STARTING THE APPLICATION");
	        SpringApplication.run(ElasticSearchApplication.class, args).close();;
	        LOG.info("APPLICATION FINISHED");
	}

	@Override
	public void run(String... args) throws Exception {
		//userService.saveUser();
		//productService.deleteProductByQuery();
		//productService.getProduct();
		productService.filtersKeyAggregation();
		productService.histogramAggregation();//();
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public ProductService getProductService() {
		return productService;
	}

	public void setProductService(ProductService productService) {
		this.productService = productService;
	}

	public OrderService getOrderService() {
		return orderService;
	}

	public void setOrderService(OrderService orderService) {
		this.orderService = orderService;
	}
	
}

