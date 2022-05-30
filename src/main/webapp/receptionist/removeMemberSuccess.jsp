<%--
  Created by IntelliJ IDEA.
  User: vinis
  Date: 22-05-2022
  Time: 13:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Remove User</title>
    <style>
        body{
            background-image: url("https://images.unsplash.com/photo-1546484396-fb3fc6f95f98?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxzZWFyY2h8N3x8cGxhaW4lMjBiYWNrZ3JvdW5kfGVufDB8fDB8fA%3D%3D&auto=format&fit=crop&w=500&q=60");
            color:white;
            font-size:40px;
            text-align:center;
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
<%@ page import="com.example.task.managerooms" %>
<%@ page import="com.example.task.manageuser" %>
<jsp:useBean id="obj" class="com.example.task.hotelBean"></jsp:useBean>
<jsp:setProperty property="*" name="obj"/>
<nav>
    <a href="Home.jsp">HOME </a>
    <a href="../user/displayAvalibleRooms.jsp">ROOMS</a>
    <a href="../common/logout.jsp">LOGOUT</a>
</nav>
<br><br><br>
<h1 style="color:white;text-align: center;">DELETION STATUS</h1><br/>
<h1>
    <%
        int status= manageuser.removeMember(obj);
        if(status>0)
            out.println("Removed successfully");
        else
            out.println("Failed to remove");
    %>
</h1>
</body>
</html>
