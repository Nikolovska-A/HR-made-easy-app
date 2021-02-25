<%@ include file="common/header.jspf"%>
<%@ include file="common/footer.jspf"%>
<%@ include file="menu.jsp"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

<input type="text" id="myInput" onkeyup="myFunction()"
	placeholder="Search for names.." title="Type in a name">

<table id="myTable"
	class="table-hover table-light table-bordered table-responsive-mds">
	<thead class="table1">
		<tr>
			<th>First name</th>
			<th>Last name</th>
			<th>Description</th>
			<th></th>

		</tr>
	</thead>
	<tbody>
		<c:forEach items="${files}" var="files">
			<tr>
				<th>${files.employee.getName()}</th>
				<th>${files.employee.getSurname()}</th>
				<th>${files.getName()}</th>
				
				<th><a  target = "_blank" type="button" class= "btn btn-outline-danger"
						href= "${files.getUrl()}"><i class="fa fa-download"></i> Download</a></th>

			</tr>
		</c:forEach>
	</tbody>
</table>