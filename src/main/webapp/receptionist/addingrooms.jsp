<%--
  Created by IntelliJ IDEA.
  User: vinis
  Date: 12-05-2022
  Time: 10:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Adding Rooms</title>
    <style>
        body{
            background-image: url("https://media.istockphoto.com/photos/double-bedroom-with-sea-view-picture-id1299710067?b=1&k=20&m=1299710067&s=170667a&w=0&h=hLOPJ6LWpsD0y7rqqLZ4lUZebHpymoyNXWZT6qntTY8=");
            background-repeat: no-repeat;
            background-size: cover;
            color:black;
        }
        table{
            font-size:27px;
            border:3px solid black;
            padding:10px;
            margin-left:30px;
            box-shadow: 7px 7px 5px black;
        }
        table:hover{
            transform:scale(1.1);
        }
    </style>
</head>
<body>
<table>
<form name="f1" method="post" action="insertRoomSuccess.jsp" id="f1">
    <tr><td>Room Number: </td><td><input style="font-size:25px;" type="number" name="ava_room_id"/></td></tr><br><br>
    <tr><td>Floor: </td><td><input style="font-size:25px;" type="number" name="floor"/></td></tr><br><br>
    <tr><td>Price: </td><td><input style="font-size:25px;" type="number" name="price"/></td></tr><br><br>
    <tr><td>Type: </td><td>
        <select style="font-size:27px;" name="type">
            <option value="standard">Standard</option>
            <option value="dulex">Dulex</option>
            <option value="family suite">Family Suite</option>
        </select>
    </td></tr><br><br>
    <tr><td><input style="font-size:25px;margin-left:150px;margin-top:50px;padding:5px;" type="submit" value="ADD"/></td></tr>
</form>
</table>
</body>
</html>
