package com.example.task;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class AvalibleRoom {
    static Connection conn;
    static PreparedStatement pst;
    public static List<hotelBean> getAllAvalibleRoom(){
        List<hotelBean> list= sqlFunction.getAllAvalibleRoom("room");
        return list;

    }
}
