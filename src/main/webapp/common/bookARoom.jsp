<%@ page import="java.sql.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.time.LocalDate" %>
<%@ page import="com.example.task.manageuser" %><%--
  Created by IntelliJ IDEA.
  User: vinis
  Date: 21-05-2022
  Time: 11:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Book Today</title>
    <style>
        body{
            background-image: url("https://images.unsplash.com/photo-1586611292717-f828b167408c?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxzZWFyY2h8Mjh8fGhvdGVsfGVufDB8fDB8fA%3D%3D&auto=format&fit=crop&w=500&q=60");
            background-repeat: no-repeat;
            background-size: cover;
            color:black;
        }
        table{
            font-size:27px;
            border:3px solid black;
            padding:10px;
            margin-left:30px;
            box-shadow: 10px 10px 5px black;
        }
        table:hover{
            transform:scale(1.1);
        }
    </style>
</head>
<body>
<jsp:useBean id="obj" class="com.example.task.hotelBean"></jsp:useBean>
<jsp:setProperty property="*" name="obj"/>
<%
    long ctm = System.currentTimeMillis();
    Date d = new Date(ctm);
    LocalDate localDate = d.toLocalDate();
    Date sqldate = Date.valueOf(localDate);
%>
<%
    String n= (String) session.getAttribute("validid");
    System.out.println(n);
%>
<table>
    <form name="f1" method="post" action="userdb.jsp" id="f1" >
        <%
            if(request.getParameter("1234")!=null){
        %>
        <tr><td>Room Number: </td><td><input style="font-size:25px;" type="number" name="roomno" readonly="readonly" value=<%=request.getParameter("1234")%> ></td></tr><br><br>
        <%
            }else{
        %>
        <tr><td>Room Number: </td><td><input style="font-size:25px;" type="number" name="roomno" ></td></tr><br><br>
        <%
            }if(n==null){
        %>
        <tr><td>User Name: </td><td><input style="font-size:25px;" type="text" name="clientname"></td></tr><br><br>
        <%
        }else{
        %>
        <tr><td>User Name: </td><td><input style="font-size:25px;" type="text" name="clientname" readonly="readonly" value=${sessionScope.validid} ></td></tr><br><br>
        <%
            }
        %>
        <tr><td>No Of Person: </td><td><input style="font-size:25px;" type="number" name="no_of_person"/></td></tr><br><br>
        <%
            int status= manageuser.checkIfUser(obj,(String)request.getSession().getAttribute("validid"));
            if(status>0){
                System.out.println(sqldate);
        %>
        <tr><td>Check IN: </td><td><input style="font-size:25px;" type="date" name="checkin" readonly="readonly" value=<%=sqldate%> ></td></tr><br><br>
        <%
            }else{
        %>
        <tr><td>Check IN: </td><td><input style="font-size:25px;" type="date" name="checkin" ></td></tr><br><br>
        <%
            }
        %>
        <tr><td>Check Out: </td><td><input style="font-size:25px;" type="date" name="checkout" placeholder="dd-mm-yyy"/></td></tr><br><br>
        <tr><td><input style="font-size:25px;margin-left:150px;margin-top:50px;padding:5px;" type="submit" value="BOOK"/></td></tr>
    </form>
</table>
</body>
</html>
