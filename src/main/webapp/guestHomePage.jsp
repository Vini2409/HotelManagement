<%--
  Created by IntelliJ IDEA.
  User: vinis
  Date: 16-05-2022
  Time: 18:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Home</title>
    <style>
        body{
            background-image:url("https://media.istockphoto.com/photos/young-woman-walking-with-wheeled-luggage-in-hotel-corridor-picture-id1352189104?b=1&k=20&m=1352189104&s=170667a&w=0&h=jEwQTFbhmDyseJIWJrkwQa7lQc-RCSA_JogsZwPZ0Ic=");
            background-repeat: no-repeat;
            background-size: cover;
            color:black;
        }
        a{
            font-size: 40px;
            text-decoration: none;
            color:black;
            background-color: white;
            margin-left:30px;
            border: 1px solid #F9084A;
            box-shadow: 5px 5px 3px #F9084A;
        }
    </style>
</head>
<body>
<h1 style="font-size: 50px;text-align: center;text-shadow: 2px 2px #F9084A;">HOTEL MANAGEMENT</h1><br><br>
<h3><a href="booking.jsp">BOOK A ROOM</a></h3>
<h3><a href="search.jsp">SEARCH A ROOM BASED ON TYPES</a></h3>
<h3><a href="searchByDate.jsp">SEARCH ROOM BASED ON DATE</a></h3>
<h3><a href="displayAvalibleRooms.jsp">DISPLAY AVAILABLE ROOMS</a></h3>
<h3><a href="edituserprofile.jsp">EDIT YOUR PROFILE</a></h3>
<h3><a href="cancelBooking.jsp">Cancel Booking</a></h3>
</body>
</html>
