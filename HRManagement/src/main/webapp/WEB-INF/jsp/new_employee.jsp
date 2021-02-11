<%@ include file="common/header.jspf"%>
<%@ include file="menu.jsp"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<head>
<link rel="stylesheet" type="text/css" href="navbar.css">
</head>

<form class="tabela" method="post">
	<div class="container">

		<div class="row">
			<div class="offset-md-2 col-lg-6">
				<h2>New Employee</h2>
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
					class="form-control input-group-lg" placeholder="Firs Name"
					required="required" value="${name}">
			</div>
		</div>

		<div class="row">
			<div class="offset-md-2 col-lg-6">
				Last Name* <input type="text" id="surname" name="surname"
					class="form-control input-group-lg" placeholder="Last Name"
					required="required" value="${surname}">
			</div>
		</div>

		<div class="row">
			<div class="offset-md-2 col-lg-6">
				Personal Identification Number* <input type="text"
					id="personal_number" name="personal_number"
					class="form-control input-group-lg"
					placeholder="Personal Identification Number" required="required"
					value="${personal_number}">
			</div>
		</div>

		<div class="row">
			<div class="offset-md-2 col-lg-6">
				Birth year <input type="text" id="birthyear" name="birthyear"
					class="form-control input-group-lg" placeholder="Birth year"
					value="${birthyear}">
			</div>
		</div>

		<div class="row">
			<div class="offset-md-2 col-lg-6">
				Phone* <input type="text" id="phone" name="phone"
					class="form-control input-group-lg" placeholder="Phone"
					required="required" value="${phone}">
			</div>
		</div>

		<div class="row">
			<div class="offset-md-2 col-lg-6">
				Email*<input type="text" id="email" name="email"
					class="form-control input-group-lg" placeholder="Email"
					required="required" value="${email}">
			</div>
		</div>

		<div class="row">
			<div class="offset-md-2 col-lg-6">
				Adress<input type="text" id="adress" name="adress"
					class="form-control input-group-lg" placeholder="Adress"
					value="${adress}">
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
						id="type_contract" value="${type_contract}"> temporary
						contract
					</label> <label class="form-check-label"> <input
						class="form-check-input" type="radio" name="type_contract"
						id="type_contract" value="${type_contract}"> indefinite
						contract
					</label>
				</div>
			</div>
		</div>

		<div class="row">
			<div class="offset-md-2 col-lg-6">
				Job position* <select class="custom-select" id="job_position.id"
					name="job_position">
					<option selected>Select job position...</option>
					<c:forEach items="${job_position}" var="job_position">
						<option name="${job_position.id}" required="required"
							value="${job_position.id}"
							${job_position == JobPosition ? 'selected' : ' '}>${job_position.description}</option>
					</c:forEach>
				</select>
			</div>
		</div>

		<div class="row">
			<div class="offset-md-2 col-lg-6">Begin date*</div>
			<div class="offset-md-2 col-lg-6">
				<input class="form-control" type="date" name="begin_date"
					required="required" value="${begin_date}" id="begin_date">
			</div>
		</div>

		<div class="row">
			<div class="offset-md-2 col-lg-6">End date</div>
			<div class="offset-md-2 col-lg-6">
				<input class="form-control" type="date" name="end_date"
					value="${end_date}" id="end_date">
			</div>
		</div>

		<div class="row">
			<div class="offset-md-2 col-lg-6">
				Salary*<input type="text" id="salary" name="salary"
					class="form-control input-group-lg" placeholder="Salary"
					required="required" value="${salary}">
			</div>
		</div>

		<div class="row">
			<div class="offset-md-2 col-lg-6">
				Bonus<input type="text" id="bonus" name="bonus"
					class="form-control input-group-lg" placeholder="Bonus"
					value="${bonus}">
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
							<input class="form-check-input" type="checkbox" name="items"
								id="${items.id}"> <label class="form-check-label"
								for="items"> ${items.type} </label>
						</div>
					</c:forEach>
				</label>
			</div>
		</div>

		<div class="row">
			<div class="offset-md-2 col-lg-6">
				<label class="form-label" for="customFile">Upload file</label>
				<div method="POST" action="/upload" enctype="multipart/form-data">
					<input type="file">
				</div>
			</div>
		</div>

		<div class="row">
			<div class="offset-md-2 col-lg-6">
				<span class="help-block">*Required fields</span>
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

		<div class="row">
			<div class="offset-md-2 col-lg-6">
				<button type="submit" class="btn btn-primary btn-block"
					type="submit" name="button" value="${button}">Save >></button>
			</div>
		</div>
	</div>
</form>
