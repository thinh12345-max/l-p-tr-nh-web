<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Adimin: Home</title>
<%@include file="allCss.jsp"%>
<style type="text/css">
a {
	text-decoration: none;
	color: black;
}

a:hover {
	text-decoration: none;
	color: black;
}
</style>
</head>
<body>
	<%@include file="navbar.jsp"%>
	<c:if test="${empty userobj}">
		<c:redirect url="../login.jsp" />
	</c:if>
	<div class="container">
		<div class="row p-5">
			<div class="col-md-3">
				<a href="add_books.jsp">
					<div class="card">
						<div class="card-body text-center">
							<i class="fa-solid fa-file-circle-plus fa-3x text-info"></i>
							<h4 class="text-info">Add Book</h4>
							------------
						</div>
					</div>
				</a>
			</div>

			<div class="col-md-3">
				<a href="all_books.jsp">
					<div class="card">
						<div class="card-body text-center">
							<i class="fa-solid fa-table-list fa-3x text-secondary"></i>
							<h4 class="text-secondary">All Book</h4>
							------------
						</div>
					</div>
				</a>
			</div>

			<div class="col-md-3">
				<a href="list.jsp">
					<div class="card">
						<div class="card-body text-center">
							<i class="fa-solid fa-bars-staggered fa-3x text-primary"></i>
							<h4 class="text-primary">Borrowers List</h4>
							------------
						</div>
					</div>
				</a>
			</div>

			<div class="col-md-3">
				<a data-toggle="modal" data-target="#exampleModal">
					<div class="card">
						<div class="card-body text-center">
							<i class="fa-solid fa-right-from-bracket fa-3x"></i>
							<h4>logout</h4>
							------------
						</div>
					</div>
				</a>

			</div>
		</div>
	</div>
	<%@include file="footer.jsp"%>
</body>
</html>