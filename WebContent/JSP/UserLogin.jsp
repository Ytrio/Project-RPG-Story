<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="com.br.RpgStory.user.User" import="java.io.IOException"
		import="java.io.PrintWriter" import="java.sql.Connection"
		import="java.sql.PreparedStatement" import="java.sql.ResultSet"
		import="java.sql.SQLException" import="javax.servlet.ServletException"
		import="javax.servlet.http.HttpServlet"
		import="javax.servlet.http.HttpServletRequest"
		import="javax.servlet.http.HttpServletResponse"
		import="com.br.RpgStory.user.UserDAO"
		import="com.br.RpgStory.main.ApplicationMain_UserRegister"
		import="com.br.RpgStory.main.ApplicationMain_UserLogin"
%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <script type="text/javascript" src="../JavaScript/check.js"></script>
	<link href="../CSS/StyleLogin.css" rel="stylesheet" type="text/css" media="screen" charset="UTF-8"/>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Login usuário</title>
</head>
<body>
<script type="text/javascript">
   window.onload = function(){
	   <%
	     User logins = new User();
	     String user  =  (String) request.getAttribute("login");
	     logins.setUser(user);
	     //System.out.println(logins.getUser());
	    if(user== null || logins.getUser().equals("not registered")){
	         out.print("document.getElementById('GetName').focus()");
	     } else {
	    	 out.print("document.getElementById('GetPassword').focus()"); 
	     }
	   %>
   }
</script>

<c:import url="LogoMarca.html"/> 
		<div class="StyleFrameDiv">
		       <% 
		   			 if(request.getAttribute("msgErro")!=null) {
			       		 out.print("<div class='DivAcessDenied'>");
			             out.print("<span class='SpanAcessDenied'><img src='Imagens/error.png' height='16px' width='16px'/>"+request.getAttribute("msgErro")+"</span>"); 			   
			     		 out.print("</div>");
		   			 }
		     	%>
			<h2  class="StyleH2">Access your Account</h2>
			<div class="PainelCreateAcc">
			<div class="StyleDivAlign">
			<label class="LabelCreatorAcc">Create your account</label>	
			<p class="StyleParaGafh"> 
				Create your account to access the 
				system exclusive to our site only 
				for registered users on our web site.
            </p>
            </div>
            <input type="button" value="Create your account" class="ButtonCreateAcc" onclick="javascript:location.href='Sign-in.html' " title="Create your account now"/>
			</div>

			<form name="form1" action="../ServletStoryRpg_Login" method="post" class="StyleForm1" onsubmit="return CheckDate(form1);">
			<div id="User" class="User"  style = "color:green; font-weight:700;  display:block;">
					<% 
					     User login = new User();
					     String username  =  (String) request.getAttribute("login");
					     String name      =  (String) request.getAttribute("name");
					     if(username!= null) {
					    	  
					    	 if(name == null) {name = "";}
							    	login.setUser (username);
						 	    	out.print("<span style='margin-left:25px;text-transform:capitalize;'>"+name+" "+login.getUser()+"</span>");
						 }
					%>
				</div>	
				<label class="StyleLabelName" >Username:</label>
				<input type="text" id="GetName" name="GetName" class="StyleInputName" placeholder="Username" title="Enter your username"/>
				<p id="erro1" class="erro1"> </p>
				<label class="StyleLabelPassword">Password:</label>
				<input type="password" id="GetPassword" name="GetPassword" class="StyleInputPSW"  placeholder="Password" title="Enter your password"/>
				<p id="erro2" class="erro2"> </p>
				<input type="submit"  class="ButtonSubmitSend" value="Sign-in" title="sending Data"/>
				<input type="reset"   class="ButtonClear" value="Clear" title="clear dates"/>
				<a class = "Link_LostPSW" href="#">Lost in password?</a>
			    <a class = "Link_UserPSW" href="#"> Lost in username?</a>
			</form>
		</div>
	</body>
</html>