<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
  <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
     <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
   <c:set var="contextRoot" value="${pageContext.request.contextPath}"/>
     
   
   <div class="container">
   <form:form action="${contextRoot}/updatetodo/${todo.id}" modelAttribute="todo" method="post">
   
  <div class="form-group">
    <label for="name">Name</label>
    <form:input path="name" type="text" class="form-control" id="name"/><br/>
  </div>
  
  <div class="form-group">
    <label for="targetDate">Target Date</label>
    <form:input path="targetDate" type="date" class="form-control" id="date"/><br/>
  </div>
  
   <input type="submit" class="btn btn-primary" value="Update"/>
</form:form>

</div> 