<%--
  Created by IntelliJ IDEA.
  User: vinis
  Date: 25-05-2022
  Time: 14:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Change To User Role</title><style>
    body{
        background-image: url("https://images.unsplash.com/photo-1499244571948-7ccddb3583f1?crop=entropy&cs=tinysrgb&fm=jpg&ixlib=rb-1.2.1&q=60&raw_url=true&ixid=MnwxMjA3fDB8MHxzZWFyY2h8M3x8Y2hhbmdlJTIwcm9sZXxlbnwwfHwwfHw%3D&auto=format&fit=crop&w=500");
        background-repeat: no-repeat;
        background-position-y: center;
        background-size: 1000px;
        color:black;
    }
    table{
        font-size:20px;
        border:3px solid black;
        padding:3px 0px 3px 0px;
        margin:270px 0px 0px 990px;
        box-shadow: 7px 7px 5px black;
    }
</style>
</head>
<body>
<h1 style="text-align:center;">CHANGE THE ROLE</h1>
<table>
    <form method="post" action="changeToUserRoleSuccess.jsp" id="f1">
        <%
            if(request.getParameter("changeRole")!=null){
        %>
        <tr><td>GUEST UNIQUE ID: </td><td><input style="font-size:25px;" type="text" name="memberid" readonly="readonly" value=<%=request.getParameter("changeRole")%> ></td></tr><br><br>
        <%
        }else{
        %>
        <tr><td>GUEST UNIQUE ID: </td><td><input style="font-size:20px;" type="text" name="memberid"/></td></tr><br><br>
        <%
            }
        %>
        <tr><td>&nbsp;</td><td><input style="font-size:25px;margin-top:35px;padding:5px;background-color: green;border-radius:8px;cursor:pointer;" type="submit" value="CHANGE ROLE"/></td></tr>
    </form>
</table>
</body>
</html>
