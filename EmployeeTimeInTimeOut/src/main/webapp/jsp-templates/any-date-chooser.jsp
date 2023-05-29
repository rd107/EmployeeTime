<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="menu.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<c:if test="${tlist=='[]'}">
   <div class='dv'>
    <h2 style='color:red'>Time list is empty</h2>
   </div>
  </c:if>
  <c:if test="${tlist!='[]'}">
  <table border='1' class='talist'>
   <tr>
    <th>Tid</th><th>Out Time</th><th>In Time</th><th>Total Time</th><th>Date</th><th>Name Of Employee</th>
   </tr>
   <c:forEach var="timer" items="${tlist}">
     <tr>
      <td>${timer.tid}</td>
      <td>${timer.outtime}</td>
      <td>${timer.intime}</td>
      <td>${timer.totaltime}</td>
      <td>${timer.date}</td>
      <td>${timer.employee.name}</td>
     </tr>
   </c:forEach>
  </table>
  </c:if>
</body>
</html>