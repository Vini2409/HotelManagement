<%@ page import="com.example.task.hotelBean" %>
<%@ page import="java.util.List" %>
<%@ page import="com.example.task.users" %><%--
  Created by IntelliJ IDEA.
  User: vinis
  Date: 13-05-2022
  Time: 09:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Users Booked</title>
    <style>
        body{
            background-image: url("https://images.unsplash.com/photo-1546484396-fb3fc6f95f98?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxzZWFyY2h8N3x8cGxhaW4lMjBiYWNrZ3JvdW5kfGVufDB8fDB8fA%3D%3D&auto=format&fit=crop&w=500&q=60");
            color:white;
            font-size:30px;
        }
        /*table{*/
        /*    font-size:27px;*/
        /*    border:3px solid white;*/
        /*    margin-left:300px;*/
        /*}*/
        /*tr,td{*/
        /*    border:3px solid white;*/
        /*}*/
        a{
            text-decoration: none;
            color:navajowhite;
            font-size:30px;
            text-align: center;
            padding:7px;
            margin:5px;
            border:2px solid navajowhite;
        }
        /*table:hover{*/
        /*    transform:scale(1.1);*/
        /*}*/
        nav{
            display:inline-block;
            margin:10px;
            padding:5px;
            float:right;
            background-color: black;
        }
        .styling{
            margin:40px;
            display:inline-block;
            padding:5px;
            border:3px solid white;
            box-shadow: 10px 10px 10px white;
        }
        .styling:hover{
            transform:scale(1.1);
        }
        button{
            text-align: center;
            size:20px;
            padding:20px;
            border-radius: 8px;
            background-color: red;
            color:white;
            cursor:pointer;
            margin:3px;
        }
        button:hover{
            transform:scale(1.1);
        }
    </style>
</head>
<body>
<nav>
    <a href="Home.jsp">HOME </a>
    <a href="../user/displayAvalibleRooms.jsp">ROOMS</a>
    <a href="../common/logout.jsp">LOGOUT</a>
</nav>
<br><br><br>
<h1 style="color:white;text-align: center;">USERS BOOKED</h1><br/><br/>
<%

    List<hotelBean> list= users.getAllBookedRecords();
    StringBuilder template = new StringBuilder();
    if(list.size()==0){
          template.append("<tr>No users have booked</tr>");
    }
    else {
        for (hotelBean s : list) {
            template.append("<form action=../common/cancelBooking.jsp method='post' >");
               template.append("<div class=styling>");
//            template.append("Room Number: ").append(s.getRoomno()).append("</br>Name: ").append(s.getClientname()).append("<input type=hidden name='gid' value=").append(s.getClientname()).append(">").append("</br>Check In Date: ").append(s.getCheckin()).append("</br>Check Out Date: ").append(s.getCheckout()).append("<center>").append("</br><Button name='1234' value=").append(s.getRoomno()).append(">CANCEL BOOKING</Button></center></div>");
               template.append("Room Number: ").append(s.getRoomno()).append("</br>Name: ").append(s.getClientname()).append("<input type=hidden name='gid' value=").append(s.getClientname()).append(">").append("</br>No_Of_People: ").append(s.getNo_of_person()).append("</br>Check In Date: ").append(s.getCheckin()).append("</br>Check Out Date: ").append(s.getCheckout()).append("<center>").append("</br><Button name='1234' value=").append(s.getRoomno()).append(">CANCEL BOOKING</Button></center></div>");
//            template.append(" <tr><td>").append(s.getRoomno()).append("</td><td>").append(s.getClientname()).append("</td><td>").append(s.getEmail()).append("</td><td>").append(s.getContactno()).append("</td><td>").append(s.getNo_of_person()).append("</td><td>").append(s.getCheckin()).append("</td><td>").append(s.getCheckout()).append("</td></tr>\n");
        }
    }
%>
<table>
    <%=template.toString()%>
</table>
</body>
</html>
