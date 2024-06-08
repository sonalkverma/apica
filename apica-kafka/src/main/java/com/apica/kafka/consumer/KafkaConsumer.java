package com.apica.kafka.consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.apica.kafka.doa.UserJournalDao;
import com.apica.kafka.model.UserJournal;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class KafkaConsumer {

	@Autowired
	UserJournalDao journalDao;

	@KafkaListener(topics = "user-events", groupId = "userGroup")
	public void consume(String message) {
		try {
			log.info("successgully consumed messaage, {}", message);
			ObjectMapper mapper = new ObjectMapper();
			UserJournal journal = mapper.readValue(message, UserJournal.class);
			journalDao.publishJournal(journal);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
