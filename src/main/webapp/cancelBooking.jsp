<%--
  Created by IntelliJ IDEA.
  User: vinis
  Date: 13-05-2022
  Time: 19:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Cancel Booking</title>
    <style>
        body{
            background-image: url("https://media.istockphoto.com/photos/entering-hotel-room-picture-id512882668?b=1&k=20&m=512882668&s=170667a&w=0&h=kNT_80jpErymHZCCCRMVbRJSR8wMOy8UQ-WAbi6EsLY=");
            background-repeat: no-repeat;
            background-size: 1000px;
            color:black;
        }
        table{
            font-size:20px;
            border:3px solid black;
            padding:3px 0px 3px 0px;
            margin:270px 0px 0px 990px;
            box-shadow: 7px 7px 5px black;
        }
    </style>
</head>
<body>
<table>
    <form name="f1" method="post" action="cancelBookingSuccess.jsp" id="f1">
        <tr><td>Phone Number: </td><td><input style="font-size:20px;" type="number" name="phoneno"/></td></tr><br><br>
        <tr><td><input style="font-size:25px;margin-left:150px;margin-top:50px;padding:5px;background-color: lightcyan;" type="submit" value="SUBMIT"/></td></tr>
    </form>
</table>
</body>
</html>
