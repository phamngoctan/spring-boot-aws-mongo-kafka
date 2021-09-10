package com.java.demo;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.java.demo.dto.MessageDTO;

@Service
public class Producer {
	private static final String TOPIC = "TestTopic";
	@Autowired
	private KafkaTemplate<String, MessageDTO> kafkaTemplate;

	public void sendMessage(MessageDTO mess) {
		this.kafkaTemplate.send(TOPIC, mess);
	}

	@Bean
	public NewTopic createTopic() {
		return new NewTopic(TOPIC, 3, (short) 1);
	}

}
