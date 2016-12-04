package com.danielbarral.hellomongodb.model.repository;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.danielbarral.hellomongodb.model.User;
import com.mongodb.Block;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoDatabase;

@Repository
public class UserRepository {
	
	@Autowired
	private MongoDatabase db;
	
	public void save(User user) {
		
		Document document = new Document()
				.append("name", user.getName())
				.append("email", user.getEmail());
		
		db.getCollection("users").insertOne(document);
		
	}
	
	public List<User> list() {
		
		List<User> users = new ArrayList<>();
		
		FindIterable<Document> iterable = db.getCollection("users").find();
		
		iterable.forEach(new Block<Document>() {
		    @Override
		    public void apply(final Document document) {
		        User user = new User();
		        user.setName(document.getString("name"));
		        user.setEmail(document.getString("email"));
		        
				users.add(user);
		    }
		});
		
		return users;
		
	}

}
