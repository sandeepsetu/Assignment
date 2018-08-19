package com.jackrutorial.to;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

public class RegTo {

	private int id;
	private String username;
	private String password;
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
	public RegTo(int id, String username, String password, long ph, String email) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.ph = ph;
		this.email = email;
	}
	public RegTo(String username, String password, long ph, String email) {
		super();
		this.username = username;
		this.password = password;
		this.ph = ph;
		this.email = email;
	}
	public RegTo() {
		super();
	}

}