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
            margin:60px;
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
            margin:15px 0px 3px 20px;
        }
        button:hover{
            transform:scale(1.1);
        }
        form{
            display:inline-block;
        }
    </style>
</head>
<body>
<nav>
    <a href="Home.jsp">HOME </a>
    <a href="displayBookedUsers.jsp">BOOKED USER</a>
    <a href="../user/guestSignup.jsp">ADD A USER</a>
    <a href="../common/logout.jsp">LOGOUT</a>
</nav>
<br><br><br>
<h1 style="color:white;text-align: center;">USERS</h1><br/>
<%

    List<hotelBean> list= users.getAllUser();
    StringBuilder template = new StringBuilder();
    if(list.size()==0){
        template.append("<tr>No users have booked</tr>");
    }
    else {
        for (hotelBean s : list) {
            template.append("<form action=removeUser.jsp method='post' >");
            template.append("<div class=styling>");
            template.append("Name: ").append(s.getGuestname()).append("</br>Unique ID: ").append(s.getGuestid()).append("</br>Email ID: ").append(s.getEmail()).append("</br>Contact Number: ").append(s.getContactno()).append("</br>Address: ").append(s.getAddress()).append("</br><Button name='1234' value=").append(s.getGuestid()).append(">REMOVE USER</Button>").append("</form>");
            template.append("<form action=../user/edituserprofile.jsp method='post' ><Button style='background-color:#4AE0EA;' name='update' value=").append(s.getGuestid()).append(">UPDATE USER</Button>").append("</form>");
            template.append("<form action=changeUserToMember.jsp method='post' ><Button style='background-color:red;' name='changeRole' value=").append(s.getGuestid()).append(">CHANGE ROLE</Button>").append("</form></div>");
        }
    }
    List<hotelBean> listMember= users.getAllUserMember();
    StringBuilder templateMember = new StringBuilder();
    if(listMember.size()==0){
        templateMember.append("<tr>No users have booked</tr>");
    }
    else {
        for (hotelBean s : listMember) {
            templateMember.append("<form action=removeMember.jsp method='post' >");
            templateMember.append("<div class=styling>");
            templateMember.append("Name: ").append(s.getGuestname()).append("</br>Unique ID: ").append(s.getGuestid()).append("</br>Email ID: ").append(s.getEmail()).append("</br>Contact Number: ").append(s.getContactno()).append("</br>Address: ").append(s.getAddress()).append("</br><Button name='1234' value=").append(s.getGuestid()).append(">REMOVE USER</Button></form>");
            templateMember.append("<form action=../user/edituserprofile.jsp method='post' ><Button style='background-color:#4AE0EA;' name='update' value=").append(s.getGuestid()).append(">UPDATE USER</Button>").append("</form>");
            templateMember.append("<form action=changeMemberToUser.jsp method='post' ><Button style='background-color:red;' name='changeRole' value=").append(s.getGuestid()).append(">CHANGE ROLE</Button>").append("</form></div>");
        }
    }
%>
<table>
    <%=template.toString()%>
    <br><br>
    <h1 style="text-align:center;">MEMBERS</h1>
    <%=templateMember.toString()%>
</table>
</body>
</html>
