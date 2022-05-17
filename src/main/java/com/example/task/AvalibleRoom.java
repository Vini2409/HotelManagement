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
        List<hotelBean> list= new ArrayList<>();
        try {
            conn=ConnectionProvider.getCon();
            pst=conn.prepareStatement("select * from room order by ava_room_id");
            ResultSet rs=pst.executeQuery();
            while(rs.next()) {
                hotelBean u = new hotelBean();
                u.setAva_room_id(rs.getInt("ava_room_id"));
                u.setFloor(rs.getInt("floor"));
                u.setPrice(rs.getInt("price"));
                u.setType(rs.getString("type"));
                list.add(u);
            }
            conn.close();
        }catch(Exception ex){
            System.out.println(ex);
        }
        return list;
    }
}
