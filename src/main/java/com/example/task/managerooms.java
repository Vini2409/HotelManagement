package com.example.task;
import java.sql.*;
import java.util.ArrayList;

public class managerooms {
    static Connection conn;
    static PreparedStatement pst;
    public static int insertroom(hotelBean u) {
        int status=0;
        status = sqlFunction.insertRoom("room",u.getAva_room_id(),u.getFloor(),u.getPrice(),u.getType());
        return status;
    }
    public static int deleteroom(hotelBean u) {
        int status=0;
        status=sqlFunction.deleteQuery("room",u.getAva_room_id());
        return status;
    }

    public static int updateRoom(hotelBean u) {
        int status = sqlFunction.updateRoom("room",u.getAva_room_id(),u.getFloor(),u.getPrice(),u.getType());
        return status;
    }
}
