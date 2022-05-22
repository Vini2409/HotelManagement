<%--
  Created by IntelliJ IDEA.
  User: vinis
  Date: 22-05-2022
  Time: 13:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>EDIT</title><style>
    body{
        background-image: url("https://media.istockphoto.com/photos/update-picture-id1299640998?b=1&k=20&m=1299640998&s=170667a&w=0&h=l5NaANFrdGFcsNp7DXxUO8Iejfuq7XzIRvwZFG9vSQ8=");
        background-repeat: no-repeat;
        color:black;
    }
    table{
        font-size:27px;
        border:3px solid #F9084A;
        padding:10px;
        margin-top:100px;
        margin-left:650px;
        box-shadow: 10px 10px 5px #F9084A;
    }
    table:hover{
        transform:scale(1.1);
    }
</style>
</head>
<body>
<h1 style="text-shadow:2px 2px #F9084A;text-align: center;font-size: 50px;">UPDATE MEMBER DETAILS</h1>
<%
    String n= (String) session.getAttribute("validid");
    System.out.println(n);
%>
<table>
    <form method="post" action="memberProfileUpdationSuccess.jsp">
        <%
            if(request.getParameter("updateMember")!=null){
        %>
        <tr>
            <td>MEMBER ID: </td><td><input style="font-size:25px;" type="text" name="memberid" readonly="readonly" value=<%=request.getParameter("updateMember")%> ></td>
        </tr>
        <%
        }else if(n!=null){
        %>
        <tr>
            <td>MEMBER ID: </td><td><input style="font-size:25px;" type="text" name="memberid" readonly="readonly" value=${sessionScope.validid}></td>
        </tr>
        <%
            }else{
        %>
        <tr>
            <td>MEMBER ID: </td><td><input style="font-size:25px;" type="text" name="memberid" /></td>
        </tr>
        <%
            }
        %>
        <tr><td>&nbsp;</td></tr>
        <tr><td></td><td style="font-weight: bold;font-size:30px;">Enter the field you want to update/edit</td></tr>
        <tr><td>&nbsp;</td></tr>
        <tr>
            <td>Name: </td>
            <td>
                <input style="font-size:25px;"  type="text" name="membername" placeholder="Name">
            </td>
        </tr>
        <tr>
            <td>Email ID: </td>
            <td>
                <input style="font-size:25px;" type="text" name="memberemail" placeholder="email">
            </td>
        </tr>
        <tr>
            <td>Contact Number: </td>
            <td>
                <input style="font-size:25px;" type="number" name="membercontactno" placeholder="9352683513">
            </td>
        </tr>
        <tr>
            <td>Address: </td>
            <td>
                <input style="font-size:25px;" type="text" name="memberaddress" placeholder="Address">
            </td>
        </tr>
        <tr>
            <td><input style="font-size:25px;margin-left:150px;margin-top:50px;padding:5px;"  type="submit" value="EDIT"/></td>
        </tr>
    </form>
</table>
</body>
</html>
