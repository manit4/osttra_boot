<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9"
	crossorigin="anonymous">
</head>
<body>
<h1 style="margin-left: 450px">Osttra Book Management</h1>
<h2 style="margin-left: 450px; color: red;">Provide your Details here!!</h2>
<div style="margin-left: 450px; margin-right: 500px">
<form action="register" method="post">
	<div class="mb-3">
		<label for="exampleFormControlInput1" class="form-label">Username</label> <input type="text" name="username" class="form-control">
	</div>
	<div class="mb-3">
		<label for="exampleFormControlInput1" class="form-label">Password</label> <input type="text" name="password" class="form-control">
	</div>
	<div class="mb-3">
		<label for="exampleFormControlInput1" class="form-label">Complete Name</label> <input type="text" name="completeName" class="form-control">
	</div>
	<div class="mb-3">
		<label for="exampleFormControlInput1" class="form-label">Email</label> <input type="text" name="email" class="form-control">
	</div>
	
	
	<button style="margin-left: 130px" type="submit" class="btn btn-primary">Register</button><br>
	</form>
	<a href="/">Back to Home Page</a>
	</div>
</body>
</html>