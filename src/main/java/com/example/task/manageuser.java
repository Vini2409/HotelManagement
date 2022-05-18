package com.example.task;
import java.sql.*;
import java.util.ArrayList;

public class manageuser {
    static Connection conn;
    static PreparedStatement pst;
    public static int manageuser(hotelBean u) {
        int status=0;
        try {
            conn=ConnectionProvider.getCon();
            pst=conn.prepareStatement("select * from guest where guestid=?");
            pst.setString(1, u.getClientname());
            ResultSet re=pst.executeQuery();
            if(re.next()) {
                pst = conn.prepareStatement("select* from bookingroom where roomno=?");
                pst.setInt(1, u.getRoomno());
                ResultSet rs = pst.executeQuery();
                if (rs.next()) {
                    pst = conn.prepareStatement("select * from bookingroom where roomno=? AND ((checkin <= ? AND checkout >= ?) OR (checkin<=? AND checkout>=?) OR (checkin >? AND checkout < ?))");
                    pst.setInt(1, u.getRoomno());
                    pst.setDate(2, Date.valueOf(u.getCheckin()));
                    pst.setDate(3, Date.valueOf(u.getCheckin()));
                    pst.setDate(4, Date.valueOf(u.getCheckout()));
                    pst.setDate(5, Date.valueOf(u.getCheckout()));
                    pst.setDate(6, Date.valueOf(u.getCheckin()));
                    pst.setDate(7, Date.valueOf(u.getCheckout()));
                    ResultSet rq = pst.executeQuery();
                    if (rq.next()) {
                        return -1;
                    } else {
                            pst = conn.prepareStatement("insert into bookingroom(roomno,clientname,no_of_person,checkin,checkout) values(?,?,?,?,?)");
                            pst.setInt(1, u.getRoomno());
                            pst.setString(2, u.getClientname());
                            pst.setInt(3, u.getNo_of_person());
                            pst.setDate(4, Date.valueOf(u.getCheckin()));
                            pst.setDate(5, Date.valueOf(u.getCheckout()));
                            status = pst.executeUpdate();
                    }

                } else {
                    pst = conn.prepareStatement("select * from room where ava_room_id=?");
                    pst.setInt(1, u.getRoomno());
                    ResultSet sr = pst.executeQuery();
                    if (sr.next()) {
                        pst = conn.prepareStatement("insert into bookingroom(roomno,clientname,no_of_person,checkin,checkout) values(?,?,?,?,?)");
                        pst.setInt(1, u.getRoomno());
                        pst.setString(2, u.getClientname());
                        pst.setInt(3, u.getNo_of_person());
                        pst.setDate(4, Date.valueOf(u.getCheckin()));
                        pst.setDate(5, Date.valueOf(u.getCheckout()));
                        status = pst.executeUpdate();
                    }
                }
            }
            else{
                return -2;
            }
        }catch(Exception ex){
            System.out.println(ex);
        }
        return status;
    }
    public static int cancelBooking(hotelBean u) {
        int status=0;
        try {
            conn=ConnectionProvider.getCon();
            pst=conn.prepareStatement("delete from bookingroom where clientname = ? AND roomno=?");
            pst.setString(1,u.getClientname());
            pst.setInt(2,u.getRoomno());
            status=pst.executeUpdate();
            conn.close();
        }catch(Exception ex){
            System.out.println(ex);
        }
        return status;
    }
    public static int updateProfile(hotelBean u) {
        int status=0;
        String query = "update guest set ";
        ArrayList<Object> params = new ArrayList<>();
        boolean isAlreadyAdded = false;
        if (u.getGuestname() != null) {
            query += "guestname = ?";
            params.add(u.getGuestname());
            isAlreadyAdded = true;
        }
        if (u.getEmail() != null) {
            if (isAlreadyAdded) query += ", ";
            query += "email = ?";
            params.add(u.getEmail());
            isAlreadyAdded = true;
        }
        if (u.getContactno() != 0) {
            if (isAlreadyAdded) query += ", ";
            query += "contactno = ?";
            params.add(u.getContactno());
            isAlreadyAdded = true;
        }
        if (u.getAddress() != null) {
            if (isAlreadyAdded) query += ", ";
            query += "address = ?";
            params.add(u.getAddress());
        }
        query += " where guestid = ?";
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
            pst.setString(params.size()+1, u.getGuestid());
            status=pst.executeUpdate();
        } catch (SQLException e) {
//            System.out.println(e);
            e.printStackTrace();
        }

        return status;
    }
    public static int removeuser(hotelBean u) {
        int status=0;
        try {
            conn=ConnectionProvider.getCon();
            pst=conn.prepareStatement("delete from guest where guestid = ?");
            pst.setString(1,u.getGuestid());
            status=pst.executeUpdate();
        }catch(Exception ex){
            System.out.println(ex);
        }
        return status;
    }
}