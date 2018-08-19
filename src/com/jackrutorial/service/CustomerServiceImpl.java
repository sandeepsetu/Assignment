package com.jackrutorial.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jackrutorial.dao.CustomerDao;
import com.jackrutorial.model.*;
import com.jackrutorial.to.CustTo;
import com.jackrutorial.to.RegTo;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {
	 
 @Autowired
 CustomerDao customerDao;

	public  boolean registerCust(Customer c) {
	
	return customerDao.registerCust(c) ;
}

public boolean verifyUser(String un, String pwd) {
	// TODO Auto-generated method stub
	return customerDao.verifyUser(un, pwd);
}

public boolean verifyUserforFpwd(String un) {
	
	return customerDao.verifyUserforFpwd(un);
}



public boolean regeneratepdw(String email, String newpdw) {
	// TODO Auto-generated method stub
	return customerDao.regeneratepdw(email, newpdw);
}
//----------------------------------------------------------------------------------------
//public boolean saveCustomer(Customer c) {
//return	customerDao.saveCustomer(c);
//	
//}
//
//public boolean updateCustomer(CustTo cto) {
//return	customerDao.updateCustomer(cto);
//	
//}
//
//public void deleteCustomer(int id) {
//	customerDao.deleteCustomer(id);
//	
//}
//
//public CustTo findCustomerById(int id) {
//	
//	return customerDao.findCustomerById(id);
//}

@Override
public boolean saveService(String sname, double sprice) {
	// TODO Auto-generated method stub
	return customerDao.saveService(sname, sprice);
}

@Override
public List<com.jackrutorial.model.Service> gerAllService() {
	
	return customerDao.gerAllService();
}

@Override
public boolean sendbillCustomer(List<com.jackrutorial.model.Service> ser, int cid) {
	// TODO Auto-generated method stub
	return customerDao.sendbillCustomer(ser, cid);
}

@Override
public boolean saveCustomer(CustTo cto) {
	// TODO Auto-generated method stub
	return false;
}

@Override
public boolean updateCustomer(CustTo cto) {
	// TODO Auto-generated method stub
	return false;
}

@Override
public void deleteCustomer(int id) {
	// TODO Auto-generated method stub
	
}

@Override
public CustTo findCustomerById(int id) {
	// TODO Auto-generated method stub
	return null;
}

@Override
public List<CusromerSer> gerAllCusromerSerService(String un) {
	// TODO Auto-generated method stub
	return customerDao.gerAllCusromerSerService(un);
}

@Override
public boolean Paybill(List<CusromerSer> c) {
	// TODO Auto-generated method stub
	return customerDao.Paybill(c);
}



 
// public List listAllCustomers() {
//  return customerDao.listAllCustomers();
// }
//
// public void saveOrUpdate(Customer customer) {
//  customerDao.saveOrUpdate(customer);
// }
//
// public Customer findCustomerById(int id) {
//  return customerDao.findCustomerById(id);
// }
//
// public void deleteCustomer(int id) {
//  customerDao.deleteCustomer(id);
// }

}