package com.irctc.model;

import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

import com.owlike.genson.annotation.JsonIgnore;

@Entity
@Table(name="login_table")
public class User {
	
	@Id
	@GeneratedValue
	@JoinColumn(name="login_id")
	private int login_id;
	
	@Column(name="name")	
	private String name;
	
	@Column(name="email")	
	private String email;
	
	@Column(name="password")	
	private String password;
	
	public int getLogin_id() {
		return login_id;
	}

	public void setLogin_id(int login_id) {
		this.login_id = login_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}

