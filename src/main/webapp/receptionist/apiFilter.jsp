<%@ page import="com.example.task.sqlFunction"%><%@ page import="com.example.task.hotelBean"%><%@ page import="java.util.List"%><%@ page import="java.util.Objects"%><%--
  Created by IntelliJ IDEA.
  User: vinis
  Date: 28-05-2022
  Time: 19:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="application/json;charset=UTF-8" language="java" %>
<%
String room =request.getParameter("room");
String floor=request.getParameter("floor");
String price=request.getParameter("price");
String type=request.getParameter("type");
System.out.println(room + ","+floor + ","+price+","+type);
List<hotelBean> list = sqlFunction.filter(Objects.equals(room, "null") ? null : Integer.valueOf(room), Objects.equals(floor, "null") ? null : Integer.valueOf(floor), Objects.equals(price, "null") ? null : Integer.valueOf(price), Objects.equals(type, "null") ? null : type);
out.print("[");
for (int i =0; i <list.size(); ++i) {
    hotelBean h = list.get(i);
     out.print(h.getRoomString());
     if (i != list.size()-1) out.print(",");
}
out.println("]");
%>
