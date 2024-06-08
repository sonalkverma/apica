package com.apica.doa.impl;

import java.util.List;

import org.jooq.DSLContext;
import org.jooq.types.UInteger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.apica.doa.UserDao;
import com.apica.model.UserModel;
import com.jooq.apica.tables.User;
import com.jooq.apica.tables.records.UserRecord;

@Repository
public class UserDaoImpl implements UserDao {

	@Autowired
	DSLContext dslContext;
	
	@Override
	public List<UserModel> getAll() throws Exception {
		List<UserModel> userList = null;
		try {
			userList = dslContext.selectFrom(User.USER).fetchInto(UserModel.class);
		} catch (Exception e) {
			throw new Exception("Dao error while fetching user records");
		}
		return userList;
	}

	@Override
	public UserModel getById(Integer id) throws Exception {
		UserModel user = null;
		try {
			user = dslContext.selectFrom(User.USER).where(User.USER.ID.eq(UInteger.valueOf(id))).fetchOneInto(UserModel.class);
		}catch (Exception e) {
			throw new Exception("Dao error while fetching user record by id");
		}
		return user;
	}

	@Override
	public UserModel create(UserModel userModel) throws Exception{
		UserModel user = null;
		try {
			UserRecord userRecord = dslContext.newRecord(User.USER, userModel);
			userRecord.setCreatedBy(UInteger.valueOf(1));
			userRecord.setUpdatedBy(UInteger.valueOf(1));
			userRecord.insert();
			
			user = getById(userRecord.getId().intValue());
		}catch (Exception e) {
			throw new Exception("Dao error while creating user record");
		}
		return user;
	}

	@Override
	public UserModel update(Integer id, UserModel userModel) throws Exception{
		UserModel user = null;
		try {
			user = getById(id);
			
			UserRecord userRecord = dslContext.newRecord(User.USER, userModel);
			userRecord.setId(UInteger.valueOf(id));
			userRecord.setUpdatedCount(user.getUpdatedCount()+1);
			userRecord.setUpdatedBy(UInteger.valueOf(1));
			userRecord.update();
			
			user = getById(userRecord.getId().intValue());
		}catch (Exception e) {
			throw new Exception("Dao error while creating user record");
		}
		return user;
	}

	@Override
	public void delete(Integer id) throws Exception {
		try {
			dslContext.delete(User.USER).where(User.USER.ID.eq(UInteger.valueOf(id))).execute();
		}catch (Exception e) {
			throw new Exception("Dao error while deleting user record by id");
		}
	}

}
