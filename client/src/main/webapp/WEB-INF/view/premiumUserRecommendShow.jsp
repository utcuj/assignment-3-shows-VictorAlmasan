<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta http-equiv="Content-Type" content = "text/html; charset=UTF-8">
<title>PREMIUM USER</title>



</head>
<body>



<div role="navigation">
 		<div class="navbar navbar-inverse">
 			<div class="navbar-collapse collapse">
 				<ul class="nav navbar-nav">
 					<li><a class="active" href="/premiumUser/home">Home</a></li>
 					<li><a href="/premiumUser/getAllShows">View all shows</a></li>
 					<li><a href="/premiumUser/getAllWatchedShows">View all watched shows</a></li>
 					<li><a href="/premiumUser/getAllComments">View all comments</a></li>
 					<li><a href="/premiumUser/getAllPremiumUsers">View all premium users</a></li>
                    <li><a href="/premiumUser/getAllFriendships">View all friends</a></li>
                    <li><a href="/premiumUser/getAllRecommendations">View all recommendations</a></li>
                    <li><a href="/premiumUser/getAllRecommendationsYouHaveSent">View all recommendations you have sent</a></li>
 					<li><a href="/login">Log out</a></li>
 				</ul>
 			</div>
 		</div>
 </div>

<div class="form">
    <form method="post" action="/premiumUser/recommendShow">
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
            Recommend to: <br>
            <input type="text" id="secondUserUsername" name="secondUserUsername" value="${recommendation.secondUserUsername}"/>
        </p>

        <p>
            <input type="submit" name="RECOMMEND" value="Recommend show">
        </p>
    </form>
</div>



</body>
</html>