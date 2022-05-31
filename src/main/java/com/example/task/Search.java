package com.example.task;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Search {
    static Connection conn;
    static PreparedStatement pst;
    public static List<hotelBean> roomsearch(hotelBean u) {
        List<hotelBean> list;
        if(u.getCheckout()!=null) {
            list= sqlFunction.roomsearch(u.getFloor(), u.getPrice(), u.getType(), Date.valueOf(u.getCheckin()), Date.valueOf(u.getCheckout()));
        }
        else{
            list= sqlFunction.roomsearch(u.getFloor(), u.getPrice(), u.getType(), null,null);
        }
        return list;
    }
}
