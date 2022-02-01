package com.example.demo.dao;

import org.springframework.data.mongodb.repository.MongoRepository;

import model.User;

public interface Dao extends MongoRepository<User, String> {

}
