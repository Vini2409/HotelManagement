<%--
  Created by IntelliJ IDEA.
  User: vinis
  Date: 12-05-2022
  Time: 12:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Search</title>
    <style>
        body{
            background-image: url("https://images.unsplash.com/photo-1455587734955-081b22074882?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxzZWFyY2h8M3x8aG90ZWx8ZW58MHx8MHx8&auto=format&fit=crop&w=500&q=60");
            background-repeat: no-repeat;
            background-size: 900px;
            color:black;
        }
        table{
            font-size:27px;
            border:3px solid black;
            padding:10px;
            margin-top:100px;
            margin-left:950px;
            box-shadow: 10px 10px 5px black;
        }
        table:hover{
            transform:scale(1.1);
        }

    </style>
</head>
<body>
<h1 style="margin-left:1000px;">SEARCH ROOMS</h1>
<table>
<form name="f1" method="post" action="searchsuccess.jsp" id="f1">
    <tr><td>Floor: </td><td><input style="font-size:25px;" type="number" name="floor"/></td></tr><br><br>
    <tr><td>Price: </td><td><input style="font-size:25px;" type="number" name="price"/></td></tr><br><br>
    <tr><td>Type: </td><td>
        <select style="font-size:27px;" name="type">
            <option value=""></option>
            <option value="standard">Standard</option>
            <option value="dulex">Dulex</option>
            <option value="family suite">Family Suite</option>
        </select>
    </td></tr><br><br>
    <tr><td>&nbsp;</td><td><input style="text-align: center;size:20px;padding:20px;border-radius: 8px;background-color: green;color:white;cursor:pointer;margin:10px 0px 0px 60px;" type="submit" value="SEARCH"/></td></tr>
</form>
</table>
</body>
</html>
