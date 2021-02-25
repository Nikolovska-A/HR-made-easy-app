<%@ include file="common/header.jspf"%>
<%@ include file="common/footer.jspf"%>
<%@ include file="menu.jsp"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<meta name="viewport" content="width=device-width, initial-scale=1">


<input type="text" id="myInput" onkeyup="myFunction()" placeholder="Search for names.." title="Type in a name">

<table id="myTable" class= "table-hover table-light table-bordered table-responsive-mds">
  <thead class="table1">
		<tr>
			<th>ID</th>
			<th>First name</th>
			<th>Last name</th>
			<th>Start date</th>
			<th>End date</th>
			<th></th>
			<th></th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${vacations}" var="vacations">
			<tr>
				<th>${vacations.id}</th>
				<th>${vacations.employee_id.getName()}</th>
				<th>${vacations.employee_id.getSurname()}</th>
				<th><fmt:formatDate type="date"
						value="${vacations.start_date.time}"></fmt:formatDate></th>
				<th><fmt:formatDate type="date"
						value="${vacations.end_date.time}"></fmt:formatDate></th>
				<td><a type="button" class="btn btn-success"
					href="/vacations/${vacations.id}">Update</a></td>
				<td>
					<div class="text-center">
						<a href="#myModal" type="button"
							class="btn btn-danger trigger-btn" data-toggle="modal">Delete</a>
					</div>
				</td>
				<div id="myModal" class="modal fade">
					<div class="modal-dialog modal-confirm">
						<div class="modal-content">
							<div class="modal-header justify-content-center">
								<div class="icon-box">
									<i class="material-icons">&#xE876;</i>
								</div>
								<button type="button" class="close" data-dismiss="modal"
									aria-hidden="true">&times;</button>
							</div>
							<div class="modal-body text-center">
								<h4>Great!</h4>
								<p>The vacation has been deleted successfully.</p>
								<a type="button" class="btn btn-danger"
									href="/delete-vacation/${vacations.id}">OK</a>
							</div>
						</div>
					</div>
				</div>
			</tr>
		</c:forEach>
	</tbody>
</table>
