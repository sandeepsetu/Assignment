package com.jackrutorial.to;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


public class CustTo {
	private int id;

	 private String firstname;
	 private String lastname;
	 private int age;
	 private String gender;
	 private String city;



public CustTo(String firstname, String lastname, int age, String gender, String city) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.age = age;
		this.gender = gender;
		this.city = city;
	}



public CustTo(int id, String firstname, String lastname, int age, String gender, String city) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.age = age;
		this.gender = gender;
		this.city = city;
	}



@Override
	public String toString() {
		return "CustTo [id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + ", age=" + age + ", gender="
				+ gender + ", city=" + city + "]";
	}



public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getFirstname() {
		return firstname;
	}



	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}



	public String getLastname() {
		return lastname;
	}



	public void setLastname(String lastname) {
		this.lastname = lastname;
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



	public String getCity() {
		return city;
	}



	public void setCity(String city) {
		this.city = city;
	}



public CustTo() {
	super();
}
 
 
 
 
 
 
 
 
 
 
 
}