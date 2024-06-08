package com.apica.kafka.model;

import java.util.Date;

import jakarta.persistence.Column;
import lombok.Data;

@Data
public class UserJournal {
	
	@Column(name = "id")
	Integer id;
	
	@Column(name = "userId")
	Integer userId;
	
	@Column(name = "journal")
	String journal;
	
	@Column(name = "created_date")
	Date createdDate;
	
}
