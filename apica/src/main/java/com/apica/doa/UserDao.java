package com.apica.doa;

import java.util.List;

import com.apica.model.UserModel;

public interface UserDao {
	
	List<UserModel> getAll() throws Exception;
	
	UserModel getById(Integer id) throws Exception;
	
	UserModel create(UserModel user) throws Exception;
	
	UserModel update(Integer id, UserModel user) throws Exception;
	
	void delete(Integer id) throws Exception;
	

}
