<%@ include file="common/header.jspf"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>


<nav
	class="navbar fixed-left navbar-expand-md navbar-dark bg-info fixed-top">
	<a class="navbar-brand" href>HR Made Easy</a>
	<button class="navbar-toggler" type="button" data-toggle="collapse"
		data-target="#navbarsExampleDefault"
		aria-controls="navbarsExampleDefault" aria-expanded="false"
		aria-label="Toggle navigation">
		<span class="navbar-toggler-icon"></span>
	</button>

	<div class="collapse navbar-collapse" id="navbarsExampleDefault">
		<ul class="navbar-nav">
			<li class="nav-item"><a class="nav-link" type="submit"
				onclick="location.href='../../menu'">Main menu</a></li>
			<li class="nav-item"><a class="nav-link" type="submit"
				onclick="location.href='../../new_employee'">Add new employee</a></li>
			<li class="nav-item"><a class="nav-link" type="submit"
				onclick="location.href='../../listemployees'">See all employees</a></li>

			<li class="nav-item"><a class="nav-link" type="submit"
				onclick="location.href='../../vacations'">Add vacation</a></li>
			<li class="nav-item"><a class="nav-link" type="submit"
				onclick="location.href='../../listvacations'">See vacations</a></li>
			<li class="nav-item"><a class="nav-link" type="submit"
				onclick="location.href='../../upload'">Upload files</a></li>
			<li class="nav-item"><a class="nav-link" type="submit"
				onclick="location.href='../../listfiles'">See all files</a></li>

		</ul>

	</div>
</nav>



