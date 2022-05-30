package com.example.task;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Search {
    static Connection conn;
    static PreparedStatement pst;
    public static List<hotelBean> roomsearch(hotelBean u) {
        System.out.println("Hello");
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
            query += "price <= ?";
            params.add(u.getPrice());
            isAlreadyAdded = true;
        }
        if (u.getType() != null) {
            if (isAlreadyAdded) query += " and ";
            query += "type = ? ";
            params.add(u.getType());
            isAlreadyAdded = true;
        }
        if(u.getCheckout()!=null && u.getCheckin()!=null){
            sqlFunction.search(Date.valueOf(u.getCheckin()),Date.valueOf(u.getCheckout()));
            System.out.println(u.getCheckin()+"+");
            if(isAlreadyAdded) query += " and ";
            query+="booked = false";
        }

        query+=" order by ava_room_id";
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
            pst=conn.prepareStatement("update room set booked=false");
            pst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
