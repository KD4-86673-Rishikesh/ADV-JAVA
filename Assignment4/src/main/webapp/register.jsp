<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>register</title>
</head>
<body>
  <div>
   <jsp:useBean id="rb" class="com.sunbeam.beans.RegisterBean"/>
   <jsp:setProperty property="*" name="rb"/>
   ${rb.register()}
   <c:choose>
		<c:when test="${rb.getSave()==1}">
		<h3>Welcome <jsp:getProperty property="fname" name="rb"/> </h3>
        <a href="index.jsp">Sign up</a>
         <h3>Registration done Successful !!!</h3>
		</c:when>
		<c:otherwise>
			<h3>Registration failed</h3>
		</c:otherwise>
	</c:choose>
  </div> 
</body>
</html>



			
		
		

