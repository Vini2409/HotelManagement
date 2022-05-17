<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
    <style>
        body{
            background-image: url("https://images.unsplash.com/photo-1545403842-6b8149e2759e?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1171&q=80");
            background-repeat: no-repeat;
            background-size: cover;
            text-align: center;
            margin:200px 0px 0px 0px;
            font-size:50px;
        }
        a{
            text-decoration: none;
            color:#F9084A;
            font-weight: bolder;
        }
        table{
            background: black;
            margin-left:450px;
            margin-top:370px;
            padding: 10px;
            color:#F9084A;
            border:3px solid #F9084A;
            box-shadow: 10px 10px 5px #F9084A;
        }
    </style>
</head>
<body>
<table>
    <thead>
    <tr>
        <th colspan="2">WELCOME</th>
    </tr>
    </thead>
    <tbody>
    <tr><td>&nbsp;</td></tr>
    <tr>
        <td><a href="receptionistLogin.jsp">LOGIN AS RECEPTIONIST</a></td>
    </tr>
    <tr>
        <td><a href="guestLogin.jsp">LOGIN AS GUEST</a></td>
    </tr>
    </tbody>
</table>
</body>
</html>