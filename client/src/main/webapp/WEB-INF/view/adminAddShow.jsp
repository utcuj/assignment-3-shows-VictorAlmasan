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

<div class="form">
    <form method="post" action="/admin/addShow">
        <p>
           showType: <br>
           <input type="text" id="showType" name="showType" required/>
        </p>
        <p>
           name: <br>
           <input type="text" id="name" name="name" required/>
        </p>
        <p>
           actors: <br>
           <input type="text" id="actors" name="actors" required/>
        </p>
        <p>
           description: <br>
           <input type="text" id="description" name="description" required/>
        </p>
        <p>
           date(yyyy-MM-dd): <br>
           <input type="text" id="date" name="date" required/>
         </p>
        <p>
         available <br>
         <input type="text" id="available" name="available" required/>
        </p>
        <p>
           <input type="submit" name="ADD" value="Add Show">
         </p>
    </form>
</div>

</body>
</html>