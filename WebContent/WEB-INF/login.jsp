<%@ page language="java"  isELIgnored="false" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<html>
<head>
	<title></title>
	<style type="text/css">
		div.mn {
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
	   Sfg:hover {
			color:#99ff88;

		}
	</style>
</head>

<body style="background-color:darkslategray">

<div class="header" style="background-color:black;border:1px solid black;text-align:center;height:5%;">
<p style="color: red;margin-top:0.60%";fon>LOGIN TO YOUR ACCOUNT 

</p>
</div>
   <div style="text-align: center;color: green">${MSG1}</div>                          
<div class="mn" style="margin-top:10%">                     
<!--  <label style="color: red;">LoGIN To YOUR ACCOUNT </label>--> <br>
	<form action="login.do" method="POST">
	
	<input class="aa" type="text" name="un" placeholder="username" required><br>
	
	<input class="aa"  type="password" name="pw" placeholder="password"  required><br>
	<input id="as" type="submit" name="" value="LOGIN NOW!">
		
	</form>

	<label><a class="fg" href="#"> FORGET YOUR PASSWORD</a></label><br>
	<label>Not a Member yet?</label><br>
	<label><a class="fg" href="showsignup.do"> SIGNUP NOW!</a></label><br>
	


</div>
<div class="footer" style="margin-top:13%;background-color:black;border:1px solid black;height:5%;">
<p style="color: white;margin-top:0.60%;text-align:left;margin-left:5%">Develope By Sandeep
<span style="color: white;margin-left:30%">Develope On 16/08/2018</span>
<span style="color: white;margin-top:0.60%;margin-left:25.34%">Designed BySandeep</span>


 </p>
</div>
</body>
</html>