package com.java.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.java.demo.Producer;
import com.java.demo.dto.MessageDTO;

@RestController
public class KafkaController {

	private final Producer producer;

	
	@Autowired
	public KafkaController(Producer producer) {
		this.producer = producer;
	}
	

	@GetMapping("/")
	public String home() {
		return "Welcome to demo spring boot aws mongodb kafka...";
	}
	
	@PostMapping(path = "/publish", consumes = "application/json", produces = "application/json")
	public String publishMessTopic(@RequestBody MessageDTO mess) {
		this.producer.sendMessage(mess);
		return "Message Published!";
	}
}
