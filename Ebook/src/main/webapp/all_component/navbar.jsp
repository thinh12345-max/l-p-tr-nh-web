<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>
<div class="container-fluid fixed-top"
	style="height: 10px; background-color: #795548"></div>
<div class="container-fluid p-4 bg-light">
	<div class="row">
		<div class="col-md-3">
			<a class="navbar-brand" href="index.jsp"
				style="color: inherit; text-decoration: none;">
				<h3>
					<i class="fa-brands fa-stack-overflow fa-bounce"
						style="color: #6a9a74;"></i> <i class="fa-solid fa-d"></i> <i
						class="fa-solid fa-l fa-bounce"></i> <i class="fa-solid fa-u"></i>
					<i class="fa-solid fa-a fa-bounce"></i>
				</h3>
			</a>

		</div>
		<div class="col-md-6">
			<form class="form-inline my-2 my-lg-0" action="search.jsp" method="post">
				<input class="form-control mr-sm-2" type="search" name="ch"
					placeholder="Search" aria-label="Search">
				<button class="btn btn-primary my-2 my-sm-0" type="submit">
					<i class="fa-solid fa-magnifying-glass fa-beat"></i> Search
				</button>
			</form>
		</div>

		<c:if test="${not empty userobj}">
			<div class="col-md-3">
				<a href="checkout.jsp"
					style="position: relative; top: 10px; left: -70px;"><i
					class="fa-solid fa-briefcase fa-2x">Bag</i></a> <a href="login.jsp"
					class="btn btn-success"><i class="fa-solid fa-user-plus"></i>
					${userobj.name}</a> <a href="logout" class="btn btn-primary"><i
					class="fa-solid fa-right-to-bracket"></i> Logout</a>
			</div>

		</c:if>

		<c:if test="${empty userobj}">
			<div class="col-md-3">
				<a href="login.jsp" class="btn btn-success"><i
					class="fa-solid fa-right-to-bracket"></i> Login</a> <a
					href="register.jsp" class="btn btn-primary"><i
					class="fa-solid fa-user-plus"></i> Sign Up</a>
			</div>
		</c:if>

	</div>

</div>
<nav class="navbar navbar-expand-lg navbar-dark bg-custom sticky-top"
	style="margin-top: 10px;">

	<a class="navbar-brand" href="index.jsp"><i
		class="fa-brands fa-stack-overflow " style="color: #6a9a74;"></i> Dlua</a>
	<button class="navbar-toggler" type="button" data-toggle="collapse"
		data-target="#navbarSupportedContent"
		aria-controls="navbarSupportedContent" aria-expanded="false"
		aria-label="Toggle navigation">
		<span class="navbar-toggler-icon"></span>
	</button>

	<div class="collapse navbar-collapse" id="navbarSupportedContent">
		<ul class="navbar-nav mr-auto">

			<li class="nav-item active"><a class="nav-link"
				href="fantasty_book.jsp"><i class="fa-solid fa-circle"></i>
					Fantasy</a></li>
			<li class="nav-item active"><a class="nav-link"
				href="romance_book.jsp"><i class="fa-solid fa-circle"></i>
					Romance</a></li>
			<li class="nav-item active"><a class="nav-link"
				href="horror_book.jsp"><i class="fa-solid fa-circle"></i> Horror</a></li>
		</ul>
		<form class="form-inline my-2 my-lg-0">
			<a class="btn btn-light my-2 my-sm-0 " type="submit" href="Borrowed_books.jsp">
				<i class="fa-solid fa-book-bookmark"></i> Borrowed Books
			</a>

		</form>
	</div>

</nav>