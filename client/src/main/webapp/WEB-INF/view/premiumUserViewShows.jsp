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

<h3>Table with shows</h3>

 <table border="2" cellpadding="10" bordercolor="blue">
 	 <tr>
          <th>showId</th>
          <th>showType</th>
          <th>name</th>
          <th>actors</th>
          <th>description</th>
          <th>date</th>
          <th>available</th>
       </tr>
    <c:forEach var="show" items="${shows}">
        <tr>
             <td>${show.showId}</td>
             <td>${show.showType}</td>
             <td>${show.name}</td>
             <td>${show.actors}</td>
             <td>${show.description}</td>
             <td>${show.date}</td>
             <td>${show.available}</td>
             <td><a href="/premiumUser/addHistory/${show.showId}">VIEW</a></td>
             <td><a href="/premiumUser/addCommentAndRating/${show.showId}">ADD COMMENT&RATING</a></td>
              <td><a href="/premiumUser/recommendShow/${show.showId}">RECOMMEND</a></td>


        </tr>
    </c:forEach>
    </table>

</body>
</html>