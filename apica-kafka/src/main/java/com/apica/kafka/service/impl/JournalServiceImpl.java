package com.apica.kafka.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apica.kafka.doa.UserJournalDao;
import com.apica.kafka.model.UserJournal;
import com.apica.kafka.service.JournalService;

@Service
public class JournalServiceImpl implements JournalService {

	@Autowired
	UserJournalDao journalDao;
	
	@Override
	public List<UserJournal> getAll(Integer userId) throws Exception {
		
		return journalDao.getAll(userId);
	}

}
