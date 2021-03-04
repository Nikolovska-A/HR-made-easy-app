<%@ include file="common/header.jspf"%>
<%@ include file="common/footer.jspf"%>
<%@ include file="menu.jsp"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

<input type="text" id="myInput" onkeyup="myFunction()"
	placeholder="Search for names.." title="Type in a name"><i class="fas fa-search"></i>

<table id="myTable"
	class="table-hover table-light table-stripped table-responsive-mds">
	<thead class="table1">
		<tr>
			<td>ID</th>
			<td>First Name</td>
			<td>Last Name</td>
			<td>Phone</td>
			<td>Email</td>
			<td>Job Position</td>
			<td>Actions</td>
			<td></td>
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
				<th><button type="button" class="btn btn-outline-success btn-sm"
						onclick="location.href='/new_employee/view/${employee.id}'">See details</button></th>
				<th><button type="button" class="btn btn-outline-warning btn-sm"
						onclick="location.href='/new_employee/${employee.id}'">Update</button></th>
			<tr />
		</c:forEach>
	</tbody>
</table>
