<%--
  Created by IntelliJ IDEA.
  User: vinis
  Date: 16-05-2022
  Time: 16:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
  <style>
    body{
    background-image: url("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcR0YrNAgjeaN4M3KtsIL0MDtoXiz8Vh4q_Els8SvX3v3ELg0wj51bOd0HLNEeJtfHpg0yY&usqp=CAU");
    background-repeat: no-repeat;
    background-size: cover;
    color: white;
    }
    table{
    font-size:30px;
    margin-left:600px;
    padding: 10px;
    border:3px solid white;
    box-shadow: 10px 10px 5px white;
    }
    td{
    font-size:25px;
    }
</style>
</head>
<body>
<h1 style="text-align: center;"><%= "LOGIN PAGE" %></h1>
<br><br><br><br>
<form method="post" action="../ServletRecp">

  <table>
    <thead>
    <tr>
      <th colspan="2">Login Here</th>
    </tr>
    </thead>
    <tbody>
    <tr><td>&nbsp;</td></tr>
    <tr>
      <td>Username: </td>
      <td><input type="text" name="username" required/></td>
    </tr>
    <tr>
      <td>Password: </td>
      <td><input type="password" name="userpass" required/></td>
    </tr>
    <tr>
      <td colspan="2"><input type="submit" value="Login" />
        &nbsp;&nbsp;
        <input type="reset" value="Reset" />
      </td>
    </tr>
    </tbody>
  </table>
</form>
</body>
</html>
