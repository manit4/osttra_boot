<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ page import="com.osttra.to.User, java.util.List" %>
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
	List<User> users = (List<User>) session.getAttribute("users");

%>



<h1 style="margin-left: 450px; margin-top: 100px">Osttra Book Management</h1>

${ updateSuccessMsg }

<h2 style="margin-left: 300px; color: blue">User Profile is listed below</h2>
  <table class="table">
  <thead>
    <tr>
      <th scope="col">Username</th>
      <th scope="col">Complete Name</th>
      <th scope="col">Email</th>
      <th scope="col">Role</th>
      <th scope="col">Delete</th>
      <th scope="col">Update</th>
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

<hr>
<%
if(users != null && user.getRole().equalsIgnoreCase("Admin")) {
%>
<table class="table">
  <thead>
    <tr>
    <th scope="col">#</th>
      <th scope="col">Username</th>
      <th scope="col">Complete Name</th>
      <th scope="col">Email</th>
      <th scope="col">Role</th>
      <th scope="col">Delete</th>
      <th scope="col">Update</th>
    </tr>
  </thead>
  <tbody>
    
    <%
    int count = 0;
    	for(int i = 0; i < users.size(); i++) {
    		
    		
    		if(!user.getUsername().equals(users.get(i).getUsername())) {
    			count++;
    %>
    <tr>
    <td><%= count%> </td>
      <td><%= users.get(i).getUsername()%> </td>
      <td><%= users.get(i).getCompleteName()%></td>
      <td><%= users.get(i).getEmail() %></td>
      <td><%= users.get(i).getRole() %></td>
      <td><a href = "delete/<%= users.get(i).getUsername()%>">Delete</a></td>
      <td><a href = "updatePage/<%= users.get(i).getUsername()%>">Update</a></td>
    </tr>
    <%
    	}
    	 }
    	 	}%>
  </tbody>
</table>





</body>
</html>