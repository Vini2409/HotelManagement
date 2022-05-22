<%--
  Created by IntelliJ IDEA.
  User: vinis
  Date: 21-05-2022
  Time: 19:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
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
<h1 style="margin-left:1000px;">SEARCH ROOMS BY DATE</h1>
<table>
    <form method="post" action="userSearchByDateSuccess.jsp" id="f1">
        <tr><td>Check Out: </td><td><input style="font-size:25px;" type="date" name="checkout" placeholder="dd-mm-yyy"/></td></tr><br><br>
        <tr><td>&nbsp;</td><td><input style="text-align: center;size:20px;padding:20px;border-radius: 8px;background-color: green;color:white;cursor:pointer;margin:10px 0px 0px 0px;" type="submit" value="SEARCH"/></td></tr>
    </form>
</body>
</html>
