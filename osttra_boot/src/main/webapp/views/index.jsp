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

<%@ page session="false" %>

	<h1 style="margin-left: 450px">Osttra Book Management</h1>
	<div style="margin-left: 450px; margin-right: 500px">
		${ errorMessage }
		${ deleteSucessMsg }
		${ logoutMessage }
		<form action="/login" method="post">
			<div class="mb-3">
				<label for="exampleFormControlInput1" class="form-label">Username</label>
				<input type="text" class="form-control" name="username">
			</div>
			<div class="mb-3">
				<label for="exampleFormControlInput1" class="form-label">Password</label>
				<input type="text" class="form-control" name="password">
			</div>

			<button style="margin-left: 130px" type="submit"
				class="btn btn-primary">Login</button>
			<br>

		</form>
		<a href="registrationPage">New User? Register Here!!</a>
	</div>

</body>
</html>