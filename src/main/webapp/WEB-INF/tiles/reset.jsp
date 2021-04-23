<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd"> 

<div class="container">

<div style="color:green"><c:out value="${msg}"></c:out></div>
   <div style="color:red"><c:out value="${error}"></c:out></div>
   <form action="/reset" method="post">
 
        <div class="form-group" style="width: 50%">
            <input type="text" name="email" class="form-control" placeholder="Enter Email" required="">
        </div>
    
        <div class="form-group">
            <input type="submit" value="Reset" class="btn" style="background: #00BFFF"/>
        </div> 
   
    </form>
 
</div>

