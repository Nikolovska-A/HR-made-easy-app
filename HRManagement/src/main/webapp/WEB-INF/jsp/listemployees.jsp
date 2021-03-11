<%@ include file="common/header.jspf"%>
<%@ include file="common/footer.jspf"%>
<%@ include file="menu.jsp"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">


<html>
<head>
<title>tableToExcel Demo</title>
<script>
	var tableToExcel = (function() {
		var uri = 'data:application/vnd.ms-excel;base64,', template = '<html xmlns:o="urn:schemas-microsoft-com:office:office" xmlns:x="urn:schemas-microsoft-com:office:excel" xmlns="http://www.w3.org/TR/REC-html40"><head><!--[if gte mso 9]><xml><x:ExcelWorkbook><x:ExcelWorksheets><x:ExcelWorksheet><x:Name>{worksheet}</x:Name><x:WorksheetOptions><x:DisplayGridlines/></x:WorksheetOptions></x:ExcelWorksheet></x:ExcelWorksheets></x:ExcelWorkbook></xml><![endif]--></head><body><table>{table}</table></body></html>', base64 = function(
				s) {
			return window.btoa(unescape(encodeURIComponent(s)))
		}, format = function(s, c) {
			return s.replace(/{(\w+)}/g, function(m, p) {
				return c[p];
			})
		}
		return function(table, name) {
			if (!table.nodeType)
				table = document.getElementById(table)
			var ctx = {
				worksheet : name || 'Worksheet',
				table : table.innerHTML
			}
			window.location.href = uri + base64(format(template, ctx))
		}
	})()
</script>
</head>
<body>



	<input type="text" id="myInput" onkeyup="myFunction()"
		placeholder="Search for names.." title="Type in a name">
	<i class="fas fa-search"></i>
	<caption>
		<table id="myTable"
			class="table-hover table-light table-stripped table-responsive-mds tabela1">
			<thead class="table1">
				<tr>
					<td>ID
					</th>
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
						<th><button type="button"
								class="btn btn-outline-success btn-sm"
								onclick="location.href='/new_employee/view/${employee.id}'">See
								details</button></th>
						<th><button type="button"
								class="btn btn-outline-warning btn-sm"
								onclick="location.href='/new_employee/${employee.id}'">Update</button></th>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</caption>
	<input type="button"
		onclick="tableToExcel('myTable', 'W3C Example Table')"
		value="Export to Excel">
	<table id="testTable"
		summary="Code page support in different versions of MS Windows."
		rules="groups" frame="hsides" border="2">
		<caption>