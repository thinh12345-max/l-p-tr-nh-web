<%@page import="com.entity.User"%>
<%@page import="java.util.List"%>
<%@page import="com.DB.DBConnect"%>
<%@page import="com.DAO.BookRentImpl"%>
<%@page import="com.entity.Book_Rent"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Borrowed Books</title>
<%@include file="all_component/allCss.jsp"%>
</head>
<body>
	<c:if test="${empty userobj}">
		<c:redirect url="login.jsp"></c:redirect>
	</c:if>
	<%@include file="all_component/navbar.jsp"%>
	<div class="container p-2">
		<h3 class="text-center text-primary">Borrowed Books</h3>
		<table class="table table-striped">
			<thead class="bg-success text-white">
				<tr>
					<th scope="col">Rent Id</th>
					<th scope="col">Name</th>
					<th scope="col">Book Name</th>
					<th scope="col">Author</th>
					<th scope="col">Time</th>
				</tr>
			</thead>
			<tbody>
				<%
				User u = (User) session.getAttribute("userobj");
				BookRentImpl dao = new BookRentImpl(DBConnect.getConn());
				List<Book_Rent> blist = dao.getBook(u.getEmail());

				for (Book_Rent b : blist) {
				%>
				<tr>
					<th scope="row"><%=b.getRentId()%></th>
					<td><%=b.getUserName()%></td>
					<td><%=b.getBookName()%></td>
					<td><%=b.getAuthor()%></td>
					<td><%=b.getTime()%></td>
				</tr>
				<%
				}
				%>


			</tbody>
		</table>
	</div>
</body>
</html>