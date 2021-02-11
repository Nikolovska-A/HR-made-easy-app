<%@ include file="common/header.jspf"%>
<%@ include file="menu.jsp"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<form class="tabela" method="post">
	<div class="container">
		<div class="row">
			<div class="offset-md-3 col-lg-6">
				<input type="text" id="id" name="id" class="form-control"
					placeholder="ID" required="required">
			</div>
		</div>
		<div class="row">
			<div class="offset-md-3 col-lg-6">
				<input type="text" id="name" name="name" class="form-control"
					placeholder="First Name">
			</div>
		</div>
		<div class="row">
			<div class="offset-md-3 col-lg-6">
				<input type="text" id="surname" name="surname" class="form-control"
					placeholder="Last Name">
			</div>
		</div>
		<div class="row">
			<div class="offset-md-3 col-lg-6">
				<select class="custom-select" id="job_position.id" name="id">
					<option selected>Избери работна позиција...</option>
					<c:forEach items="${job_position}" var="job_position">
						<option name="id" value="${job_position.id}"
							${job_position == JobPosition ? 'selected' : ' '}>${job_position.opis}</option>
					</c:forEach>
				</select><br /> <br />
			</div>
		</div>
		<div class="row">
			<div class=" offset-md-3 col-lg-2 col-md-2 col-sm-2">
				<label for="begin_date">Begin date</label>
			</div>
			<div class=" col-lg-4 col-md-4 col-sm-4">
				<input class="form-control" type="date" name="begin_date"
					value="2011-19-08" id="begin_date">
			</div>
		</div>
		<div class="row">
			<div class=" offset-md-3 col-lg-2 col-md-2 col-sm-2">
				<label for="end_date">End date</label>
			</div>
			<div class=" col-lg-4 col-md-4 col-sm-4">
				<input class="form-control" type="date" name="end_date"
					value="2011-19-08" id="end_date">
			</div>
		</div>
		<div class="row">
			<div class="offset-md-3 col-sm-6 col-md-6 col-lg-6">
				<button type="submit" class="btn btn-primary btn-block"
					type="submit" name="save">Save>></button>
			</div>

		</div>
	</div>
</form>