<%--
  Created by IntelliJ IDEA.
  User: vinis
  Date: 22-05-2022
  Time: 13:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Remove Member</title><style>
    body{
        background-image: url("https://media.istockphoto.com/photos/the-concept-of-erase-contacts-files-informations-picture-id1202348403?b=1&k=20&m=1202348403&s=170667a&w=0&h=rPSiBdvufXJG_m5XJV9pl4NlLQhj7j2N9t4sjBcdyOI=");
        background-repeat: no-repeat;
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
<%
    if(session.getAttribute("recpLogin")==null){
        String url=request.getRequestURL().toString();
        session.setAttribute("currentPage",url);
        response.sendRedirect("receptionistLogin.jsp");
    }
%>
<table>
    <form method="post" action="removeMemberSuccess.jsp" id="f1">
        <%
            if(request.getParameter("1234")!=null){
        %>
        <tr><td>GUEST UNIQUE ID: </td><td><input style="font-size:25px;" type="text" name="memberid" readonly="readonly" value=<%=request.getParameter("1234")%> ></td></tr><br><br>
        <%
        }else{
        %>
        <tr><td>GUEST UNIQUE ID: </td><td><input style="font-size:20px;" type="text" name="memberid"/></td></tr><br><br>
        <%
            }
        %>
        <tr><td><input style="font-size:25px;margin-left:150px;margin-top:50px;padding:5px;background-color: lightcyan;" type="submit" value="SUBMIT"/></td></tr>
    </form>
</table>
</body>
</html>
