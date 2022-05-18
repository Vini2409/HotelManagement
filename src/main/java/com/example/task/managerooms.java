package com.example.task;
import java.sql.*;
import java.util.ArrayList;

public class managerooms {
    static Connection conn;
    static PreparedStatement pst;
    public static int insertroom(hotelBean u) {
        int status=0;
        try {
            conn=ConnectionProvider.getCon();
            pst=conn.prepareStatement("insert into room values(?,?,?,?)");
            pst.setInt(1,u.getAva_room_id());
            pst.setInt(2, u.getFloor());
            pst.setInt(3, u.getPrice());
            pst.setString(4,u.getType());
            status=pst.executeUpdate();
        }catch(Exception ex){
            System.out.println(ex);
        }
        return status;
    }
    public static int deleteroom(hotelBean u) {
        int status=0;
        try {
            conn=ConnectionProvider.getCon();
            pst=conn.prepareStatement("delete from room where ava_room_id = ?");
            pst.setInt(1,u.getAva_room_id());
            status=pst.executeUpdate();
        }catch(Exception ex){
            System.out.println(ex);
        }
        return status;
    }

    public static int updateRoom(hotelBean u) {
        int status=0;
        String query = "update room set ";
        ArrayList<Object> params = new ArrayList<>();
        boolean isAlreadyAdded = false;
        if (u.getFloor() != 0) {
            query += "floor = ?";
            params.add(u.getFloor());
            isAlreadyAdded = true;
        }
        if (u.getPrice() != 0) {
            if (isAlreadyAdded) query += ", ";
            query += "price = ?";
            params.add(u.getPrice());
            isAlreadyAdded = true;
        }
        if (u.getType() != null) {
            if (isAlreadyAdded) query += ", ";
            query += "type = ?";
            params.add(u.getType());
        }
        query += " where ava_room_id = ?";
        if (params.size() < 1) {
            return -1;
        }
        System.out.println(query);
        try {
            conn=ConnectionProvider.getCon();
            pst=conn.prepareStatement(query);
            for (int i = 0; i < params.size(); i++) {
                Object param = params.get(i);
                if (param instanceof String) {
                    pst.setString(i+1, (String) param);
                } else {
                    pst.setInt(i+1, (Integer) param);
                }
            }
            pst.setInt(params.size()+1, u.getAva_room_id());
            status=pst.executeUpdate();
            conn.close();
        } catch (SQLException e) {
//            System.out.println(e);
            e.printStackTrace();
        }

        return status;
    }
}
