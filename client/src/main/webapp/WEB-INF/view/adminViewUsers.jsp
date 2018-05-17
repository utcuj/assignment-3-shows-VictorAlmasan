<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta http-equiv="Content-Type" content = "text/html; charset=UTF-8">
<title>ADMIN</title>

</head>
<body>

<div role="navigation">
 		<div class="navbar navbar-inverse">
 			<div class="navbar-collapse collapse">
 				<ul class="nav navbar-nav">
 					<li><a class="active" href="/admin/home">Home</a></li>
                    <li><a href="/admin/getAllUsers">View all users</a></li>
                    <li><a href="/admin/getAllPremiumUsers">View all premium users</a></li>
                    <li><a href="/admin/getAllRegularUsers">View all regular users</a></li>
                    <li><a href="/admin/addUser">Add new user</a></li>
                    <li><a href="/admin/getAllShows">View all shows</a></li>
                    <li><a href="/admin/getAllMovies">View all movies</a></li>
                    <li><a href="/admin/getAllTheatrePerformances">View all theatre performances</a></li>
                    <li><a href="/admin/getAllSportEvents">View all sport events</a></li>
                    <li><a href="/admin/addShow">Add new show</a></li>
                    <li><a href="/login">Log out</a></li>
 				</ul>
 			</div>
 		</div>
 </div>

 <h3>Table with users</h3>

<table border="2" cellpadding="10" bordercolor="blue">
	 <tr>
         <th>userId</th>
         <th>userType</th>
         <th>username</th>
         <th>password</th>
      </tr>
   <c:forEach var="user" items="${users}">
       <tr>
            <td>${user.userId}</td>
            <td>${user.userType}</td>
            <td>${user.username}</td>
            <td>${user.password}</td>
            <td><a href="/admin/deleteUser/${user.userId }">DELETE</a></td>
            <td><a href="/admin/editUser/${user.userId }">EDIT</a></td>

       </tr>
   </c:forEach>
   </table>

</body>
</html>