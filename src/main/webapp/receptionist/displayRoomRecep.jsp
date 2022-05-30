<%@ page import="com.example.task.hotelBean" %>
<%@ page import="java.util.List" %>
<%@ page import="com.example.task.AvalibleRoom" %>
<%@ page import="java.util.stream.Collectors" %>
<%@ page import="com.example.task.Search" %>
<%@ page import="java.lang.management.LockInfo" %>
<%@ page import="javax.management.openmbean.CompositeData" %><%--
  Created by IntelliJ IDEA.
  User: vinis
  Date: 20-05-2022
  Time: 16:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Rooms</title>
    <style>
        body{
            background-image: url("https://images.unsplash.com/photo-1546484396-fb3fc6f95f98?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxzZWFyY2h8N3x8cGxhaW4lMjBiYWNrZ3JvdW5kfGVufDB8fDB8fA%3D%3D&auto=format&fit=crop&w=500&q=60");
            color:white;
            font-size:30px;
        }
        table{
            font-size:27px;
            border:3px solid white;
            margin-left:150px;
            text-align:center;
            padding:50px;
            background-color: black;
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
        /*tr:hover{*/
        /*    transform:scale(1.1);*/
        /*}*/
        nav{
            display:inline-block;
            margin:10px;
            padding:5px;
            float:right;
            background-color: black;
        }
        /*.styling{*/
        /*    margin:60px;*/
        /*    display:inline-block;*/
        /*    padding:5px;*/
        /*    border:3px solid white;*/
        /*    box-shadow: 10px 10px 10px white;*/
        /*}*/
        /*.styling:hover{*/
        /*    transform:scale(1.1);*/
        /*}*/
        button{
            text-align: center;
            padding:20px;
            border-radius: 8px;
            background-color: #87EA4A;
            color:white;
            cursor:pointer;
            margin:7px 5px 5px 5px;
        }
        button:hover{
            transform:scale(1.1);
        }
        /*form{*/
        /*    display:inline-block;*/
        /*}*/
    </style>
</head>
<body>

<jsp:useBean id="obj" class="com.example.task.hotelBean"></jsp:useBean>
<jsp:setProperty property="*" name="obj"/>
<nav>
    <a href="Home.jsp">HOME </a>
    <a href="addingrooms.jsp">ADD</a>
    <a href="deleteRoom.jsp">DELETE</a>
    <a href="updateRoom.jsp">UPDATE</a>
    <a href="../common/logout.jsp">LOGOUT</a>
</nav>
<br><br><br>
<h1 style="color:white;text-align: center;">AVAILABLE ROOMS</h1><br/>
<%
    List<hotelBean> list= AvalibleRoom.getAllAvalibleRoom();
    StringBuilder template = new StringBuilder();
    StringBuilder header = new StringBuilder();
    if(list.size()==0){
        header.append("<tr>No Rooms with the given specification. Check the available rooms</tr>");
    }
    else {
        header.append("<tr><td>").append("ROOM NUMBER").append("</td><td>").append("FLOOR").append("</td><td>").append("PRICE").append("</td><td>").append("TYPE").append("</td><td>").append("BOOK").append("</td><td>").append("DELETE").append("</td><td>").append("UPDATE").append("</td></tr>");
        header.append("<tr><td>").append("<input name=room id=room type=search>").append("</td><td>").append("<input name=floor id=floor type=search>").append("</td><td>").append("<input name=price id=price type=search>").append("</td><td>").append("<input type=search name=type id=type>").append("</td></tr>\n");

        for (hotelBean s : list){
//            template.append("<div class=styling>");
            template.append("<tr><td>").append(s.getAva_room_id()).append("</td><td>").append(s.getFloor()).append("</td><td>").append(s.getPrice()).append("</td><td>").append(s.getType()).append("</td><td>");
            template.append("<form action=../common/bookARoom.jsp method='post' >").append("<Button name='1234' value=").append(s.getAva_room_id()).append(">BOOK</Button></form>").append("</td><td>");
            template.append("<form action=deleteRoom.jsp method='post' ><Button style='background-color:#F93C30;' name='del' value=").append(s.getAva_room_id()).append(">DELETE</Button>").append("</form>");
            template.append("</td><td>").append("<form action=updateRoom.jsp action='post' >").append("<Button style='background-color:#4AE0EA;' name='update' value=").append(s.getAva_room_id()).append(">UPDATE</Button></div>").append("</form></td></tr>\n");
        }
    }

%>
<table>
    <thead>
    <%=header.toString()%>
    </thead>
   <tbody id="tbody"> <%=template.toString()%></tbody>
</table>
    <%
    if (!list.isEmpty()) {
        out.println("<script src='filter.js'></script>");
    }
    %>
</body>
</html>
