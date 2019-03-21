package com.example.dynamoDB;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.springframework.util.ResourceUtils;

import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.Item;
import com.amazonaws.services.dynamodbv2.document.PutItemOutcome;
import com.amazonaws.services.dynamodbv2.document.Table;
import com.amazonaws.services.dynamodbv2.document.spec.GetItemSpec;
import com.amazonaws.services.dynamodbv2.model.AttributeDefinition;
import com.amazonaws.services.dynamodbv2.model.KeySchemaElement;
import com.amazonaws.services.dynamodbv2.model.KeyType;
import com.amazonaws.services.dynamodbv2.model.ProvisionedThroughput;
import com.amazonaws.services.dynamodbv2.model.ScalarAttributeType;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class CreateTable {

	static AmazonDynamoDB client = AmazonDynamoDBClientBuilder.standard()
            .withEndpointConfiguration(new AwsClientBuilder.EndpointConfiguration("http://localhost:8000", "us-east-2"))
            .build();

      static  DynamoDB dynamoDB = new DynamoDB(client);

	/**
	 * Year and Title as composite key
	 * Year as Partition key and Title as Composite key
	 */
	public static void createTable() {

		        String tableName = "Movies";

		        try {
		            System.out.println("Attempting to create table; please wait...");
		            Table table = dynamoDB.createTable(tableName,
		                Arrays.asList(new KeySchemaElement("year", KeyType.HASH), // Partition
		                                                                          // key
		                    new KeySchemaElement("title", KeyType.RANGE)), // Sort key
		                Arrays.asList(new AttributeDefinition("year", ScalarAttributeType.N),
		                    new AttributeDefinition("title", ScalarAttributeType.S)),
		                new ProvisionedThroughput(10L, 10L));
		            table.waitForActive();
		            System.out.println("Success.  Table status: " + table.getDescription().getTableStatus());

		        }
		        catch (Exception e) {
		            System.err.println("Unable to create table: ");
		            System.err.println(e.getMessage());
		        }
	}
	
	public static void loadData() throws JsonParseException, IOException {

	        Table table = dynamoDB.getTable("Movies");
	        File file = ResourceUtils.getFile("classpath:moviedata.json");
	     //   ResourceUtils.getFile(resourceLocation)
	        System.out.println("test  "+file.getPath());

	        JsonParser parser = new JsonFactory().createParser(file);

	        JsonNode rootNode = new ObjectMapper().readTree(parser);
	        Iterator<JsonNode> iter = rootNode.iterator();

	        ObjectNode currentNode;

	        while (iter.hasNext()) {
	            currentNode = (ObjectNode) iter.next();

	            int year = currentNode.path("year").asInt();
	            String title = currentNode.path("title").asText();

	            try {
	                table.putItem(new Item().withPrimaryKey("year", year, "title", title).withJSON("info",
	                    currentNode.path("info").toString()));
	                System.out.println("PutItem succeeded: " + year + " " + title);

	            }
	            catch (Exception e) {
	                System.err.println("Unable to add movie: " + year + " " + title);
	                System.err.println(e.getMessage());
	                break;
	            }
	        }
	        parser.close();
	    }
	
	public static void putItem() {
		Table table = dynamoDB.getTable("Movies");
		 int year = 2015;
	        String title = "The Big New Movie";

	        final Map<String, Object> infoMap = new HashMap<String, Object>();
	        infoMap.put("plot", "Nothing happens at all.");
	        infoMap.put("rating", 0);

	        try {
	            System.out.println("Adding a new item...");
	            PutItemOutcome outcome = table
	                .putItem(new Item().withPrimaryKey("year", year, "title", title).withMap("info", infoMap));

	            System.out.println("PutItem succeeded:\n" + outcome.getPutItemResult());

	        }
	        catch (Exception e) {
	            System.err.println("Unable to add item: " + year + " " + title);
	            System.err.println(e.getMessage());
	        }

		
	}
	
	public static void getItem() {
		Table table = dynamoDB.getTable("Movies");
		String title = "The Big New Movie";
		try {
			GetItemSpec spec = new GetItemSpec().withPrimaryKey("year", 2015,"title",title);
			Item item = table.getItem(spec);
			System.out.println(item);
		
		}catch (AmazonServiceException ase) {
            System.out.println("Caught an AmazonServiceException, which means your request made it "
                    + "to AWS, but was rejected with an error response for some reason.");
            System.out.println("Error Message:    " + ase.getMessage());
            System.out.println("HTTP Status Code: " + ase.getStatusCode());
            System.out.println("AWS Error Code:   " + ase.getErrorCode());
            System.out.println("Error Type:       " + ase.getErrorType());
            System.out.println("Request ID:       " + ase.getRequestId());
        } catch (AmazonClientException ace) {
            System.out.println("Caught an AmazonClientException, which means the client encountered "
                    + "a serious internal problem while trying to communicate with AWS, "
                    + "such as not being able to access the network.");
            System.out.println("Error Message: " + ace.getMessage());
        }
	}
}
