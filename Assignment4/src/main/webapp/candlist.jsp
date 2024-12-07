<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>candidate List</title>
</head>
<body>
     <jsp:useBean id="clb" class="com.sunbeam.beans.CandidateBean"/>
     ${clb.loadCandidates()}
    <form method="post" action="vote.jsp">
		<c:forEach var="c" items="${clb.list}">
			<input type="radio" name="candidate" value="${c.id}"/> ${c.name} - ${c.party} <br/>
		</c:forEach>	
		<br/>
		<input type="submit" value="Vote"/>
	</form>
     <h2>Hello</h2>
</body>
</html>





