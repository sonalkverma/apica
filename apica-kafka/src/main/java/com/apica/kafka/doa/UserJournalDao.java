package com.apica.kafka.doa;

import java.util.List;

import com.apica.kafka.model.UserJournal;

public interface UserJournalDao {
	
	void publishJournal(UserJournal journal) throws Exception;

	List<UserJournal> getAll(Integer userId) throws Exception;
	

}
