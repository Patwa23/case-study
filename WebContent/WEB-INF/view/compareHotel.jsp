<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

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
	<h3><center>Welcome to Compare Page</center></h3>
	<input type="button" value="Back" onclick="javascript:history.go(-1)"><br/>	
	<c:set var = "count"  value ="1"/>	
	<c:forEach items="${comparedHotelList}" var="compareHotel">	
	 <c:if test="${count == 1}">
		<c:set var = "hotelInfo1"  value ="${compareHotel.hotelInfo}"/>
		<c:set var = "review1"  value ="${compareHotel.review}"/>
		<c:set var="count" value="${count + 1}"/>
	 </c:if>
	 <c:if test="${fn:length(comparedHotelList) == 2}">
		<c:set var = "hotelInfo2"  value ="${compareHotel.hotelInfo}"/>
		<c:set var = "review2"  value ="${compareHotel.review}"/>	
	 </c:if>	 
	</c:forEach>	
	

	<table border="4px" bordercolor="black" width=80% align="center"
		style="table-layout: fixed;">	
		<tr>
			<td><b><c:out value="Hotel Name"/></b></td>
			<td><b><c:out value="${hotelInfo1.name}"/> (${hotelInfo1.hotelID})</b></td>
			<td><b><c:out value="${hotelInfo2.name}"/> (${hotelInfo2.hotelID})</b></td>
		</tr>
		<tr>
			<td><b><c:out value="Price"/></b></td>
			<td><c:out value="${hotelInfo1.price}"/></td>
			<td><c:out value="${hotelInfo2.price}"/></td>
		</tr>
		<tr>
			<td><b><c:out value="Address"/></b></td>
			<td>${hotelInfo1.address}</td>
			<td>${hotelInfo2.address}</td>
		</tr>
		<tr>
			<td><b><c:out value="Semantics"/></b></td>
			<td valign="top">
                        		Positive : <b><font color="#007fad"><c:out value="${hotelInfo1.positive}"/></font></b>
                        		Negative : <b><font color="#f48f00"><c:out value="${hotelInfo1.negative}" /></font></b>
                        		Intensifier : <b><font color="#c94a30"><c:out value="${hotelInfo1.intensifier}" /></font></b>
             </td>
			<td valign="top">
                        		Positive : <b><font color="#007fad"><c:out value="${hotelInfo2.positive}"/></font></b>
                        		Negative : <b><font color="#f48f00"><c:out value="${hotelInfo2.negative}" /></font></b>
                        		Intensifier : <b><font color="#c94a30"><c:out value="${hotelInfo2.intensifier}" /></font></b>
             </td>
		</tr>		
		<tr><td><b><c:out value="Review Rating"/></b></td>
		<td>
			<table>
				<c:forEach items="${review1}" var="review">
				<tr><td>Service</td><td><c:out value="${review.rating.service}" /></td></tr>
				<tr><td>cleanliness</td><td><c:out value="${review.rating.cleanliness}" /></td></tr>
				<tr><td>businessservice</td><td><c:out value="${review.rating.businessservice}" /></td></tr>
				<tr><td>checkInOrFrontDesk</td><td><c:out value="${review.rating.checkInOrFrontDesk}" /></td></tr>
				<tr><td>overall</td><td><c:out value="${review.rating.overall}" /></td></tr>
				<tr><td>value</td><td><c:out value="${review.rating.value}" /></td></tr>
				<tr><td>rooms</td><td><c:out value="${review.rating.rooms}" /></td></tr>
				<tr><td>location</td><td><c:out value="${review.rating.location}" /></td></tr>
				</c:forEach>			
			</table>
		</td>
		<td>
			<table>
				<c:forEach items="${review2}" var="review">
				<tr><td>Service</td><td><c:out value="${review.rating.service}" /></td></tr>
				<tr><td>cleanliness</td><td><c:out value="${review.rating.cleanliness}" /></td></tr>
				<tr><td>businessservice</td><td><c:out value="${review.rating.businessservice}" /></td></tr>
				<tr><td>checkInOrFrontDesk</td><td><c:out value="${review.rating.checkInOrFrontDesk}" /></td></tr>
				<tr><td>overall</td><td><c:out value="${review.rating.overall}" /></td></tr>
				<tr><td>value</td><td><c:out value="${review.rating.value}" /></td></tr>
				<tr><td>rooms</td><td><c:out value="${review.rating.rooms}" /></td></tr>
				<tr><td>location</td><td><c:out value="${review.rating.location}" /></td></tr>
				</c:forEach>			
			</table>
		</td>			
		</tr>
		<tr>
			<td><b><c:out value="Image"/></b></td>
			<td><image src="${hotelInfo1.imgURL}" width="350" height="200" /></td>
			<td><image src="${hotelInfo2.imgURL}" width="350" height="200" /></td>
		</tr>		
	</table>
	
	
	
</body>
</html>