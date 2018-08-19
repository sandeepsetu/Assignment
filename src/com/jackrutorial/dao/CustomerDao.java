package com.jackrutorial.dao;

import java.util.List;

import com.jackrutorial.model.CusromerSer;
import com.jackrutorial.model.Customer;
import com.jackrutorial.model.Service;
import com.jackrutorial.to.CustTo;
import com.jackrutorial.to.RegTo;

public interface CustomerDao {
 
// public List listAllCustomers();
// 
 
	//-----------------------------------------------------------------------------------
	public  boolean verifyUser(String un,String pwd);
	public  boolean registerCust(Customer c);
	public  boolean verifyUserforFpwd(String un);
	public boolean regeneratepdw(String email,String newpdw);
	public boolean saveService(String sname,double sprice);
	public List<Service> gerAllService();
	 public boolean sendbillCustomer(List<Service> ser,int cid);
	 public List<CusromerSer> gerAllCusromerSerService(String un);
		public  boolean Paybill(List<CusromerSer> c);
	
 
}