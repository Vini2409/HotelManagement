<%--
  Created by IntelliJ IDEA.
  User: vinis
  Date: 12-05-2022
  Time: 22:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Home</title>
    <style>
        body{
            background-color:#08F9E6;
            background-repeat: no-repeat;
            background-size: cover;
            color:black;
        }
        a{
            font-size: 40px;
            text-decoration: none;
            color:black;
            /*background-color: white;*/
            /*border: 1px solid #F9084A;*/
            /*box-shadow: 5px 5px 3px #F9084A;*/
        }
        .grids{
            margin:40px;
            display:grid;
            grid-template-columns: auto auto auto;
        }
        .styling{
            padding:5px;
            border:3px solid black;
            box-shadow: 10px 10px 10px black;
            margin:10px;
        }
        .styling:hover{
            transform:scale(1.1);
        }
    </style>
</head>
<body>

<h1 style="font-size: 50px;text-align: center;text-shadow: 2px 2px #F9084A;">HOTEL MANAGEMENT</h1><br><br>
<div class="grids">
    <div class="styling"><h3><a href="../common/bookARoom.jsp">BOOK A ROOM</a></h3></div>
    <div class="styling"><h3><a href="../common/search.jsp">SEARCH ROOMS BASED ON CONDITIONS</a></h3></div>
    <div class="styling"><h3><a href="displayRoomRecep.jsp">DISPLAY AVAILABLE ROOMS</a></h3></div>
    <div class="styling"><h3><a href="../common/cancelBooking.jsp">CANCEL BOOKING OF USERS</a></h3></div>
    <div class="styling"><h3><a href="displayAllUser.jsp">DISPLAY ALL THE USERS</a></h3></div>
    <div class="styling"><h3><a href="../common/logout.jsp">LOGOUT</a></h3></div>
</div>
</body>
</html>
