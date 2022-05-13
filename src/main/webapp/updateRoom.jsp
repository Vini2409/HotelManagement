<%--
  Created by IntelliJ IDEA.
  User: vinis
  Date: 13-05-2022
  Time: 09:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update Room</title>
    <style>
        body{
            background-image: url("https://images.unsplash.com/photo-1546412414-e1885259563a?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxzZWFyY2h8MTI1fHxob3RlbHxlbnwwfHwwfHw%3D&auto=format&fit=crop&w=500&q=60");
            background-repeat: no-repeat;
            color:black;
        }
        table{
            font-size:27px;
            border:3px solid black;
            padding:10px;
            margin-top:100px;
            margin-left:650px;
            box-shadow: 10px 10px 5px black;
        }
        table:hover{
            transform:scale(1.1);
        }
    </style>
</head>
<body>
<h1 style="margin-left:800px;">UPDATE A ROOM DETAILS</h1>
<table>
    <form name="f4" method="post" action="updationSuccess.jsp">
        <tr>
            <td>Room No: </td><td><input style="font-size:25px;" type="number" name="ava_room_id" required/></td>
        </tr>
        <tr><td>&nbsp;</td></tr>
        <tr><td></td><td style="font-weight: bold;font-size:30px;">Enter the field you want to update/edit</td></tr>
        <tr><td>&nbsp;</td></tr>
        <tr>
            <td>Floor: </td>
            <td>
                <input style="font-size:25px;" type="number" name="floor" placeholder="Floor">
            </td>
        </tr>
        <tr>
            <td>Price: </td>
            <td>
                <input style="font-size:25px;" type="number" name="price" placeholder="Price">
            </td>
        </tr>
        <td>Type: </td>
        <td>
            <input style="font-size:25px;" type="text" name="type" placeholder="Type">
        </td>
        </tr>
        <tr>

            <td><input style="font-size:25px;margin-left:150px;margin-top:50px;padding:5px;"  type="submit" value="SUBMIT"/></td>
        </tr>
    </form>
</table>
</body>
</html>
