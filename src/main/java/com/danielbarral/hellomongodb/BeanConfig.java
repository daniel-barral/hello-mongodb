package com.danielbarral.hellomongodb;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;

@Configuration
public class BeanConfig {
	
	@Bean
	public MongoClient mongoClient() {
		return new MongoClient();
	}
	
	@Bean
	public MongoDatabase mongoDatabase(MongoClient mongoClient) {
		return mongoClient.getDatabase("hello_mongodb");
	}

}
