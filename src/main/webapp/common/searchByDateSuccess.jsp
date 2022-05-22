<%@ page import="com.example.task.searchdate" %>
<%@ page import="com.example.task.hotelBean" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: vinis
  Date: 17-05-2022
  Time: 12:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Search</title>
    <style>
        body{
            background-image: url("https://images.unsplash.com/photo-1546484396-fb3fc6f95f98?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxzZWFyY2h8N3x8cGxhaW4lMjBiYWNrZ3JvdW5kfGVufDB8fDB8fA%3D%3D&auto=format&fit=crop&w=500&q=60");
            color:white;
            font-size:30px;
        }
        /*table{*/
        /*    display:grid;*/
        /*    grid-template-columns: auto auto auto;*/
        /*    font-size:27px;*/
        /*    border:3px solid white;*/
        /*    margin-left:570px;*/
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
            background-color: green;
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
    <a href="../member/displayAvalibleRooms.jsp">ROOMS</a>
</nav>
<br><br><br>
<h1 style="color:white;text-align: center;">SEARCH RESULT</h1><br/>

<jsp:useBean id="obj" class="com.example.task.hotelBean"></jsp:useBean>
<jsp:setProperty property="*" name="obj"/>

<%
    List<hotelBean> list= searchdate.roomsearchByDate(obj);
    StringBuilder template = new StringBuilder();
    if(list.size()==0){
        template.append("<tr>No Rooms with the given specification. Check the available rooms</tr>");
    }
    else {
        for (hotelBean s : list) {
            template.append("<form action=booking.jsp method='post' >");
            template.append("<div class=styling>");
            template.append("ROOM NUMBER: ").append(s.getAva_room_id()).append("<br>Floor: ").append(s.getFloor()).append("</br>Price: ").append(s.getPrice()).append("</br>Type: ").append(s.getType()).append("<center>").append("</br><Button name='1234' value=").append(s.getAva_room_id()).append(">BOOK THIS ROOM</Button></center></div>");
        }
        template.append("</form>");
    }
%>
<table>
    <%=template.toString()%>
</table><br/><br/>
</body>
</html>
