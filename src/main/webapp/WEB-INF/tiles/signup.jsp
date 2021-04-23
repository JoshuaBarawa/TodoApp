<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
    <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
    
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/signup.css">
    
    <div class="center">
    
    <form:form action="/user/signup" method="post" modelAttribute="user" >
      	
				<h2 class="sign">Sign Up</h2>
      	
      	<div class="form-group">
			<label for="username">UserName</label>
                <form:input type="text" class="form-control" path="userName" required="sdks" /> 	
        </div>
      		
		   <div class="form-group">
			<label  for="email">Email Address</label>
                <form:input type="email" class="form-control" path="email" required="sdks"/>
            </div>        	
     
			<div class="form-group">
			<label for="pass">Password</label>
                <form:input type="password" class="form-control" path="password" required="sdks"/>
              </div>
              
       <div class="reset"><a href="${pageContext.request.contextPath}/reset">Forgot Password?</a></div>
          
	<input type="submit" value="Sign Up" class="btn"/>		      
    </form:form>
	<div class="text-center">Already have an account? <a href="${pageContext.request.contextPath}/login">Login</a></div>
</div>