package com.jackrutorial.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "customer")
public class Customer {

	
	// @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Column(name="cid")
	private int id;

	private String firstname;
	private String lastname;
	
	private String username;
	private String password;
	// @Column(name = "lastname")
	@OneToMany(mappedBy = "customer")
	List<CusromerSer> cs;
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
	public List<CusromerSer> getCs() {
		return cs;
	}
	public void setCs(List<CusromerSer> cs) {
		this.cs = cs;
	}
	public Customer(int id, String firstname, String lastname, String username, String password,
			List<CusromerSer> cs) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
	
		this.username = username;
		this.password = password;
		this.cs = cs;
	}
	public Customer() {
		super();
	}
	@Override
	public String toString() {
		return "Customer [id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + ", username=" + username + ", password=" + password + ", cs=" + cs + "]";
	}
	public Customer(int id, String firstname, String lastname, String username, String password) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.username = username;
		this.password = password;
	}

	

}