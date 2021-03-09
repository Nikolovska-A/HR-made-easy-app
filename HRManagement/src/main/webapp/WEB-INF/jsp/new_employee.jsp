<%@ include file="menu.jsp"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


<form class="tabela" method="post">
	<div class="container" >

		<div class="row">
			<div class="offset-md-2 col-lg-6">
				<h2>Employee <i class="far fa-id-card"></i></h2>
				<div class="progress">
					<div class="progress-bar progress-bar-info progress-bar-striped"
						role="progressbar" aria-valuenow="100" aria-valuemin="0"
						aria-valuemax="100" style="width: 100%"></div>
				</div>
			</div>
		</div>

		<div class="row">
			<div class="offset-md-2 col-lg-6">
				First Name* <input type="text" id="name" name="name"
					class="form-control input-group-lg" placeholder="First Name"
					required="required" value="${name}" ${disabled}>
			</div>
		</div>

		<div class="row">
			<div class="offset-md-2 col-lg-6">
				Last Name* <input type="text" id="surname" name="surname"
					class="form-control input-group-lg" placeholder="Last Name"
					required="required" value="${surname}" ${disabled}>
			</div>
		</div>

		<div class="row">
			<div class="offset-md-2 col-lg-6">
				<input type="text" id="username" name="username"
					class="form-control input-group-lg" placeholder="Username"
					value="${username}" style= "display:none" ${disabled}>
			</div>
		</div>

		<div class="row">
			<div class="offset-md-2 col-lg-6">
				<input type="text" id="password" name="password"
					class="form-control input-group-lg" placeholder="Password"
					 value="${password}" style= "display:none" ${disabled}>
			</div>
		</div>

		<div class="row">
			<div class="offset-md-2 col-lg-6">
				Personal Identification Number* <input type="text"
					id="personal_number" name="personal_number"
					class="form-control input-group-lg"
					placeholder="Personal Identification Number" required="required"
					value="${personal_number}" ${disabled}>
			</div>
		</div>

		<div class="row">
			<div class="offset-md-2 col-lg-6">
				Birth year <input type="text" id="birthyear" name="birthyear"
					class="form-control input-group-lg" placeholder="Birth year"
					value="${birthyear}" ${disabled}>
			</div>
		</div>

		<div class="row">
			<div class="offset-md-2 col-lg-6">
				Phone* <input type="text" id="phone" name="phone"
					class="form-control input-group-lg" placeholder="Phone"
					required="required" value="${phone}" ${disabled}>
			</div>
		</div>

		<div class="row">
			<div class="offset-md-2 col-lg-6">
				Email*<input type="text" id="email" name="email"
					class="form-control input-group-lg" placeholder="Email"
					required="required" value="${email}" ${disabled}>
			</div>
		</div>

		<div class="row">
			<div class="offset-md-2 col-lg-6">
				Adress<input type="text" id="adress" name="adress"
					class="form-control input-group-lg" placeholder="Adress"
					value="${adress}" ${disabled}>
			</div>
		</div>

		<div class="row">
			<div class="offset-md-2 col-lg-6">Type of contract</div>
		</div>
		<div class="row">
			<div class="offset-md-2 col-lg-6">
				<div class="form-check form-check-inline">
					<label class="form-check-label"> <input
						class="form-check-input" type="radio" name="type_contract"
						id="type_contract" value="1" ${disabled} ${checkedItem} >
						temporary contract
					</label> <label class="form-check-label"> <input
						class="form-check-input" type="radio" name="type_contract"
						id="type_contract" value="2" ${disabled} ${checkedItem} >
						indefinite contract
					</label>
				</div>
			</div>
		</div>

		<div class="row">
			<div class="offset-md-2 col-lg-6">
				Job position* <select class="custom-select" id="job_position.id"
					name="job_position" required="required" ${disabled}>
					<option value= "" selected>Select job position...</option>
					<c:forEach items="${job_position}" var="job_position">
						<option name="${job_position.id}" required="required"
							value="${job_position.id}"  ${selected}
							${job_position == job_position_tmp ? 'selected' : ' '}>${job_position.description}
							</option>
					</c:forEach>
				</select>
			</div>
		</div>

		<div class="row">
			<div class="offset-md-2 col-lg-6">Begin date*</div>
			<div class="offset-md-2 col-lg-6">
				<input class="form-control" type="date" name="begin_date"
					required="required" value="${begin_date}" id="begin_date"
					${disabled}>
			</div>
		</div>

		<div class="row">
			<div class="offset-md-2 col-lg-6">End date</div>
			<div class="offset-md-2 col-lg-6">
				<input class="form-control" type="date" name="end_date"
					value="${end_date}" id="end_date" ${disabled}>
			</div>
		</div>

		<div class="row">
			<div class="offset-md-2 col-lg-6">
				Salary*<input type="text" id="salary" name="salary"
					class="form-control input-group-lg" placeholder="Salary"
					required="required" value="${salary}" ${disabled}>
			</div>
		</div>

		<div class="row">
			<div class="offset-md-2 col-lg-6">
				Bonus<input type="text" id="bonus" name="bonus"
					class="form-control input-group-lg" placeholder="Bonus" required="required"
					value="${bonus}" ${disabled}>
			</div>
		</div>

		<div class="row">
			<div class="offset-md-2 col-lg-6">Indent items*</div>
		</div>

		<div class="row">
			<div class="offset-md-2 col-lg-6">
				<label class="form-check-label"> <c:forEach items="${items}"
						var="items">
						<div class="form-check form-check-inline">
							<input type="checkbox" class="form-check-input" name="items"
								id="employee_items.id_zadolzenija" value="${items.id}"
								${disabled} ${checkedItem}  /> <label class="form-check-label">
								${items.type} </label>
						</div>
					</c:forEach>
				</label>
			</div>
		</div>

		<div class="row">
			<div class="offset-md-2 col-lg-6">
				<h6>Employee vacations</h6>
				<table class="table  table-secondary table-sm">
					<thead class="table">
						<tr>
							<th>Start date</th>
							<th>End date</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${vacations}" var="vacations">
							<tr>
								<th><fmt:formatDate type="date"
										value="${vacations.start_date.time}"></fmt:formatDate></th>
								<th><fmt:formatDate type="date"
										value="${vacations.end_date.time}"></fmt:formatDate></th>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>

<%-- 		<div class="row">
			<div class="offset-md-2 col-lg-6">
				<label class="form-label" for="customFile">Upload file</label>
				<input type="file" id="files.id" name="files" ${disabled}>
				
			</div>
		</div> --%>

		<div class="row">
			<div class="offset-md-2 col-lg-6">
				<span class="help-block">*Required fields</span>
			</div>
		</div>

		<div class="row">
			<div class="offset-md-2 col-lg-6">
				<button type="submit" class="btn btn-primary btn-block"
					type="submit" name="button" ${disabled}>Save
					>></button> </br>
			</div>
		</div>

		<div class="row">
			<div class="offset-md-2 col-lg-6">
				<div class="progress">
					<div class="progress-bar progress-bar-info progress-bar-striped"
						role="progressbar" aria-valuenow="100" aria-valuemin="0"
						aria-valuemax="100" style="width: 100%"></div>
				</div>
			</div>
		</div>
	</div>
</form>
