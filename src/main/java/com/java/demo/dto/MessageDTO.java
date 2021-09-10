package com.java.demo.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class MessageDTO {
	private int id;
	private String name;
	private String email;
	private String message;
	private String action;

	public MessageDTO() {
	}

	public MessageDTO(String name, String email, String message, String action) {
		this.name = name;
		this.email = email;
		this.message = message;
	}
}
