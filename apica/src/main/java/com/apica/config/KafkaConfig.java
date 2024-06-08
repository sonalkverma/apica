package com.apica.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaConfig {

	public NewTopic createTopic() {
		return TopicBuilder.name("user-event").build();
	}
}
