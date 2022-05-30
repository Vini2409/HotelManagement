package com.example.task;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class users {
    static Connection conn;
    static PreparedStatement pst;

    public static List<hotelBean> getAllBookedRecords() {
        List<hotelBean> list = new ArrayList<>();
        System.out.println();
        try {
            conn = ConnectionProvider.getCon();
            pst = conn.prepareStatement("Select * from bookingroom");
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                hotelBean u = new hotelBean();
                u.setRoomno(rs.getInt("roomno"));
                u.setClientname(rs.getString("clientname"));
                u.setNo_of_person(rs.getInt("no_of_person"));
                u.setCheckin(Utils.fromDate(rs.getDate("checkin")));
                u.setCheckout(Utils.fromDate(rs.getDate("checkout")));
                list.add(u);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return list;
    }

    public static List<hotelBean> getAllUser() {
        List<hotelBean> list = new ArrayList<>();
        try {
            conn = ConnectionProvider.getCon();
            pst = conn.prepareStatement("SELECT * from guest");
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                hotelBean u = new hotelBean();
                u.setGuestname(rs.getString("guestname"));
                u.setGuestid(rs.getString("guestid"));
                u.setEmail(rs.getString("email"));
                u.setContactno(rs.getInt("contactno"));
                u.setAddress(rs.getString("address"));
                list.add(u);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return list;
    }

    public static List<hotelBean> getBookingDetails(hotelBean h) {
        List<hotelBean> list = new ArrayList<>();
        System.out.println();
        try {
            conn = ConnectionProvider.getCon();
            pst = conn.prepareStatement("SELECT roomno,clientname,checkin,checkout FROM bookingroom where clientname = ?");
            pst.setString(1,h.getGuestid());
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                hotelBean u = new hotelBean();
                u.setRoomno(rs.getInt("roomno"));
                u.setClientname(rs.getString("clientname"));
                u.setCheckin(Utils.fromDate(rs.getDate("checkin")));
                u.setCheckout(Utils.fromDate(rs.getDate("checkout")));
                list.add(u);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return list;
    }
    public static List<hotelBean> getAllUserMember() {
        List<hotelBean> list = new ArrayList<>();
        try {
            conn = ConnectionProvider.getCon();
            pst = conn.prepareStatement("SELECT * from member");
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                hotelBean u = new hotelBean();
                u.setGuestname(rs.getString("membername"));
                u.setGuestid(rs.getString("memberid"));
                u.setEmail(rs.getString("memberemail"));
                u.setContactno(rs.getInt("membercontactno"));
                u.setAddress(rs.getString("memberaddress"));
                list.add(u);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return list;
    }
}