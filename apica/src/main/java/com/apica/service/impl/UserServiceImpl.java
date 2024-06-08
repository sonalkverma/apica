package com.apica.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apica.doa.UserDao;
import com.apica.model.UserModel;
import com.apica.service.UserService;

@Service(UserServiceImpl.BEAN_ID)
public class UserServiceImpl implements UserService {
	
	public static final String BEAN_ID = "USER_SERVICE_BEAN_ID";
	
	@Autowired
	UserDao userDao;
	
	@Override
	public List<UserModel> getAll() throws Exception {
		List<UserModel> userList = null;
		try {
			userList = userDao.getAll();
			if(userList == null)
				userList = new ArrayList<>();
		}catch (Exception e) {
			throw new Exception("Service error while fetching user records");
		}
		return userList;
	}

	@Override
	public UserModel getById(Integer id) throws Exception {
		UserModel user = null;
		try {
			user = userDao.getById(id);
			if(user == null)
				user = new UserModel();
		}catch (Exception e) {
			throw new Exception("Service error while fetching user record by id");
		}
		return user;
	}

	@Override
	public UserModel create(UserModel userModel) throws Exception {
		UserModel user = null;
		try {
			user = userDao.create(userModel);
			if(user == null)
				user = new UserModel();
		}catch (Exception e) {
			throw new Exception("Service error while creating user record");
		}
		return user;
	}

	@Override
	public UserModel update(Integer id, UserModel userModel) throws Exception {
		UserModel user = null;
		try {
			user = userDao.update(id, userModel);
			if(user == null)
				user = new UserModel();
		}catch (Exception e) {
			throw new Exception("Service error while updating user record");
		}
		return user;
	}

	@Override
	public void delete(Integer id) throws Exception {
		userDao.delete(id);
	}

}
