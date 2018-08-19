package com.jackrutorial.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="regis")
public class Registration {

 @Id
 @GeneratedValue(strategy = GenerationType.AUTO)
 private int id;
 
 //@Column(name = "firstname")
 private String username;
 
// @Column(name = "lastname")
 private String password;
 
 //@Column(name = "gender")
 private long ph;
 
 private String email;

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public String getUsername() {
	return username;
}

public void setUsername(String username) {
	this.username = username;
}

public String getPassword() {
	return password;
}

public void setPassword(String password) {
	this.password = password;
}

public long getPh() {
	return ph;
}

public void setPh(long ph) {
	this.ph = ph;
}

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}

public Registration(int id, String username, String password, long ph, String email) {
	super();
	this.id = id;
	this.username = username;
	this.password = password;
	this.ph = ph;
	this.email = email;
}

public Registration() {
	super();
}

public Registration(String username, String password, long ph, String email) {
	super();
	this.username = username;
	this.password = password;
	this.ph = ph;
	this.email = email;
}


 
 
}