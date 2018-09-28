<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<spring:url var="css" value="/resources/css" />
<spring:url var="js" value="/resources/js" />
<spring:url var="images" value="/resources/images" />

<c:set var="contextRoot" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html lang="en">

<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">

<title>Online Shopping - ${title}</title>

<script>
	window.menu = '${title}';

	window.contextRoot = '${contextRoot}';
</script>
<!-- Bootstrap Core CSS -->
<link href="${css}/bootstrap.min.css" rel="stylesheet">

<!-- Bootstrap Readable Theme -->
<link href="${css}/bootstrap-readable-theme.css" rel="stylesheet">

<!-- Bootstrap Data tables Theme -->
<link href="${css}/dataTables.bootstrap.css" rel="stylesheet">

<!-- Custom CSS -->
<link href="${css}/myapp.css" rel="stylesheet">

<!-- Login CSS -->
<link href="${css}/login.css" rel="stylesheet">

</head>

<body>

	<div class="wrapper" id="LoginForm">

		<!-- Navigation -->

		<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
			<div class="container">
				<!-- Brand and toggle get grouped for better mobile display -->
				<div class="navbar-header">
					<a class="navbar-brand" href="${contextRoot}/home">Online
						Shopping</a>
				</div>
			</div>
		</nav>

		<!-- Page Content -->

		<div class="content">

			<div class="container">
				<div class="login-form">
					<div class="main-div">
						<div class="panel">
							<h2>Admin Login</h2>
							<p>Please enter your email and password</p>
						</div>

						<!-- this msg will be displayed if wrong credentials are entered -->
						<c:if test="${not empty message}">
							<div class="alert alert-danger">${message}</div>
						</c:if>

						<form action="${contextRoot}/login" method="POST" id="loginForm">

							<div class="form-group">
								<input type="email" class="form-control" id="username"
									name="username" placeholder="Email Address">
							</div>

							<div class="form-group">
								<input type="password" class="form-control" id="password"
									name="password" placeholder="Password">
							</div>

							<div class="forgot">
								<a href="#">Forgot password?</a>
							</div>
							<button type="submit" class="btn btn-primary">Login</button>
							<input type="hidden" name="${_csrf.parameterName}"
								value="${_csrf.token}" />

						</form>

						<div class="panel-footer">
							<div class="text-right">
								New User - <a href="${contextRoot}/register">Register Here</a>
							</div>
						</div>
					</div>
				</div>
			</div>



		</div>

		<!-- /online_shopping/src/main/webapp/WEB-INF/views/shared/footer.jsp -->
		<!-- Footer -->
		<%@include file="./shared/footer.jsp"%>

		<!-- /.container -->

		<!-- jQuery -->
		<script src="${js}/jquery.js"></script>

		<!-- jQuery validation -->
		<script src="${js}/jquery.validate.js"></script>

		<!-- Bootstrap Core JavaScript -->
		<script src="${js}/bootstrap.min.js"></script>

		<!-- self coded JavaScript -->
		<script src="${js}/myapp.js"></script>

	</div>

</body>

</html>