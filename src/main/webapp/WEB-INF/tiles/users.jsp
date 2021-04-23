<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
      <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd"> 
     <c:set var="contextRoot" value="${pageContext.request.contextPath}"/>
    
<div class="container">
<h4>All Users</h4>
    <table class="table table-bordered">
    <thead>
    <tr>
      <th>Name</th>
       <th>Email</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="user" items="${users}" >
   <tr>
      <td><c:out value="${user.userName}"/></td>
      <td><c:out value="${user.email}"/></td>
    </tr>
     </c:forEach>
     </tbody>
</table>
</div>


