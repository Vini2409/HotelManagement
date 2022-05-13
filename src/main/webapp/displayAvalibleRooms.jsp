<%@ page import="java.util.List" %>
<%@ page import="com.example.task.hotelBean" %>
<%@ page import="com.example.task.AvalibleRoom" %><%--
  Created by IntelliJ IDEA.
  User: vinis
  Date: 12-05-2022
  Time: 09:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Avalible rooms</title>
    <style>
        body{
            background-image: url("https://images.unsplash.com/photo-1546484396-fb3fc6f95f98?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxzZWFyY2h8N3x8cGxhaW4lMjBiYWNrZ3JvdW5kfGVufDB8fDB8fA%3D%3D&auto=format&fit=crop&w=500&q=60");
            color:white;
        }
        table{
            font-size:27px;
            border:3px solid white;
            margin-left:570px;
        }
        tr,td{
            border:3px solid white;
        }
        a{
            text-decoration: none;
            color:navajowhite;
            font-size:30px;
            text-align: center;
            padding:7px;
            margin:5px;
            border:2px solid navajowhite;
        }
        table:hover{
            transform:scale(1.1);
        }
        nav{
            display:inline-block;
            margin:10px;
            padding:5px;
            float:right;
            background-color: black;
        }
    </style>
</head>
<body>
<nav>
    <a href="Home.jsp">HOME </a>
    <a href="addingrooms.jsp">ADD</a>
    <a href="deleteRoom.jsp">DELETE</a>
    <a href="updateRoom.jsp">UPDATE</a>
</nav>
<br><br><br>
<h1 style="color:white;text-align: center;">AVAILABLE ROOMS</h1><br/><br/>
<br><br>
<%
    List<hotelBean> list= AvalibleRoom.getAllAvalibleRoom();
    StringBuilder template = new StringBuilder();
    for (hotelBean s : list) {
        template.append(" <tr><td>").append(s.getAva_room_id()).append("</td><td>").append(s.getFloor()).append("</td><td>").append(s.getPrice()).append("</td><td>").append(s.getType()).append("</td></tr>\n");
    }
%>
<table>
    <tr><th>Room Number</th><th>Floor</th><th>Price</th><th>Type</th></tr>
    <%=template.toString()%>
</table>

</body>
</html>
