<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>delete Candidate</title>
</head>
<body>
	<h2>delete Candidate</h2>
	<jsp:useBean id="dcb" class="com.sunbeam.beans.delCandidateBean"/>
	<jsp:setProperty name="dcb" property="candId" param="id" />
	${dcb.deleteCandidate()}
	<c:choose>
		<c:when test="${dcb.delStatus == 1}">
			<jsp:forward page="result.jsp">
				<jsp:param name="msg" value="Candidate deleted Successfully." />
			</jsp:forward>
		</c:when>
		<c:otherwise>
			<jsp:forward page="result.jsp">
				<jsp:param name="msg" value="Candidate Update Failed." />
			</jsp:forward>		
		</c:otherwise>
	</c:choose>
</body>
</html>