package com.apica.kafka.service;

import java.util.List;

import com.apica.kafka.model.UserJournal;

public interface JournalService {

	List<UserJournal> getAll(Integer userId) throws Exception;
	
}
