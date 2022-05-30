<%--
  Created by IntelliJ IDEA.
  User: vinis
  Date: 21-05-2022
  Time: 16:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Forgot Password</title><style>
    body{
        background-image: url("https://media.istockphoto.com/photos/desperate-young-woman-trying-to-log-into-her-computer-forgot-password-picture-id820865690?k=20&m=820865690&s=612x612&w=0&h=sTFg1g8ypxcd3BVConaGMIGTOb6UQ3Hq2XeW_SrLKKo=");
        background-repeat: no-repeat;
        background-size:cover;
        color:black;
    }
    table{
        background:white;
        font-size:30px;
        border:3px solid black;
        padding:3px 0px 3px 0px;
        margin-left:500px;
        box-shadow: 7px 7px 5px black;
    }
</style>
</head>
<body>
<h1 style="text-align:center;">RESET YOUR PASSWORD</h1>
<table>
    <form method="post" action="changePasswordSuccess.jsp" id="f1">
        <tr><td>Email ID: </td><td><input style="font-size:20px;" type="text" name="email" required/></td></tr><br><br>
        <tr><td>Password: </td><td><input style="font-size:20px;" type="password" name="guestpass"/></td></tr><br><br>
        <tr><td><input style="font-size:25px;margin-left:150px;margin-top:50px;padding:5px;background-color: lightcyan;" type="submit" value="SUBMIT"/></td></tr>
    </form>
</table>
</body>
</html>
