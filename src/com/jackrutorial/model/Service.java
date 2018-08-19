package com.jackrutorial.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class Service {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int sid;
	private String sname;
	private double price;
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
	public Service(int sid, String sname, double price) {
		super();
		this.sid = sid;
		this.sname = sname;
		this.price = price;
	}
	public Service(String sname, double price) {
		super();
		this.sname = sname;
		this.price = price;
	}
	public Service() {
		super();
	}
	@Override
	public String toString() {
		return "Service [sid=" + sid + ", sname=" + sname + ", price=" + price + "]";
	}
	
	
	
}
