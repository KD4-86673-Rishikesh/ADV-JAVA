<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Document</title>
  </head>
  <body >
    <center>
    <h2>Log In</h2>
    <form method="post" action="login.jsp">
      Email :<input type="text" name="email" /> <br /><br />
      Password: <input type="password" name="pass" /><br /><br />
      <input type="submit" value="Sign In" /><br /><br />
    </form>
      <button><a href="newuser.jsp">Sign up</a></button>
     </body>
     </center>
</html>
