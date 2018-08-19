package com.jackrutorial.service;

import java.util.List;

import com.jackrutorial.model.CusromerSer;
import com.jackrutorial.model.Customer;
import com.jackrutorial.model.Service;
import com.jackrutorial.to.CustTo;
import com.jackrutorial.to.RegTo;

public interface CustomerService {
	public  boolean registerCust(Customer c);
	public  boolean verifyUser(String un,String pwd);
	public  boolean verifyUserforFpwd(String un);
	public boolean regeneratepdw(String email,String newpdw);
	//--------------------------------------------------------------------------------------------------
	 public boolean saveCustomer(CustTo cto );
	 public boolean updateCustomer(CustTo cto);
	 public void deleteCustomer(int id);
	 public CustTo findCustomerById(int id); 
		public boolean saveService(String sname,double sprice);
		public List<Service> gerAllService();
		
		 public boolean sendbillCustomer(List<Service> ser,int cid);
		 public List<CusromerSer> gerAllCusromerSerService(String un);
		 public  boolean Paybill(List<CusromerSer> c);
// public List listAllCustomers();
// 
// public void saveOrUpdate(Customer customer);
// 
// public Customer findCustomerById(int id);
// 
// public void deleteCustomer(int id);
}