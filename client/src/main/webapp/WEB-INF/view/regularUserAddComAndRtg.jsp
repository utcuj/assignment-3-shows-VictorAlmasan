<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta http-equiv="Content-Type" content = "text/html; charset=UTF-8">
<title>REGULAR USER</title>


</head>
<body>


 <div role="navigation">
 		<div class="navbar navbar-inverse">
 			<div class="navbar-collapse collapse">
 				<ul class="nav navbar-nav">
 					<li><a class="active" href="/regularUser/home">Home</a></li>
 					<li><a href="/regularUser/getAllShows">View all shows</a></li>
 					<li><a href="/regularUser/getAllWatchedShows">View all watched shows</a></li>
 					<li><a href="/regularUser/getAllComments">View all comments</a></li>
 					<li><a href="/login">Log out</a></li>
 				</ul>
 			</div>
 		</div>
 </div>


<div class="form">
    <form method="post" action="/regularUser/addCommentAndRating">
        <p>
            showId: <br>
            <input type="text" id="showId" name="showId" readonly="true" value="${show.showId}"/>
        </p>
        <p>
            showType: <br>
            <input type="text" id="showType" name="showType" readonly="true" value="${show.showType}"/>
        </p>
        <p>
            name: <br>
            <input type="text" id="name" name="name" readonly="true" value="${show.name}"/>
        </p>
        <p>
            actors: <br>
            <input type="text" id="actors" name="actors" readonly="true" value="${show.actors}"/>
        </p>
        <p>
            description: <br>
            <input type="text" id="description" name="description" readonly="true" value="${show.description}"/>
        </p>
        <p>
            date: <br>
            <input type="text" id="date" name="date" readonly="true" value="${show.date}"/>
        </p>
        <p>
            available: <br>
            <input type="text" id="available" name="available" readonly="true" value="${show.available}"/>
        </p>

        <p>
            commentString: <br>
            <input type="text" id="commentString" name="commentString" value="${comment.commentString}"/>
        </p>
        <p>
            rating: <br>
             <input type="text" id="rating" name="rating" value="${comment.rating}"/>
        </p>

        <p>
            <input type="submit" name="ADD" value="Add comment and rating">
        </p>
    </form>
</div>
</body>
</html>