<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Registration</title>
  </head>
  <body>
    <h2>User Registration</h2>
    <form method="post" action="register.jsp">
      FirstName <input type="text" name="fname" /> <br /><br />
      LastName<input type="text" name="lname" /> <br /><br />
      Email <input type="text" name="email" /> <br /><br />
      Password <input type="text" name="password" /><br /><br />
      DOB<input type="date" name="dob"/><br /><br />
      <input type="submit" value="Submit" />
    </form>
  </body>
</html>