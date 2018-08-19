package com.jackrutorial.dao;

import java.util.*;



import org.hibernate.Criteria;
import org.hibernate.LockMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.jackrutorial.model.CusromerSer;
import com.jackrutorial.model.Customer;
import com.jackrutorial.model.Registration;
import com.jackrutorial.model.Service;
import com.jackrutorial.model.generateCustomerId;
import com.jackrutorial.to.CustTo;
import com.jackrutorial.to.RegTo;
@Transactional
@Repository
public class CustomerDaoImpl implements CustomerDao {

	@Autowired
	HibernateTemplate htemp;

public boolean verifyUser(String un, String pwd) {
	String hql="from Customer where username=? and password=?";
	List<Registration> list=(List<Registration>) htemp.find(hql,un,pwd);
	int listsize=list.size();
	if(listsize>0)
		return true;
	else
		return false;
	
	
}

@Transactional
public boolean registerCust(Customer c) {
	boolean status=false;
	try
	{
		
	
	htemp.save(c);
	status=true;
	System.out.println("name:"+c.getUsername()+"\t"+"user id"+ c.getId());
	}
	catch(Exception e)
	{	
		e.printStackTrace();
	}
	return status;
	
}

public boolean verifyUserforFpwd(String un) {
	boolean status=false;
	
		String sql="from Registration where email=?";
	List l=htemp.find(sql, un);
	if(l.size()>0)
	{
	status=true;
	}
	return status;
	
}

@Transactional
public boolean regeneratepdw(String email, String newpdw) {
	System.out.println("regeneratepdw() statr");
	boolean status=false;
	
	String sql="from Registration where email=?";
	List l=htemp.find(sql, email);
	if(l.size()>0)
	{
		Registration registration=(Registration)l.get(0);
		//String sql1="update Registration set password=? where email=?";
		registration.setPassword(newpdw);
		htemp.update(registration);
	status=true;
	}
	System.out.println("regeneratepdw() end");
	return status;
	
}


//public boolean updateCustomer(CustTo cto) {
//	
//	
//	boolean status=false;
//	try
//	{
//		
//		Customer c= new Customer(cto.getId(),cto.getFirstname(), cto.getLastname(), cto.getAge(), cto.getGender(), cto.getCity());
//		htemp.update(c);
//	    status=true;
//	}
//	catch(Exception e)
//	{	
//		e.printStackTrace();
//	}
//	return status;
//	
//	
//}

public void deleteCustomer(int id) {
	Customer cust=htemp.get(Customer.class, id);
	if(cust!=null)
	{
		htemp.delete(cust);
	}
	else
	{
		
	}
	
}


@Override
public boolean saveService(String sname, double sprice) {
	boolean status=false;
	try
	{
		
		Service s= new Service(sname, sprice);
		htemp.save(s);
	    status=true;
	}
	catch(Exception e)
	{	
		e.printStackTrace();
	}
	return status;
	
}

@Override
public List<Service> gerAllService() {
	System.out.println("regeneratepdw() statr");
	String sql="from Service";
	List<Service> l=(List<Service>)htemp.find(sql);
	return l;
}
public List<CusromerSer> gerAllCusromerSerService(String un) {
	System.out.println("gerAllCusromerSerService() statr");
	String sql="from Customer where username=?";
	Customer cust=(Customer)htemp.find(sql,un).get(0);
	List<CusromerSer>listcs=cust.getCs();
	List<CusromerSer>listcs1= new ArrayList<CusromerSer>();
	for(CusromerSer cs:listcs)
	{
		if(cs.getStatus().equals("req"))
			listcs1.add(cs);
		System.out.println(cs);
	}
	System.out.println("after cust.getcs()");
//	String sql1="from CusromerSer cs,Customer cu where cs.Status=? and cu.id=?";
//	List<CusromerSer> l=(List<CusromerSer>) htemp.find(sql1,"req",cust.getId());
//	System.out.println(l);
//	System.out.println(l.size());
	return listcs1;
}
@Override
@Transactional
public boolean sendbillCustomer(List<Service> ser, int cid) {
	try {
	List<CusromerSer> custsur=new ArrayList<CusromerSer>();
	Customer cust=htemp.get(Customer.class, cid);
	System.out.println(cust);
	for(Service s:ser)
	{
		CusromerSer cs=new CusromerSer(s.getSname(), s.getPrice(), "req");
		htemp.save(cs);
		
		//custsur.add(cs);
		
	}
	
	String sql="from CusromerSer where Status=?";
	List<CusromerSer> l=(List<CusromerSer>)htemp.find(sql,"req");
	for(CusromerSer cc:l)
	{
      cc.setCustomer(cust);
	}	
    System.out.println(l.size());
	//cust.setCs(l);
	
	
	htemp.update(cust);

	return true;
	}
	catch(Exception e)
	{ System.out.println("inside catch");
		return false;
	}
}

@Override
public  boolean Paybill(List<CusromerSer> c) {
 boolean b=false;
	for(CusromerSer cc:c)
	{
		cc.setStatus("paid");
		htemp.update(cc);
		
	}
	b=true;
	return b;
}




// protected Session getSession(){
//  return sessionFactory.getCurrentSession();
// }
// 
// @SuppressWarnings("unchecked")
// public List listAllCustomers() {
//  Criteria criteria = getSession().createCriteria(Customer.class);
//  return (List) criteria.list();
// }
//
// public void saveOrUpdate(Customer customer) {
//  getSession().saveOrUpdate(customer);
// }
//
// public Customer findCustomerById(int id) {
//  Customer customer = (Customer) getSession().get(Customer.class, id);
//  return customer;
// }
//
// public void deleteCustomer(int id) {
//  Customer customer = (Customer) getSession().get(Customer.class, id);
//  getSession().delete(customer);
// }
 
 
 
}
