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

<h3>Table with comments</h3>

 <table border="2" cellpadding="10" bordercolor="blue">
 	 <tr>
          <th>commentId</th>
          <th>userId</th>
          <th>showId</th>
          <th>commentString</th>
          <th>rating</th>
       </tr>
    <c:forEach var="comment" items="${comments}">
        <tr>
             <td>${comment.commentId}</td>
             <td>${comment.userId}</td>
             <td>${comment.showId}</td>
             <td>${comment.commentString}</td>
             <td>${comment.rating}</td>

        </tr>
    </c:forEach>
    </table>

</body>
</html>