<%@ page import="com.example.task.hotelBean" %>
<%@ page import="java.util.List" %>
<%@ page import="com.example.task.users" %><%--
  Created by IntelliJ IDEA.
  User: vinis
  Date: 16-05-2022
  Time: 18:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Users</title>
    <style>
        body{
            background-image: url("https://images.unsplash.com/photo-1546484396-fb3fc6f95f98?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxzZWFyY2h8N3x8cGxhaW4lMjBiYWNrZ3JvdW5kfGVufDB8fDB8fA%3D%3D&auto=format&fit=crop&w=500&q=60");
            color:white;
            font-size:30px;
            text-align:center;
        }
        table{
            font-size:27px;
            border:3px solid white;
            margin-left:300px;
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
    <a href="displayBookedUsers.jsp">BOOKED USER</a>
    <a href="guestSignup.jsp">ADD</a>
    <a href="removeUser.jsp">REMOVE</a>
</nav>
<br><br><br>
<h1 style="color:white;text-align: center;">USERS BOOKED</h1><br/><br/>
<br><br>
<%

    List<hotelBean> list= users.getAllUser();
    StringBuilder template = new StringBuilder();
    if(list.size()==0){
        template.append("<tr>No users have booked</tr>");
    }
    else {
        template.append("<tr>").append("<td> Name</td>").append("<td>Unique ID</td>").append("<td>Email ID</td>").append("<td>Contact Number</td>").append("<td>Address</td></tr>\n");
        for (hotelBean s : list) {
            template.append(" <tr><td>").append(s.getGuestname()).append("</td><td>").append(s.getGuestid()).append("</td><td>").append(s.getEmail()).append("</td><td>").append(s.getContactno()).append("</td><td>").append(s.getAddress()).append("</td></tr>\n");
        }
    }
%>
<table>
    <%=template.toString()%>
</table>
</body>
</html>
