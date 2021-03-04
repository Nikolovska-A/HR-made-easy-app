<%@ include file="common/header.jspf"%>
<%@ include file="menu.jsp"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>


<form class="tabela" method="post">
	<div class="container">
	<h5 style="color:red">${errorMessage}</h5> 

		<div class="row">
			<div class="offset-md-2 col-lg-6">
				<h2>Employee vacation <i class="fas fa-umbrella-beach"></i></h2>
				<div class="progress">
					<div class="progress-bar progress-bar-info progress-bar-striped bg-success"
						role="progressbar" aria-valuenow="100" aria-valuemin="0"
						aria-valuemax="100" style="width: 100%"></div>
				</div>
			</div>
		</div>

		<div class="row">
			<div class="offset-md-2 col-lg-6">
				Employee <select class="custom-select" id="employee_id"
					name="employee_id" required  ${disabled}>
					<option selected>Select employee...</option>
					<c:forEach items="${employee}" var="employee">
						<option name="${employee.id}" 
							value="${employee.id}"
							${employee == employeeTmp ? 'selected' : ' '  } >${employee.name} ${employee.surname}</option>
					</c:forEach>

				</select>
			</div>
		</div>

		<div class="row">
			<div class="offset-md-2 col-lg-6">Start date*</div>
			<div class="offset-md-2 col-lg-6">
				<input class="form-control" type="date" name="start_date"
					 id="start_date" value="<fmt:formatDate value="${start_date.time}" pattern="yyyy-MM-dd" />">
			</div>
		</div>
	
	<div class="row">
			<div class="offset-md-2 col-lg-6">End date*</div>
			<div class="offset-md-2 col-lg-6">
				<input class="form-control" type="date" name="end_date"
					 id="end_date" value="<fmt:formatDate value="${end_date.time}" pattern="yyyy-MM-dd" />" >
			</div>
		</div>

		<div class="row">
			<div class="offset-md-2 col-lg-6">
				<button type="submit" class="btn btn-success btn-block"
					type="submit" name="save">Save>></button>
			</div>
		</div> </br>
		
		<div class="row">
			<div class="offset-md-2 col-lg-6">
				<div class="progress">
					<div class="progress-bar progress-bar-info progress-bar-striped bg-success"
						role="progressbar" aria-valuenow="100" aria-valuemin="0"
						aria-valuemax="100" style="width: 100%"></div>
				</div>
			</div>
		</div>
		
	</div>
	
</form>