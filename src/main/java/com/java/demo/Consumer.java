package com.java.demo;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.java.demo.dto.MessageDTO;
import com.java.demo.model.Message;
import com.java.demo.repositories.MessageRepository;

@Service
public class Consumer {
	@Autowired
	private MessageRepository repository;
	@Autowired
	ModelMapper mapper;
	
	@KafkaListener(topics = "TestTopic", groupId = "group_id", containerFactory = "messKafkaListenerFactory")
	public void consumeJson(MessageDTO messageDto) {
		System.out.println("Consumed JSON Message: " + messageDto);
		switch (messageDto.getAction()) {
		case "create":
		case "update":
			Message message = mapper.map(messageDto, Message.class);
			repository.save(message);
			break;
		case "read":
			System.out.println(repository.findAll().toString());
			break;
		case "delete":
			repository.deleteById(messageDto.getId());
		default:
			break;
		}
	}
}
