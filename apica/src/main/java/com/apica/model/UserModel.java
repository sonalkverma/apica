package com.apica.model;

import java.util.Date;

import jakarta.persistence.Column;
import lombok.Data;

@Data
public class UserModel {

	@Column(name = "id")
	private Integer id;
	
	@Column(name = "user_name")
	private String userName;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "phone")
	private String phone;
	
	@Column(name = "updated_count")
	private Integer updatedCount;
	
	@Column(name = "created_by")
	private Integer createdBy;
	
	@Column(name = "created_date")
	private Date createdDate;
	
	@Column(name = "updated_by")
	private Integer updatedBy;
	
	@Column(name = "updated_date")
	private Date updatedDate;

}
