package com.example.elasticSearch;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.TransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

@Configuration
@EnableElasticsearchRepositories(basePackages = "com.example.elasticSearch.repository")
@ComponentScan(basePackages = { "com.example.elasticSearch" })
@PropertySource("classpath:application.properties")
public class Config {

	 @Value("${elasticsearch.host}")
	 private String EsHost;

	 @Value("${elasticsearch.port}")
	 private int EsPort;

	 @Value("${elasticsearch.clustername}")
	 private String EsClusterName;

    @Bean
    public Client client() {
        TransportClient client = null;
        try {
            final Settings elasticsearchSettings = Settings.builder()
              .put("client.transport.sniff", true)
              .put("cluster.name", EsClusterName).build();
            client = new PreBuiltTransportClient(elasticsearchSettings);
            client.addTransportAddress(new TransportAddress(InetAddress.getByName(EsHost), EsPort));
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        return client;
    }

    /*@Bean
    public ElasticsearchOperations elasticsearchTemplate() {
        return new ElasticsearchTemplate(client());
    }*/
}