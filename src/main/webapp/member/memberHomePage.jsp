<%--
  Created by IntelliJ IDEA.
  User: vinis
  Date: 16-05-2022
  Time: 18:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Home</title>
    <style>
        body{
            background-image:url("https://images.unsplash.com/photo-1568084680786-a84f91d1153c?crop=entropy&cs=tinysrgb&fm=jpg&ixlib=rb-1.2.1&q=60&raw_url=true&ixid=MnwxMjA3fDB8MHxzZWFyY2h8Nnx8aG90ZWwlMjBtYW5hZ2VtZW50fGVufDB8fDB8fA%3D%3D&auto=format&fit=crop&w=500");
            background-repeat: no-repeat;
            background-size: cover;
            color:black;
        }
        /*a{*/
        /*    font-size: 40px;*/
        /*    text-decoration: none;*/
        /*    color:black;*/
        /*    background-color: white;*/
        /*    margin-left:30px;*/
        /*    border: 1px solid #F9084A;*/
        /*    box-shadow: 5px 5px 3px #F9084A;*/
        /*}*/
        a{
            text-decoration: none;
            color:black;
            font-size:30px;
            text-align: center;
            padding:7px;
            margin:23px;
            border:2px solid black;
            box-shadow: 10px 10px 10px black;
        }
        nav{
            display:inline-block;
            /*margin:20px;*/
            padding:10px;
            float:right;
            background-color: white;
        }
    </style>
</head>
<body>
<nav>
    <a href="../common/booking.jsp">BOOK</a>
    <a href="../common/search.jsp">SEARCH</a>
    <a href="../common/searchByDate.jsp">SEARCH ON DATE</a>
    <a href="displayAvalibleRooms.jsp">ROOMS</a>
    <a href="../common/displayBookedDetails.jsp">BOOKING DETAILS</a>
    <a href="editMemberProfile.jsp">EDIT</a>
    <a href="../common/logout.jsp">LOGOUT</a>
</nav>
</body>
</html>
