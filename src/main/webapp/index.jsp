<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
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
<form method="post" action="validate.jsp">

        <table>
            <thead>
            <tr>
                <th colspan="2">Login Here</th>
            </tr>
            </thead>
            <tbody>
            <tr><td>&nbsp;</td></tr>
            <tr>
                <td>UserID: </td>
                <td><input type="number" name="userid" required/></td>
            </tr>
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