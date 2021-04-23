<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
      <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd"> 
   
   <div class="container">
   
   <div style="color:green">
   <c:out value="${msg}"></c:out>
   </div>
   
   <form:form action="/updateuser"  modelAttribute="user" method="post">

  <div class="form-group">
    <label for="name">User Name</label>
    <form:input path="userName" type="text" class="form-control" required="wkdd"/>
  </div>
 
  <div class="form-group">
    <label for="email">Email</label>
    <form:input path="email" type="text" class="form-control" required="wkdd"/>
  </div>

<div class="form-group">
    <label for="tarDate">Password</label>
    <form:input path="password" type="password" class="form-control" required="wkdd"/>
  </div>
  
   <input type="submit" class="btn btn-primary" value="Update"/>
</form:form>
</div>
