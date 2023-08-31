<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
     <%@ page import="com.osttra.to.User" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%
	User user = (User) session.getAttribute("user");
	String role = user.getRole();

%>

This is out of header.jsp<%= user %>
<nav class="navbar navbar-expand-lg fixed-top navbar-dark bg-dark" aria-label="Main navigation">
  <div class="container-fluid">

    <div class="navbar-collapse offcanvas-collapse" id="navbarsExampleDefault">
      <ul class="navbar-nav me-auto mb-2 mb-lg-0">
        <li class="nav-item">
          <a class="nav-link active" aria-current="page" href="#">Home</a>
        </li>
         <% 
         	if(role.equalsIgnoreCase("admin")) {
         	
         %>
         <li class="nav-item">
          <a class="nav-link active" aria-current="page" href="#">Master</a>
        </li>
         <li class="nav-item">
          <a class="nav-link active" aria-current="page" href="#">Reporting</a>
        </li>
        
        <%} %>
         <li class="nav-item">
          <a class="nav-link active" aria-current="page" href="#">Time-Sheet</a>
        </li>
         <li class="nav-item">
          <a class="nav-link active" aria-current="page" href="#">Logout</a>
        </li>
      </ul>
      <form class="d-flex">
        <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search">
        <button class="btn btn-outline-success" type="submit">Search</button>
      </form>
    </div>
  </div>
</nav>
</body>
</html>