<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>
		<center><span  style="color:#007fad">tri</span><span  style="color:#f48f00">va</span><span  style="color:#c94a30">go</span></center>
	</h1>
	<hr>
	<h3><center>Welcome to Hotel Detail Page</center></h3>
	<input type="button" value="Back" onclick="javascript:history.go(-1)">
	<table border="4px" bordercolor="black" width=80% align="center"
		style="table-layout: fixed;">
		<tr>
			<td style="word-wrap: break-word;" width="400"><image
					src="${hotel.hotelInfo.imgURL}" width="400" height="300" /></td>
			<td valign="top">
				<table>
					<tr>
						<td><b>${hotel.hotelInfo.name}</b></td>
					</tr>
					<tr>
						<td>${hotel.hotelInfo.address}</td>
					</tr>
					<tr>
						<td>${hotel.hotelInfo.price}</td>
					</tr>
					<tr>
						<td valign="top">
                        		Positive : <b><font color="#007fad"><c:out value="${hotel.hotelInfo.positive}"/></font></b>
                        		Negative : <b><font color="#f48f00"><c:out value="${hotel.hotelInfo.negative}" /></font></b>
                        		Intensifier : <b><font color="#c94a30"><c:out value="${hotel.hotelInfo.intensifier}" /></font></b>
                        </td>
					</tr>
				</table>
			</td>
		</tr>
	</table>

	<table border="4px" bordercolor="black" width=80% align="center"
		style="table-layout: fixed;">
		<br/>
		<h2>Review</h2>
		<c:forEach items="${hotel.review}" var="review">		
		<tr><td><h3><c:out value="${review.title}" /></h3></td></tr>
		<tr><td><c:out value="${review.content}" /></td></tr>
		<tr><td><h6><c:out value="${review.authorLocation}" />,<c:out value="${review.authorLocation}" />,<c:out value="${review.reviewDate}" /></h6></td></tr>	
		<tr><td>
		<table>		
		<tr><td>Service</td><td><c:out value="${review.rating.service}" /></td></tr>
		<tr><td>cleanliness</td><td><c:out value="${review.rating.cleanliness}" /></td></tr>
		<tr><td>businessservice</td><td><c:out value="${review.rating.businessservice}" /></td></tr>
		<tr><td>checkInOrFrontDesk</td><td><c:out value="${review.rating.checkInOrFrontDesk}" /></td></tr>
		<tr><td>overall</td><td><c:out value="${review.rating.overall}" /></td></tr>
		<tr><td>value</td><td><c:out value="${review.rating.value}" /></td></tr>
		<tr><td>rooms</td><td><c:out value="${review.rating.rooms}" /></td></tr>
		<tr><td>location</td><td><c:out value="${review.rating.location}" /></td></tr>
		</table>		
		</td>
		</tr>
	</c:forEach>
	</table>


</body>
</html>