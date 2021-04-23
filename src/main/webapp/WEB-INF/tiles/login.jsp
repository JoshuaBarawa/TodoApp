<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

   <link href="${pageContext.request.contextPath}/css/login.css" rel="stylesheet"> 

<div class="container">
   <form action="/login" method="post">
 
        <h2 class="text-center">Log in</h2> 
        
        <c:if test="${param.error != null }">
<div class="login-error" style="color: red">Incorrect username or password</div>
</c:if>      
        <div class="form-group">
            <input type="text" name="username" class="form-control" placeholder="Email">
        </div>
        <div class="form-group">
            <input type="password" name="password" class="form-control" placeholder="Password">
        </div>
        <div class="form-group">
            <input type="submit" value="Log in" class="btn"/>
        </div> 
    
        <p><a class="link" href="${pageContext.request.contextPath}/user/signup">Create an Account</a></p>  
   
    </form>
    
</div>

