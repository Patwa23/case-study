<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html>
<head>
<link  rel="stylesheet" href= "${cssURL}">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>
<body>
<h1>
<center><span  style="color:#007fad">tri</span><span  style="color:#f48f00">va</span><span  style="color:#c94a30">go</span></center>
</h1>
<hr>   
<h3><center>Welcome to View All Hotel Page</center></h3>
						<input type="button" value="Back" onclick="javascript:history.go(-1)">        
                        <table><tr><td width=80% >   
                        <table border="4px" bordercolor="black"  align="left">
                        <colgroup>
					        <col style="width: 250px;">
					        <col style="width: auto;">
					          <!-- Use "width: auto;" to apply the remaining (unused) space -->
					        <col style="width: 150px">
					        <col style="width: 100px">
					    </colgroup>
					   <c:forEach items="${hotelList}" var="hotel">  
                        <tr><td style="word-wrap: break-word;"  ><a href="hoteldetail/${hotel.hotelInfo.hotelID}"><image src="${hotel.hotelInfo.imgURL}"  height="200"/></a> ${hotel.hotelInfo.hotelURL} </td>
                        	<td valign="top"><table >
                        		<tr ><td ><b><a href="hoteldetail/${hotel.hotelInfo.hotelID}"><c:out value="${hotel.hotelInfo.name}" /> (${hotel.hotelInfo.hotelID}) </a></b></td>
                        		<tr><td>${hotel.hotelInfo.address}</td></tr>
                        		<tr><td valign="top">
                        		Positive : <b><font color="#007fad"><c:out value="${hotel.hotelInfo.positive}"/></font></b>
                        		Negative : <b><font color="#f48f00"><c:out value="${hotel.hotelInfo.negative}" /></font></b>
                        		Intensifier : <b><font color="#c94a30"><c:out value="${hotel.hotelInfo.intensifier}" /></font></b>
                        		</td></tr> 
                        		</table> 
                        	</td>                    	
                        	<td valign="top"><c:out value="${hotel.hotelInfo.price}" /></td>                      	
                        	<%-- <c:if test="${comparedHotelList.size=<2}"> --%>
                        	<c:if test="${fn:length(comparedHotelList) < 2}">
                        	<td>                        		                        		
                        		<a href="addhoteltocompare/${hotel.hotelInfo.hotelID}"> compare (+) </a>
                        	</td>                       
                        	</c:if>                       	                      		                                         	
                        </tr>
                        </c:forEach>
                        </table>
                        </td>
                        <td valign = "top">
                        <table border="4px" bordercolor="black"  width=100%  cellspacing="0" cellpadding="2" align="center"  border="0">                        
                        <tr><td align="center" > <h2>Compare</h2></td></tr>
                        <c:if test="${fn:length(comparedHotelList) > 2}">
                        	<td>                        		                        		
                        		${message}
                        	</td>                       
                        </c:if>                        
                        <c:forEach items="${comparedHotelList}" var="comparedHotel">                                                 
                         <tr><td> ${comparedHotel.hotelInfo.name}  <a href="removehoteltocompare/${comparedHotel.hotelInfo.hotelID}" style="color:red"> Delete (-) </a></td></tr>
                        </c:forEach>
                         <c:if test="${fn:length(comparedHotelList) >= 2}">
                        <td align="center">                        		                        		
                        		<a href="comparehotel"> Compare </a>                       		
                        </td>  
                        </c:if> 
                        </table> 
                        </td>
                        </tr>
                        </table>  
      </body>
</html>




  	