package com.example.task;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class search {
    static Connection conn;
    static PreparedStatement pst;
    public static List<hotelBean> roomsearch(hotelBean u) {
        int status=0;
        String query = "select * from room where ";
        ArrayList<Object> params = new ArrayList<>();
        List<hotelBean> list= new ArrayList<>();
        boolean isAlreadyAdded = false;
        if (u.getFloor() != 0) {
            query += "floor = ?";
            params.add(u.getFloor());
            isAlreadyAdded = true;
        }
        if (u.getPrice() != 0) {
            if (isAlreadyAdded) query += " and ";
            query += "price = ?";
            params.add(u.getPrice());
            isAlreadyAdded = true;
        }
        if (u.getType() != null) {
            if (isAlreadyAdded) query += " and ";
            query += "type = ?";
            params.add(u.getType());
        }
//        if (params.size() < 1) {
//            return -1;
//        }
        System.out.println(query);
        System.out.println(params.size());
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
            ResultSet rs =pst.executeQuery();
            while(rs.next()) {
                hotelBean a=new hotelBean();
                a.setAva_room_id(rs.getInt("ava_room_id"));
                a.setFloor(rs.getInt("floor"));
                a.setPrice(rs.getInt("price"));
                a.setType(rs.getString("type"));
                list.add(a);
            }
            conn.close();
        } catch (SQLException e) {
//            System.out.println(e);
            e.printStackTrace();
        }
        return list;
    }
}
