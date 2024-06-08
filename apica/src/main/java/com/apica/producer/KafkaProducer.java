package com.apica.producer;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class KafkaProducer {

	private KafkaTemplate<String, String> kafkaTemplate = null;

	public KafkaProducer(KafkaTemplate<String, String> kafkaTemplate) {
		this.kafkaTemplate = kafkaTemplate;
	}
	
	public void sendMessage(String topic, String message) {
		kafkaTemplate.send(topic, message);
		log.info("message sent successfully, {}", message);
	}
	
}
