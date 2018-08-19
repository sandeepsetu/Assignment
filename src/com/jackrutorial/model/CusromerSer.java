package com.jackrutorial.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
@Entity
public class CusromerSer {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private int sid;
private String sname;
private double price;
private String Status;
@ManyToOne
@JoinColumn(name="cid",referencedColumnName="cid")
private Customer customer;

public Customer getCustomer() {
	return customer;
}
public void setCustomer(Customer customer) {
	this.customer = customer;
}
public int getSid() {
	return sid;
}
public void setSid(int sid) {
	this.sid = sid;
}
public String getSname() {
	return sname;
}
public void setSname(String sname) {
	this.sname = sname;
}
public double getPrice() {
	return price;
}
public void setPrice(double price) {
	this.price = price;
}
public String getStatus() {
	return Status;
}
public void setStatus(String status) {
	Status = status;
}
public CusromerSer(int sid, String sname, double price, String status) {
	super();
	this.sid = sid;
	this.sname = sname;
	this.price = price;
	Status = status;
}
public CusromerSer(String sname, double price, String status) {
	super();
	this.sname = sname;
	this.price = price;
	Status = status;
}
public CusromerSer() {
	super();
}
@Override
public String toString() {
	return "CusromerSer [sid=" + sid + ", sname=" + sname + ", price=" + price + ", Status=" + Status ;
}

	
}
