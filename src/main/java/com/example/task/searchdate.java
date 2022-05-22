package com.example.task;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class searchdate {
    static Connection conn;
    static PreparedStatement pst;
    public static List<hotelBean> roomsearchByDate(hotelBean u) {
//        ArrayList<Object> params = new ArrayList<>();
        List<hotelBean> list= new ArrayList<>();
        try{
            conn=ConnectionProvider.getCon();
            pst = conn.prepareStatement("update room set booked=true from bookingroom where roomno=ava_room_id AND ((checkin <= ? AND checkout >= ?) OR (checkin <= ? AND checkout >= ?) OR (checkin >? AND checkout < ?)) ");
            pst.setDate(1,Date.valueOf(u.getCheckin()));
            pst.setDate(2,Date.valueOf(u.getCheckin()));
            pst.setDate(3,Date.valueOf(u.getCheckout()));
            pst.setDate(4,Date.valueOf(u.getCheckout()));
            pst.setDate(5,Date.valueOf(u.getCheckin()));
            pst.setDate(6,Date.valueOf(u.getCheckout()));
            pst.executeUpdate();
            pst=conn.prepareStatement("select ava_room_id,floor,price,type from room where booked = false order by ava_room_id");
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
//            System.out.println(e);
                e.printStackTrace();
            }
        return list;
    }
    public static List<hotelBean> roomsearchByDateUser(hotelBean u) {
        long ctm = System.currentTimeMillis();
        Date d = new Date(ctm);
        LocalDate localDate = d.toLocalDate();
        Date sqldate = Date.valueOf(localDate);
        System.out.println(sqldate);
//        ArrayList<Object> params = new ArrayList<>();
        List<hotelBean> list= new ArrayList<>();
        try{
            conn=ConnectionProvider.getCon();
            pst = conn.prepareStatement("update room set booked=true from bookingroom where roomno=ava_room_id AND ((checkin <= ? AND checkout >= ?) OR (checkin <= ? AND checkout >= ?) OR (checkin >? AND checkout < ?)) ");
            pst.setDate(1,sqldate);
            pst.setDate(2,sqldate);
            pst.setDate(3,Date.valueOf(u.getCheckout()));
            pst.setDate(4,Date.valueOf(u.getCheckout()));
            pst.setDate(5,sqldate);
            pst.setDate(6,Date.valueOf(u.getCheckout()));
            pst.executeUpdate();
            pst=conn.prepareStatement("select ava_room_id,floor,price,type from room where booked = false order by ava_room_id");
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
//            System.out.println(e);
            e.printStackTrace();
        }
        return list;
    }
}
