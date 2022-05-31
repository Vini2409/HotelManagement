<%@ page import="java.sql.Date" %>
<%@ page import="java.time.LocalDate" %>
<%@ page import="com.example.task.manageuser" %><%--
  Created by IntelliJ IDEA.
  User: vinis
  Date: 12-05-2022
  Time: 12:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Search</title>
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
            margin-top:50px;
            margin-left:950px;
            box-shadow: 10px 10px 5px black;
        }
        table:hover{
            transform:scale(1.1);
        }

    </style>
</head>
<body>
<%
    if(session.getAttribute("recpLogin")==null && session.getAttribute("validid")==null){
        String url=request.getRequestURL().toString();
        session.setAttribute("currentPage",url);
        response.sendRedirect("../index.jsp");
    }
%>
<h1 style="margin-left:1000px;">SEARCH ROOMS</h1>
<jsp:useBean id="obj" class="com.example.task.hotelBean"></jsp:useBean>
<jsp:setProperty property="*" name="obj"/>
<%
    long ctm = System.currentTimeMillis();
    Date d = new Date(ctm);
    LocalDate localDate = d.toLocalDate();
    Date sqldate = Date.valueOf(localDate);
    System.out.println(sqldate);
%>
<table>
<form name="f1" method="post" action="searchsuccess.jsp" id="f1">
    <tr><td>Floor: </td><td><input style="font-size:25px;" type="number" name="floor"/></td></tr><br><br>
    <tr><td>Price: </td><td><input style="font-size:25px;" type="number" name="price"/></td></tr><br><br>
    <tr><td>Type: </td><td>
        <select style="font-size:27px;" name="type">
            <option value=""></option>
            <option value="standard">Standard</option>
            <option value="dulex">Dulex</option>
            <option value="family suite">Family Suite</option>
        </select>
    </td></tr><br><br>
    <%
        int status = manageuser.checkIfUser(obj,(String)request.getSession().getAttribute("validid"));
        if(status==0){
            System.out.println(sqldate);
    %>
    <tr><td>Check In: </td><td><input style="font-size:25px;" type="date" name="checkin" value="null"/></td></tr><br><br>
    <%
        }else{
    %>
    <tr><td>Check In: </td><td><input style="font-size:25px;" type="date" name="checkin" readonly="readonly" value=<%=sqldate%>></td></tr><br><br>
    <%
        }
    %>
    <tr><td>Check Out: </td><td><input style="font-size:25px;" type="date" name="checkout" value="null"></td></tr><br><br>
    <tr><td>&nbsp;</td><td><input style="text-align: center;size:20px;padding:20px;border-radius: 8px;background-color: green;color:white;cursor:pointer;margin:10px 0px 0px 60px;" type="submit" value="SEARCH"/></td></tr>
</form>
</table>
</body>
</html>
