<%@ include file="common/header.jspf"%>
<%@ include file="common/footer.jspf"%>
<%@ include file="menu.jsp"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<meta name="viewport" content="width=device-width, initial-scale=1">


<input type="text" id="myInput" onkeyup="myFunction()" placeholder="Search for names.." title="Type in a name">

<table id="myTable" class= "table-hover table-light table-stripped table-responsive-mds">
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
				<td>${employee.id}</td>
				<td>${employee.name}</td>
				<td>${employee.surname}</td>
				<td>${employee.phone}</td>
				<td>${employee.email}</td>
				<td>${employee.job_position}</td>
				<td><button type="button" class="btn btn-outline-success"
						onclick="location.href='/new_employee/view/${employee.id}'">See details</button></td>
				<td><button type="button" class="btn btn-outline-warning"
						onclick="location.href='/new_employee/${employee.id}'">Update</button></td>
			<tr />
		</c:forEach>
	</tbody>
</table>
