<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
    <%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %> 
      <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd"> 
     <c:set var="contextRoot" value="${pageContext.request.contextPath}"/>
    
     <sec:authorize access="hasAuthority('ADMIN')"> 
    Hi ADMIN
    </sec:authorize>
    
    <sec:authorize access="hasAuthority('USER')"> 
   <div class="container">
   <form:form action="/addtodo"  modelAttribute="todo" method="post">
   
  <div class="form-group">
    <label for="name">Name</label>
    <form:input path="name" type="text" class="form-control" required="wkdd"/>
  </div>
 
  <div class="form-group">
    <label for="tarDate">Target Date</label>
    <form:input path="targetDate" type="date" class="form-control" required="wkdd"/>
  </div>

  
   <input type="submit" class="btn btn-primary" value="Add"/>
</form:form>
</div>

<div class="container">
    <table class="table table-bordered">
    <thead>
    <tr>
      <th style="width:20%">Name</th>
      <th style="width:20%">Target_Date</th>
      <th style="width:20%">Actions</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="todo" items="${todoList}" >
   <tr>
      <td><c:out value="${todo.name}"/></td>
      <td><c:out value="${todo.targetDate}"/></td>
      <td>
        <a class="table-links" href="${contextRoot}/updatetodo/${todo.id}">Edit</a> |
        <a class="table-links" href="${contextRoot}/deletetodo/${todo.id}">Delete</a>
      
      </td>
    </tr>
     </c:forEach>
     </tbody>
</table>
</div>
</sec:authorize>

