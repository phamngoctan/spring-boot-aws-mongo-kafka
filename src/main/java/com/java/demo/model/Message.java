package com.java.demo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString

@Document(collection = "message")
public class Message {
	
	@Id
	private int id;
	private String name;
	private String email;
	private String message;

	public Message() {
	}

	public Message(String name, String email, String message) {
		this.name = name;
		this.email = email;
		this.message = message;
	}
}
