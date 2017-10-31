package com.irctc.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ticket_table")
public class TravellerDetailsCpy {

	
	@Id
	@GeneratedValue
	@Column(name="user_id")
	private int user_id;
	
	@Column(name="user_name")
	private String user_name;

	@Column(name="age")
	private int age;
	
	@Column(name="gender")
	private String gender;
	
	@Column(name="contact")
	private String contact;
	
	@Column(name="nationality")
	private String nationality;

	@Column(name="login_id")
	private int login_id;
	

	@Column(name="train_id")
	private int train_id;


	public int getUser_id() {
		return user_id;
	}


	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}


	public String getUser_name() {
		return user_name;
	}


	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}


	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}


	public String getGender() {
		return gender;
	}


	public void setGender(String gender) {
		this.gender = gender;
	}


	public String getContact() {
		return contact;
	}


	public void setContact(String contact) {
		this.contact = contact;
	}


	public String getNationality() {
		return nationality;
	}


	public void setNationality(String nationality) {
		this.nationality = nationality;
	}


	public int getLogin_id() {
		return login_id;
	}


	public void setLogin_id(int login_id) {
		this.login_id = login_id;
	}


	public int getTrain_id() {
		return train_id;
	}


	public void setTrain_id(int train_id) {
		this.train_id = train_id;
	}

	
}