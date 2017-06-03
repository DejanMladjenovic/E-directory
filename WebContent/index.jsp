<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>index</title>
<link href="https://fonts.googleapis.com/css?family=Bungee+Shade|Lobster|Roboto&effect=fire|outline" rel="stylesheet">
<link rel="stylesheet" href="css/bootstrap.css">
<link rel="stylesheet" href="css/style.css">
<noscript>Your browser does not support JavaScript!</noscript>
</head>
<body>
	<div class="container">

		<jsp:include page="includes/header.jsp"></jsp:include>

		<div class="menu text-right font-effect-outline">
			<a href="register.jsp" id="register" class="btn btn-primary">Register</a>
			<a href="login.jsp" id="login" class="btn btn-primary">Login</a>
		</div>

		<div class="main text-center font-effect-outline">
			<h3>Directory online</h3>
			<p>Welcome to my directory application.</p>
			<p>Manage your contacts as free as you want.</p>
		</div>


	</div>
	<jsp:include page="includes/footer.jsp"></jsp:include>		
</body>
</html>