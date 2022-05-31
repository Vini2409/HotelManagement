<%@ page import="java.io.File" %>
<%@ page import="java.io.RandomAccessFile" %>
<%@ page import="java.io.IOException" %><%--
  Created by IntelliJ IDEA.
  User: vinis
  Date: 31-05-2022
  Time: 09:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>History</title>
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
        tr:hover{
            transform:scale(1.1);
        }
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
<h1 style="text-align:center;">HISTORY</h1>
<%
    File file = new File("C:\\\\Users\\\\vinis\\\\Downloads\\\\data-.csv");
    String name,pwd,recordString,usertype;
    StringBuilder template=new StringBuilder();
    try {
        RandomAccessFile raf = new RandomAccessFile(file, "rw");
        while (raf.getFilePointer() < raf.length())
        {
            recordString = raf.readLine();
            String[] lineSplit = recordString.split(",");
            template.append("<tr><td>").append(lineSplit[0]).append("</td><td>").append(lineSplit[1]).append("</td><td>").append(lineSplit[2]).append("</td><td>").append(lineSplit[3]).append("</td><td>").append(lineSplit[4]).append("</td></tr>\n");
        }
    }
    catch (IOException ex) {
        System.out.println(ex);
    }
%>
</body>
<table>
    <%=template.toString()%>
</table>
</html>
