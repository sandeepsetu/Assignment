package com.jackrutorial.controller;

import java.util.ArrayList;

import java.util.List;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Multipart;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.servlet.ModelAndView;

import com.jackrutorial.model.CusromerSer;
import com.jackrutorial.model.Customer;
import com.jackrutorial.model.Service;
import com.jackrutorial.model.generateCustomerId;
import com.jackrutorial.service.CustomerService;
import com.jackrutorial.to.CustTo;
import com.jackrutorial.to.RegTo;
@Controller
//@RequestMapping(value="/customer")
public class CustomerController {

 @Autowired
 CustomerService customerService;
 @Autowired
  ApplicationContext ctx;
 
 
 @RequestMapping(value="/forgetpwd.do", method=RequestMethod.GET)
 public String Showpwdpage1()
 {
	 return "fpwdemail";
 }
 
 @RequestMapping(value="/showLogin.do", method=RequestMethod.GET)
 public String ShowLogin()
 {
	 return "login";
 }
 @RequestMapping(value="/logout.do", method=RequestMethod.GET)
 public String logout( HttpServletRequest req)
 {
	 req.getSession().invalidate();
	 
	 return "login";
 }
 
 @RequestMapping(value="/saveService.do", method=RequestMethod.POST)
 public String serviceregistration(HttpServletRequest req)
 {
	 String sname=req.getParameter("sname");
	double sprice=Double.parseDouble(req.getParameter("sprice"));
	
	 
	 
	boolean status= customerService.saveService(sname, sprice);
	if(status)
	{
	req.setAttribute("MSG1","Successful Registration");
	}
	else
	{
		req.setAttribute("MSG1","unsuccessful Registration! try again");
	}
	return "home";	
 }
 
 @RequestMapping(value="/login.do", method=RequestMethod.POST)
 public String verifyUser(HttpServletRequest req)
 {
	 String un=req.getParameter("un");
	 String pwd=req.getParameter("pw");
	 System.out.println("un "+un+" pwd "+pwd);
	 String page="login";
	 if(un.equals("admin") && pwd.equals("admin"))
	 {
	  
			req.setAttribute("MSG1","welcome to home page");
			return "home";	
			
	 }
	 else if(un.equals("se") && pwd.equals("se"))
	 {
		 List<Service> listser=customerService.gerAllService();
			req.getSession().setAttribute("listSer",listser);
			req.setAttribute("MSG1","welcome to home page");
			return "sehome";	
	 }
	 else
	 {
	boolean status =customerService.verifyUser(un, pwd);
	if(status)
	{double total=0;
		List<CusromerSer> csist=customerService.gerAllCusromerSerService(un);
		
		for(Object c:csist)
		{   CusromerSer cs=(CusromerSer)c; 
			total=total+cs.getPrice();
		}
		if(csist.isEmpty())
		{
			req.setAttribute("MSG2","NO BILL AVAILABLE");
		}
		req.setAttribute("TOTAL",total);
		req.getSession().setAttribute("csist",csist);
		
		
	req.setAttribute("MSG1","welcome to home page");
	return "cushome2";	
	}
	else
	{
		req.setAttribute("MSG1","Invalid username and password");
		 return "login";
	}
	}
 }
 
 @RequestMapping(value="/paybill.do", method=RequestMethod.POST)
 public String Paybill(HttpServletRequest req)
 {
	 
	 List<CusromerSer> clist=( List<CusromerSer>)req.getSession().getAttribute("csist");
	 if(clist !=null)
	 {
	boolean b= customerService.Paybill(clist);
	req.getSession().removeAttribute("csist");
	
	
	if(b)
	{
		req.setAttribute("MSG2","Payment successful");
	}
	else
	{
		req.setAttribute("MSG2","Payment unsuccessful");
	}
	 }
	 
	 return "cushome2";
 }
	
 
 @RequestMapping(value="/showsignup.do", method=RequestMethod.GET)
 public String verifyUser()
 {
	
		 return "reg";
	}
	
 @RequestMapping(value="/sendCust.do", method=RequestMethod.POST)
 public String sendBill(HttpServletRequest req)
 {
	 List<Service> lists= new ArrayList<Service>();
	 String sn[]=req.getParameterValues("snpp");
	 for(String ss:sn)
	 {
		System.out.println("s name"+ss);
	 }
	
	 List<Service> listser=( List<Service>)req.getSession().getAttribute("listSer");
	 listser.forEach(System.out::println);
	 System.out.println("list size"+listser.size());
	 double total=0;
	 for(String n:sn)
	 {
		 for(Service ser:listser)
		 {
			 if(n.equals(ser.getSname()))
			 {
				 total=total+ser.getPrice();
				 lists.add(ser);
				 System.out.println("addin to list"+ser);
			 }
			 
		 }
		 
	 }
	req.setAttribute("TOTAL", total);
	req.getSession().setAttribute("listSer2", lists);
	System.out.println("list-------"+lists);
	return "sehome2";	
 }
 
 @RequestMapping(value="/sendCust1.do", method=RequestMethod.POST)
 public String sendBill2(HttpServletRequest req)
 {
	 
	 int cid=Integer.parseInt(req.getParameter("cid"));
	 List<Service> lists=(List<Service>)req.getSession().getAttribute("listSer2");
	 boolean status= customerService.sendbillCustomer(lists, cid);
	 	if(status)
	 	{
	 	req.setAttribute("MSG1","Successful bill sends");
	 	}
	 	else
	 	{
	 		req.setAttribute("MSG1","unsuccessful Registration! try again");
	 	}
	
	return "sehome";	
 }
 @RequestMapping(value="/reg.do", method=RequestMethod.POST)
 public String registration(HttpServletRequest req)
 {
	 

	 String fn=req.getParameter("fn");
	 String ln=req.getParameter("ln");
	 String un=req.getParameter("un");
	 String pwd=req.getParameter("pw");
	 String eml=req.getParameter("em");
	 long ph=Long.parseLong(req.getParameter("ph"));
	 
	 Customer c= new Customer(generateCustomerId.nextId(), fn, ln, un, pwd);
	boolean status= customerService.registerCust(c);
	if(status)
	{
	req.setAttribute("MSG1","Successful Registration");
	}
	else
	{
		req.setAttribute("MSG1","unsuccessful Registration! try again");
	}
	return "reg";	
 }
 
 //----------------------------------------------------------------------------------------------------------------
 
 @RequestMapping(value="/show.do", method=RequestMethod.GET)
 public String showCustallPage(HttpServletRequest req)
 {
	 String page=req.getParameter("page");
	 if(page.equals("addcust"))
	     return "addcust";
	 else  if(page.equals("updatecust"))
		 return "";
	 else  if(page.equals("deletecust"))
		 return "";
	 else  if(page.equals("getcust"))
		 return "getcust";
	 else
		 return "";
	
 }

	 
	 
@RequestMapping(value="/getdataupdate.do", method=RequestMethod.GET)
 public String getCustomerByCidforUpdate(HttpServletRequest req)
 {
	 int id=Integer.parseInt(req.getParameter("id"));
	CustTo cto= customerService.findCustomerById(id);
	String page="";
	if(cto!=null)
	{
		req.setAttribute("CUST1",cto);
	
	   page="getcust";
	}
	else
	{
		req.setAttribute("MSG1","Custoner "+id+" Not found");
		 page="getcust";
	}
	return page	;
 }
 @RequestMapping(value="/getcust1.do", method=RequestMethod.POST)
 public String getCustomerByCid(HttpServletRequest req)
 {
	 int id=Integer.parseInt(req.getParameter("id"));
	CustTo cto= customerService.findCustomerById(id);
	String page="";
	if(cto!=null)
	{
		req.setAttribute("CUST",cto);
	
	   page="getcust";
	}
	else
	{
		req.setAttribute("MSG1","Custoner "+id+" Not found");
		 page="getcust";
	}
	return page	;
 }
 
 @RequestMapping(value="/addcust.do", method=RequestMethod.POST)
 public String saveCustomer(HttpServletRequest req)
 {
	 String fn=req.getParameter("fn");
	 String ln=req.getParameter("ln");
	 int age=Integer.parseInt(req.getParameter("age"));
	 String gen=req.getParameter("gender");
	 String city=req.getParameter("city");
	
	 
	 System.out.println("un "+fn+" pwd "+ln+"ph"+age+"gender"+gen+"city"+city);
	CustTo cto= new CustTo(fn, ln, age, gen, city);
	boolean status= customerService.saveCustomer(cto);
	if(status)
	{
	req.setAttribute("MSG1","Successful added");
	}
	else
	{
		req.setAttribute("MSG1","unsuccessful added! try again");
	}
	return "reg";	
 }
 
 @RequestMapping(value="/updatecust.do", method=RequestMethod.POST)
 public String updateCustomer(HttpServletRequest req)
 {
	 
	 int id=Integer.parseInt(req.getParameter("id"));
	 String fn=req.getParameter("fn");
	 String ln=req.getParameter("ln");
	 int age=Integer.parseInt(req.getParameter("age"));
	 String gen=req.getParameter("gender");
	 String city=req.getParameter("city");
	
	 
	 System.out.println("id"+id+"un "+fn+" pwd "+ln+"ph"+age+"gender"+gen+"city"+city);
	CustTo cto= new CustTo(id,fn, ln, age, gen, city);
	boolean status= customerService.updateCustomer(cto);
	if(status)
	{
	req.setAttribute("MSG1","Successful updated");
	}
	else
	{
		req.setAttribute("MSG1","unsuccessful updated! try again");
	}
	return "getcust";	
 }
 
 
 
// @RequestMapping(value="/list", method=RequestMethod.GET)
// public ModelAndView list(){
//  ModelAndView model = new ModelAndView("customer/list");
//  List list = customerService.listAllCustomers();
//  model.addObject("list", list);
//  
//  return model;
// }
// 
// @RequestMapping(value="/update/{id}", method=RequestMethod.GET)
// public ModelAndView update(@PathVariable("id") int id){
//  ModelAndView model = new ModelAndView("customer/form");
//  Customer customer = customerService.findCustomerById(id);
//  model.addObject("customerForm", customer);
//  
//  return model;
// }
// 
// @RequestMapping(value="/delete/{id}", method=RequestMethod.GET)
// public ModelAndView delete(@PathVariable("id") int id){
//  customerService.deleteCustomer(id);
//  
//  return new ModelAndView("redirect:/customer/list");
// }
// 
// @RequestMapping(value="/add", method=RequestMethod.GET)
// public ModelAndView add(){
//  ModelAndView model = new ModelAndView("customer/form");
//  Customer customer = new Customer();
//  model.addObject("customerForm", customer);
//  
//  return model;
// }
// 
// @RequestMapping(value="/showhome", method=RequestMethod.GET)
// public String showhomepage( HttpServletRequest req){
//	 Customer c= new Customer();
//	 req.setAttribute("customerForm", c);
//  
//  return "/customer/form";
// 
// }
// @RequestMapping(value="/save", method=RequestMethod.POST)
// public ModelAndView save(@ModelAttribute("customerForm") Customer customer){
//  customerService.saveOrUpdate(customer);
//  
//  return new ModelAndView("redirect:/customer/list");
// }
}
