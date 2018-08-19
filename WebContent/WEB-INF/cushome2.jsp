<%@ page language="java"  isELIgnored="false" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="com.jackrutorial.model.*,java.util.*"%>
   <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>  
<style type="text/css">

		div.mn
		 {
			border:1px solid red;
			width: 25%;
			/*border-radius: 10px 10px;*/
			text-align: center;
			line-height: 30px;
			position: relative;
			    right: -36%;
			color:#ff8627; 
			background-color:#b79fbf40;   
			border-color:blue;
			border-bottom-left-radius: 103px;
			border-top-right-radius: 103px;	    
		}
		.mi {
			display: inline-block;
			position: relative;
			border:1px solid black;

			width:30px;
			height: 20px;
			  bottom: -5px;
			  margin:10px;
		}
		input[type="submit"] {
		/*	background-color: #99ff88;*/
    color: #ffffff;
    padding: 10px;
    width: 90%;
    border:none;
    background-color:black;
    border-radius:38px;
  /*  border-radius: 10px 10px;*/
    margin-bottom: 10px;
    cursor:pointer;
		}
		#as:hover {
			/*background-color: red;*/

		}
		input.aa {
			height: 25px;
			width: 200px;
			/*border-radius: 10px 10px;*/
			margin-bottom: 10px;
			color:#ff8627;
			height:40px;
		}
		.sup {
			border-radius: 10px 10px;
			width: 110px;
			height: 25px;
			text-align: center;
			 color: #ffffff;
			background-color: #ff8627;
			margin-bottom: 10px;
		}
		.sup:hover {
		
			background-color: #99ff88;
		}
		.fg {
			color:#ff8627;

		}
		.fg:hover {
			color:#99ff88;

		}
	</style>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>


<body style="background-color:darkslategray">
<div class="header" style="background-color:black;border:1px solid black;text-align:center;height:5%;">
<p style="color: red;margin-top:0.60%";fon>SHOW CUSTOMER SERVICE
<a href="logout.do" STYLE="COLOR:RED;margin-left:40%">LOGOUT</a>
 </p>
</div>

   <label style="color:red">    ${MSG2}</label>
<%
List<CusromerSer> list=(List<CusromerSer>)request.getSession().getAttribute("csist");
if(list !=null)
{
%>
<form  name="listForm" action="paybill.do" method="post">
<table border="1" style="margin-left:41%;border-collapse: collapse;margin-top:9%">
 <tr></tr>
 <tr>
  <td style="background-color:lime">Service Name</td>
<td style="background-color:lime">Service Price</td>
  
    
         </tr>
         <c:forEach var="CUST" items="${csist}">
          <tr>
          
         <td> <label></label>${CUST.sname}</td>
          <td><label></label>${CUST.price}</td>
         </tr>
          
         </c:forEach>
        
         <tr>
         <td><label>Total Amnt:</label></td>
           <td>${TOTAL}</td>
         </tr>
         <tr rowspan="2">
         <td >
<lable >Payment Type</lable>
</td>
<td >

</td>
         </tr>
<tr>

<td>

 <input type="radio" value="Self" name="self" id="self">Self</input>
 </td>
 <td>
  <input type="radio" value="Pay" name="self" id="pay">Insurance</input>
  </td>
</tr>
<tr>

</tr>
 <tr> 
 <td>
  <input type="submit" value="PAY" onsubmit="retuen validate()">
  </td>
</tr>
   </table>
<%
}
%>

  </form>
<div class="footer" style="margin-top:40%;background-color:black;border:1px solid black;height:5%;">
<p style="color: white;margin-top:0.60%;text-align:left;margin-left:5%">Develope By Sandeep
<span style="color: white;margin-left:30%">Develope On 16/08/2018</span>
<span style="color: white;margin-top:0.60%;margin-left:25.34%">Designed BySandeep</span>

 </p>
</div>
<script type="text/javascript">
function validate()
{
var radio1=document.getElementById('self').checked;
var radio2=document.getElementById('pay').checked;

if((radio1=="")&&(radio2==""))
{
alert("Please Select Atleast Any One Payment Method")
return false;
}
return true;
}
</script>


</body>
</html>