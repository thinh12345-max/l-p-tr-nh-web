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
<%@include file="allCss.jsp"%>
<title>Admin: All List</title>
</head>
<body>
	<c:if test="${empty userobj}">
		<c:redirect url="../login.jsp"></c:redirect>
	</c:if>
	<%@include file="navbar.jsp"%>
	<h3 class="text-center">Hello Admin</h3>

	<table class="table table-striped ">
		<thead class="bg-info text-white">
			<tr>
				<th scope="col">Id</th>
				<th scope="col">Name</th>
				<th scope="col">Email</th>
				<th scope="col">Address</th>
				<th scope="col">Phone No</th>
				<th scope="col">Book Name</th>
				<th scope="col">Author</th>
				<th scope="col">Time</th>
			</tr>
		</thead>
		<tbody>
			<%
			User u = (User) session.getAttribute("userobj");
			BookRentImpl dao = new BookRentImpl(DBConnect.getConn());
			List<Book_Rent> blist = dao.getAllList();

			for (Book_Rent b : blist) {
			%>
			<tr>
				<th scope="row"><%=b.getRentId()%></th>
				<td><%=b.getUserName()%></td>
				<td><%=b.getEmail()%></td>
				<td><%=b.getFulladd()%></td>
				<td><%=b.getPhone()%></td>
				<td><%=b.getBookName()%></td>
				<td><%=b.getAuthor()%></td>
				<td><%=b.getTime()%></td>
			</tr>
			<%
			}
			%>
		</tbody>
	</table>
	<br>
	<br>
	<br>
	<br>
	<%@include file="footer.jsp"%>
</body>
</html>