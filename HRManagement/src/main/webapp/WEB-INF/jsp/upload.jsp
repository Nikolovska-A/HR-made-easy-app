<%@ include file="common/header.jspf"%>
<%@ include file="menu.jsp"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>



<form class="tabela" method="post" action="upload" enctype="multipart/form-data">
	<div class="container">
	
		<h5 style="color: red">${errorMessage}</h5>

		<div class="row">
			<div class="offset-md-2 col-lg-6">
				<h2>Upload files <i class="far fa-file-alt"></i></h2>
				<div class="progress">
					<div
						class="progress-bar progress-bar-info progress-bar-striped bg-danger"
						role="progressbar" aria-valuenow="100" aria-valuemin="0"
						aria-valuemax="100" style="width: 100%"></div>
				</div>
			</div>
		</div>

		<div class="row">
			<div class="offset-md-2 col-lg-6">
				Employee <select class="custom-select" id="employee_id"
					name="employee_id" required>
					<option selected>Select employee...</option>
					<c:forEach items="${employee}" var="employee">
						<option name="${employee.id}" required="required"
							value="${employee.id}" ${employee == Employee ? 'selected' : ' '}>
							${employee.name} ${employee.surname}</option>
					</c:forEach>
				</select>
			</div>
		</div></br>

		<div class="row">
			<div class="offset-md-2 col-lg-6">

				<tr>
					<td>Upload file:</td>
					<td><input type="file" name="file" /></td>
				</tr>
			</div>
		</div></br>


		<div class="row">
			<div class="offset-md-2 col-lg-6">
				<tr>
					<td colspan="2" align="center"><button type="submit"
							class="btn btn-danger btn-block" type="submit" name="save">Save>></button></td>
				</tr>
			</div>
		</div> </br>

		<div class="row">
			<div class="offset-md-2 col-lg-6">
				<div class="progress">
					<div
						class="progress-bar progress-bar-info progress-bar-striped bg-danger"
						role="progressbar" aria-valuenow="100" aria-valuemin="0"
						aria-valuemax="100" style="width: 100%"></div>
				</div>
			</div>
		</div>
</form>


