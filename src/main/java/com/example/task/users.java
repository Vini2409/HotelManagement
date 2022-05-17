package com.example.task;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class users {
    static Connection conn;
    static PreparedStatement pst;
    public static List<hotelBean> getAllBookedRecords(){
        List<hotelBean> list= new ArrayList<>();
        try {
            conn=ConnectionProvider.getCon();
            pst=conn.prepareStatement("SELECT bookingroom.roomno,bookingroom.clientname, guest.email, guest.contactno,bookingroom.no_of_person, bookingroom.checkin, bookingroom.checkout\n" +
                    "FROM bookingroom INNER JOIN guest ON bookingroom.clientname=guest.guestid");
            ResultSet rs=pst.executeQuery();
            while(rs.next()) {
                hotelBean u = new hotelBean();
                u.setRoomno(rs.getInt("roomno"));
                u.setClientname(rs.getString("clientname"));
                u.setEmail(rs.getString("email"));
                u.setContactno(rs.getInt("contactno"));
                u.setNo_of_person(rs.getInt("no_of_person"));
                u.setCheckin(Utils.fromDate(rs.getDate("checkin")));
                u.setCheckout(Utils.fromDate(rs.getDate("checkout")));
                list.add(u);
            }
            conn.close();
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return list;
    }
    public static List<hotelBean> getAllUser(){
        List<hotelBean> list= new ArrayList<>();
        try {
            conn=ConnectionProvider.getCon();
            pst=conn.prepareStatement("SELECT * from guest");
            ResultSet rs=pst.executeQuery();
            while(rs.next()) {
                hotelBean u = new hotelBean();
                u.setGuestname(rs.getString("guestname"));
                u.setGuestid(rs.getString("guestid"));
                u.setEmail(rs.getString("email"));
                u.setContactno(rs.getInt("contactno"));
                u.setAddress(rs.getString("address"));
                list.add(u);
            }
            conn.close();
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return list;
    }

}
