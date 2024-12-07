<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>login</title>
</head>
<body>
  <div>
   <jsp:useBean id="lb" class="com.sunbeam.beans.LoginBean" scope="session"/>
   <jsp:setProperty property="*" name="lb"/>
    ${lb.authenticate()} 
   <c:choose>
		<c:when test="${lb.getUser()!=null}">
			<c:choose>
				<c:when test="${lb.user.role == 'admin'}">
					<c:redirect url="result.jsp"/>	
				</c:when>
				<c:otherwise>
					<c:redirect url="candlist.jsp"/>
				</c:otherwise>
			</c:choose>
		</c:when>
		<c:otherwise>
		    Login failed <br><br>
		    <a href="index.jsp">Log in Again</a>
		</c:otherwise>
	</c:choose>
   
  </div> 
</body>
</html>

	