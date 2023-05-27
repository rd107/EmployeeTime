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

	 <form action="record-outtime-controller" method="post">
  <div class='dv'>
   <label class='hdu'>Record employee out time</label>
  </div>
  <div class='dv'>
   <select name="eid" id="eid" class='la'>
   	 <option value="-1">Select Employee</option>
   	 <!-- ps.setString(1,"in"); -->
   	 <c:forEach var="employee" items="${elist}">
   				<option value='${employee.eid }'>${employee.name}(${employee.eid})</option>
     </c:forEach>
   </select>
  </div>
  <div class='dv'>
   <button id='bt' class='btn btn-primary'>Submit</button>
  </div>
  <div class='dvv' id='msg'>
  </div> 
 </form> 

</body>
</html>