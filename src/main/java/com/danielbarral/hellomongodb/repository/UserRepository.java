package com.danielbarral.hellomongodb.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.danielbarral.hellomongodb.model.User;

@Repository
public interface UserRepository extends MongoRepository<User, String> {

	public User findByName(String name);

	public User findByEmail(String email);

}
