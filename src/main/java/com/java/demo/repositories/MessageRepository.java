package com.java.demo.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.java.demo.model.Message;

@Repository
public interface MessageRepository extends MongoRepository<Message, Integer> {}