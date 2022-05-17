<%--
  Created by IntelliJ IDEA.
  User: vinis
  Date: 11-05-2022
  Time: 18:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Booking</title>
    <style>
        body{
            background-image: url("https://images.unsplash.com/photo-1586611292717-f828b167408c?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxzZWFyY2h8Mjh8fGhvdGVsfGVufDB8fDB8fA%3D%3D&auto=format&fit=crop&w=500&q=60");
            background-repeat: no-repeat;
            background-size: cover;
            color:black;
        }
        table{
            font-size:27px;
            border:3px solid black;
            padding:10px;
            margin-left:30px;
            box-shadow: 10px 10px 5px black;
        }
        table:hover{
            transform:scale(1.1);
        }
    </style>
</head>
<body>
<h1 style="text-align:center;">BOOK YOUR ROOM</h1>
<table>
    <form name="f1" method="post" action="userdb.jsp" id="f1">
        <tr><td>Room Number: </td><td><input style="font-size:25px;" type="number" name="roomno"/></td></tr><br><br>
        <tr><td>User Name: </td><td><input style="font-size:25px;" type="text" name="clientname"/></td></tr><br><br>
        <tr><td>No Of Person: </td><td><input style="font-size:25px;" type="number" name="no_of_person"/></td></tr><br><br>
        <tr><td>Check In: </td><td><input style="font-size:25px;" type="date" name="checkin" placeholder="dd-mm-yyy"/></td></tr><br><br>
        <tr><td>Check Out: </td><td><input style="font-size:25px;" type="date" name="checkout" placeholder="dd-mm-yyy"/></td></tr><br><br>
        <tr><td><input style="font-size:25px;margin-left:150px;margin-top:50px;padding:5px;" type="submit" value="SUBMIT"/></td></tr>
    </form>
</table>
</body>
</html>
