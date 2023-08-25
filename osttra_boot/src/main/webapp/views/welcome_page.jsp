<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ page import="com.osttra.to.User" %>
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


<jsp:include page="header.jsp"/>

<%
	User user = (User) session.getAttribute("user");

%>



<h1 style="margin-left: 450px; margin-top: 100px">Osttra Book Management</h1>

${ updateSuccessMsg }
  <table class="table">
  <thead>
    <tr>
      <th scope="col">Username</th>
      <th scope="col">Complete Name</th>
      <th scope="col">Email</th>
      <th scope="col">Role</th>
      <th scope="col">Delete</th>
      <th scope="col">Update</th>
      <%= user %>
    </tr>
  </thead>
  <tbody>
    <%-- <tr>
      <td>${ user.getUsername() }</td>
      <td>${ user.getCompleteName() }</td>
      <td>${ user.getEmail() }</td>
      <td>${ user.getRole() }</td>
      <td><a href = "delete/${ user.getUsername() }">Delete</a></td>
      <td><a href = "updatePage/${ user.getUsername() }">Update</a></td>
    </tr> --%>
    <tr>
      <td>${ user.getUsername() }</td>
      <td>${ user.getCompleteName() }</td>
      <td>${ user.getEmail() }</td>
      <td>${ user.getRole() }</td>
      <td><a href = "delete/${ user.getUsername() }">Delete</a></td>
      <td><a href = "updatePage/${ user.getUsername() }">Update</a></td>
    </tr>
  </tbody>
</table>





</body>
</html>