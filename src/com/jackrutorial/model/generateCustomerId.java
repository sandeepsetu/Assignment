package com.jackrutorial.model;

public class generateCustomerId {
	
	public  static int nextId()
	{
		int id=(int)(1000000000*Math.random());
	
		return id;
	}

}
