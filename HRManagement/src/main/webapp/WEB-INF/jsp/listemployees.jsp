<%@ include file="common/header.jspf" %>
<%@ include file="menu.jsp"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<head>
<link rel="stylesheet" type="text/css" href="navbar.css">
</head>

<table class = "table table-hover table-light table-bordered table-responsive-mds">
   <thead class="table1">
    <tr>
     <th>ID</th>
   	 <th>First Name</th>
   	 <th>Last Name</th>
   	 <th>Phone</th>
   	 <th>Email</th>
   	 <th>Job Position</th>
   	 <th></th>
   	 <th></th>
    </tr>
   </thead>
   <tbody>
   	<c:forEach items="${employees}" var="employee">
   	<tr>
	    <th>${employee.id}</th>
	    <th>${employee.name}</th>
	    <th>${employee.surname}</th>
	    <th>${employee.phone}</th>
	    <th>${employee.email}</th>
		<th>${employee.job_position}</th> 
	    <th><button type="button"  class="btn btn-primary"  onclick="location.href='/new_employee/${employee.id}'">See details </button></th>
	    <th><button type="button"  class="btn btn-primary"  onclick="location.href='/new_employee/${employee.id}'">Update</button></th>
    <tr/>
    </c:forEach>
 </tbody>
 </table>
