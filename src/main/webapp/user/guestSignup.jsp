
<%--
  Created by IntelliJ IDEA.
  User: vinis
  Date: 16-05-2022
  Time: 11:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Sign Up</title>
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
<h1 style="text-align: center;"><%= "SIGN-UP PAGE" %></h1>
<br><br><br><br>
<form method="post" action="validateguest.jsp">

    <table>
        <thead>
        <tr>
            <th colspan="2">SIGN-UP</th>
        </tr>
        </thead>
        <tbody>
        <tr><td>&nbsp;</td></tr>
        <tr>
            <td>Guest Name: </td>
            <td><input type="text" name="guestname" required/></td>
        </tr>
        <tr>
            <td>Unique Username: </td>
            <td><input type="text" name="guestid" required/></td>
        </tr>
        <tr>
            <td>Email ID: </td>
            <td><input type="email" name="email" required/></td>
        </tr>
        <tr>
            <td>Contact Number: </td>
            <td><input type="tel" name="contactno" pattern="[0-9]{10}}" required/></td>
        </tr>
        <tr>
            <td>Address: </td>
            <td><input type="text" name="address"/></td>
        </tr>
        <tr>
            <td>Password: </td>
            <td><input type="password" name="guestpass" required/></td>
        </tr>
        <tr>
            <td colspan="2"><input type="submit" value="Signup" />
                &nbsp;&nbsp;
                <input type="reset" value="Reset" />
            </td>
        </tr>
        </tbody>
    </table>
</form>
</body>
</html>

<%--
  Created by IntelliJ IDEA.
  User: vinis
  Date: 16-05-2022
  Time: 11:45
  To change this template use File | Settings | File Templates.
--%>

