package com.apica.kafka.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.apica.kafka.model.UserJournal;
import com.apica.kafka.service.JournalService;

@RestController
@RequestMapping("/v1/journals")
public class JournalController {

	@Autowired
	JournalService journalService;
	
	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	@GetMapping
	public ResponseEntity<List<UserJournal>> getAll(@RequestParam(required = false) Integer userId) throws Exception{
		List<UserJournal> journalList = journalService.getAll(userId);
		return new ResponseEntity<>(journalList, HttpStatus.OK);
	}
}
