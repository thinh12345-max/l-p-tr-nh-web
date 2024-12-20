<%@page import="com.entity.User"%>
<%@page import="com.entity.BookDtls"%>
<%@page import="com.DB.DBConnect"%>
<%@page import="com.DAO.BookDAOImpl"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<%@include file="all_component/allCss.jsp"%>
</head>

<body style="background-color: #eeeeee;">
	<%
	User u = (User) session.getAttribute("userobj");
	%>
	<%@include file="all_component/navbar.jsp"%>

	<%
	int bid = Integer.parseInt(request.getParameter("bid"));
	BookDAOImpl dao = new BookDAOImpl(DBConnect.getConn());
	BookDtls b = dao.getBookById(bid);
	%>

	<div class="container p-5">
		<div class="row p-3">
			<div
				class="col-md-4 text-center p-4 mx-4 border bg-light shadow-sm rounded">
				<img src="book/<%=b.getPhotoName()%>" alt="Book Image"
					style="height: 250px; width: 155px; object-fit: cover; border-radius: 8px;"><br>
				<br>
				<h5 class="text-black">
					Book Name:
					<%=b.getBookName()%></h5>
				<h7 class="text-muted"><%=b.getAuthor()%></h7>
				<br>
				<h7 class="text-black">Book Genre: <%=b.getStatus()%></h7>
			</div>
			<div
				class="col-md-7 offset-md-1 text-center p-4 mx-1 border bg-light shadow-sm rounded">
				<h2 class="font-weight-bold text-dark"><%=b.getBookName()%></h2>
				<div class="col-md-12 text-center p-5">
					<p class="text-muted"><%=b.getNote()%></p>
				</div>
				<div class="text-center p-5">
					<%
					if (u == null) {
					%>
					<a href="login.jsp" class="btn btn-danger btn-sm ml-0"><i
						class="fa-solid fa-briefcase"></i> Add To Bag</a>
					<%
					} else {
					%>
					<a href="cart?bid=<%=b.getBookId()%>&&uid=<%=u.getId()%>"
						class="btn btn-success btn-sm ml-0"><i
						class="fa-solid fa-briefcase"></i> Add To Bag</a>
					<%
					}
					%>
				</div>
			</div>
		</div>
	</div>
	<br>
	<br>
	<br>
	<br>

	<%@include file="all_component/footer.jsp"%>
</body>
</html>