package com.apica.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apica.model.UserJournal;
import com.apica.model.UserModel;
import com.apica.producer.KafkaProducer;
import com.apica.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping("/v1/users")
public class UserController {

	@Autowired
	UserService userService;
	
	@Autowired
	KafkaProducer kafkaProducer;
	
	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	@GetMapping
	public ResponseEntity<List<UserModel>> getAll() throws Exception{
		List<UserModel> userList = userService.getAll();
		return new ResponseEntity<>(userList, HttpStatus.OK);
	}
	
	@PreAuthorize("hasAuthority('ROLE_ADMIN') OR hasAuthority('ROLE_USER')")
	@GetMapping("/{id}")
	public ResponseEntity<UserModel> getById(@PathVariable Integer id) throws Exception{
		UserModel user = userService.getById(id);
		return new ResponseEntity<>(user, HttpStatus.OK);
	}
	
	@PreAuthorize("hasAuthority('ROLE_ADMIN') OR hasAuthority('ROLE_USER')")
	@PostMapping
	public ResponseEntity<UserModel> create(@RequestBody UserModel userModel) throws Exception{
		UserModel user = userService.create(userModel);
		return new ResponseEntity<>(user, HttpStatus.OK);
	}
	
	@PreAuthorize("hasAuthority('ROLE_ADMIN') OR hasAuthority('ROLE_USER')")
	@PatchMapping("/{id}")
	public ResponseEntity<UserModel> update(@PathVariable Integer id, @RequestBody UserModel userModel) throws Exception{
		UserModel user = userService.update(id, userModel);
		return new ResponseEntity<>(user, HttpStatus.OK);
	}
	
	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	@DeleteMapping("/{id}")
	public ResponseEntity<String> delete(@PathVariable Integer id) throws Exception{
		userService.delete(id);
		return new ResponseEntity<>("User deleted successfully", HttpStatus.OK);
	}
	
	@PreAuthorize("hasAuthority('ROLE_USER')")
	@PostMapping("/journals")
	public ResponseEntity<String> publishJournal(@RequestBody UserJournal journal) throws Exception{
		kafkaProducer.sendMessage("user-events", new ObjectMapper().writeValueAsString(journal));
		return new ResponseEntity<>("successfully publish journal", HttpStatus.OK);
	}
}
