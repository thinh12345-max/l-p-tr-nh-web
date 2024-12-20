<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>
<div class="container-fluid fixed-top"
	style="height: 10px; background-color: #795548"></div>
<div class="container-fluid p-4 bg-light">
	<div class="row">
		<div class="col-md-3 ">
			<h3>
				<i class="fa-brands fa-stack-overflow fa-bounce"
					style="color: #6a9a74;"></i> <i class="fa-solid fa-d "></i>
				<i class="fa-solid fa-l fa-bounce"></i> <i
					class="fa-solid fa-u "></i> <i
					class="fa-solid fa-a fa-bounce"></i>
			</h3>
		</div>

		<div class="col-md-3 ml-5">
			<c:if test="${not empty userobj}">
				<a  class="btn btn-success"><i
					class="fa-solid fa-user"></i> ${userobj.name}</a>
				<a data-toggle="modal" data-target="#exampleModal"
					class="btn btn-primary"><i class="fa-solid fa-right-to-bracket"></i>
					Logout</a>
			</c:if>
			<c:if test="${empty userobj}">
				<a href="../login.jsp" class="btn btn-success"><i
					class="fa-solid fa-right-to-bracket"></i> Login</a>
				<a href="../register.jsp" class="btn btn-primary"><i
					class="fa-solid fa-user-plus"></i> Sign Up</a>
			</c:if>

		</div>

	</div>

</div>

<!-- logout modal -->
<!-- Modal -->
<div class="modal fade" id="exampleModal" tabindex="-1"
	aria-labelledby="exampleModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title" id="exampleModalLabel"></h5>
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<div class="modal-body">
				<div class="text-center">
					<h4>Ban Co Muon Dang Xuat</h4>
					<button type="button" class="btn btn-secondary"
						data-dismiss="modal">Close</button>
					<a href="../logout" type="button" class="btn btn-primary text-white">Logout</a>
				</div>
			</div>
			<div class="modal-footer"></div>
		</div>
	</div>
</div>
<!-- end logout modal -->
<nav class="navbar navbar-expand-lg navbar-dark bg-custom sticky-top"
	style="margin-top: 10px;">

	<a class="navbar-brand" href="home.jsp"><i class="fa-brands fa-stack-overflow"
					style="color: #6a9a74;"></i> Dlua</a>
	<button class="navbar-toggler" type="button" data-toggle="collapse"
		data-target="#navbarSupportedContent"
		aria-controls="navbarSupportedContent" aria-expanded="false"
		aria-label="Toggle navigation">
		<span class="navbar-toggler-icon"></span>
	</button>

	<div class="collapse navbar-collapse" id="navbarSupportedContent">
		<ul class="navbar-nav mr-auto">

			</form>
	</div>
</nav>