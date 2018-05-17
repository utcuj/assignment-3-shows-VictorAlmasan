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

<h3>Table with recommendations</h3>

 <table border="2" cellpadding="10" bordercolor="blue">
 	 <tr>
          <th>recommendationId</th>
          <th>firstUserId</th>
          <th>firstUserUsername</th>
          <th>secondUserId</th>
          <th>secondUserUsername</th>
          <th>showId</th>
       </tr>
    <c:forEach var="recommendation" items="${recommendations}">
        <tr>
             <td>${recommendation.recommendationId}</td>
             <td>${recommendation.firstUserId}</td>
             <td>${recommendation.firstUserUsername}</td>
             <td>${recommendation.secondUserId}</td>
             <td>${recommendation.secondUserUsername}</td>
             <td>${recommendation.showId}</td>
        </tr>
    </c:forEach>
    </table>

</body>
</html>