<%@page import="com.entity.User"%>
<%@ page import="java.util.List"%>
<%@page import="com.entity.BookDtls"%>
<%@page import="com.DAO.BookDAOImpl"%>
<%@ page import="java.sql.Connection"%>
<%@ page import="com.DB.DBConnect"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>BOOK</title>
<%@include file="all_component/allCss.jsp"%>
<style type="text/css">
.back-img {
	background: url("img/4645.jpg") center/cover no-repeat;
	height: 45vh;
	width: 100%;
	position: relative;
	display: flex;
	align-items: center;
	justify-content: center;
	color: white;
	text-shadow: 2px 2px 5px rgba(0, 0, 0, 0.7);
	background-attachment: fixed;
	overflow: hidden;
}

.back-img::before {
	content: "";
	position: absolute;
	top: 0;
	left: 0;
	width: 100%;
	height: 100%;
	background: rgba(0, 0, 0, 0.4);
}

.back-img h1 {
	position: relative;
	font-size: 3rem;
	z-index: 1;
	animation: fadeInDown 1s ease-in-out;
}

@
keyframes fadeInDown {from { opacity:0;
	transform: translateY(-50px);
}

to {
	opacity: 1;
	transform: translateY(0);
}
}
</style>
</head>
<body style="background-color: #eeeeee;">

	<%
	User u = (User) session.getAttribute("userobj");
	%>

	<%@include file="all_component/navbar.jsp"%>
	<div class="container-fluid back-img"></div>


	<div class="container mt-4">
		<h3 class="text-center">New Book</h3>
		<br>
		<div class="row justify-content-center">
			<%
			BookDAOImpl dao = new BookDAOImpl(DBConnect.getConn());
			List<BookDtls> list = dao.getNewBook();
			for (BookDtls b : list) {
			%>
			<div class="col-md-3">
				<div class="card crd-ho">
					<span class="badge badge-danger position-absolute"
						style="top: 10px; left: 10px;">NEW</span>
					<div class="card-body text-center">
						<img alt="" src="book/<%=b.getPhotoName()%>"
							style="width: 150px; height: 200px" class="img-thumbnail">
						<p><%=b.getBookName()%></p>
						<p><%=b.getAuthor()%></p>
						<div>
							<%
							if (u == null) {
							%>
							<a href="login.jsp" class="btn btn-danger btn-sm ml-0">Add</a>
							<%
							} else {
							%>
							<a href="cart?bid=<%=b.getBookId() %>&&uid=<%=u.getId() %>" class="btn btn-danger btn-sm ml-0">Add</a>
							<%
							}
							%>
							<a href="view_books.jsp?bid=<%=b.getBookId()%>"
								class="btn btn-success btn-sm ml-1">View Details <i
								class="fa-solid fa-eye"></i></a>
						</div>
					</div>
				</div>
			</div>
			<%
			}
			%>

		</div>
	</div>
	<br>

	<div class="container mt-4">
		<h3 class="text-center">Book Case</h3>
		<br>
		<div class="row">
			<%
			BookDAOImpl dao2 = new BookDAOImpl(DBConnect.getConn());
			List<BookDtls> list2 = dao2.getBookCase();
			for (BookDtls b : list2) {
			%>
			<div class="col-md-3">
				<div class="card crd-ho">
					<div class="card-body text-center">
						<img alt="" src="book/<%=b.getPhotoName()%>"
							style="width: 150px; height: 200px" class="img-thumbnail">
						<p><%=b.getBookName()%></p>
						<p><%=b.getAuthor()%></p>
						<div>
							<%
							if (u == null) {
							%>
							<a href="login.jsp" class="btn btn-danger btn-sm ml-0">Add</a>
							<%
							} else {
							%>
							<a href="cart?bid=<%=b.getBookId() %>&&uid=<%=u.getId() %>" class="btn btn-danger btn-sm ml-0">Add</a>
							<%
							}
							%>
							<a href="view_books.jsp?bid=<%=b.getBookId()%>"
								class="btn btn-success btn-sm ml-1">View Details <i
								class="fa-solid fa-eye"></i></a>
						</div>
					</div>
				</div>
			</div>
			<%
			}
			%>

		</div>
	</div>
	<br>
	<div class="text-center mt-1">
		<a href="all_book.jsp" class="btn btn-info btn-sm text-white">View
			All</a>
	</div>

	<br>
	<br>
	<br>
	<br>

	<%@include file="all_component/footer.jsp"%>
</body>
</html>