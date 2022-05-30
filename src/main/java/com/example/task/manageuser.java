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
            System.out.println(Date.valueOf(u.getCheckin()));
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
                            status = sqlFunction.bookinRoom(u.getRoomno(),u.getClientname(),u.getNo_of_person(),Date.valueOf(u.getCheckin()),Date.valueOf(u.getCheckout()));
                    }

                } else {
                    System.out.println(u.getRoomno());
                    pst = conn.prepareStatement("select * from room where ava_room_id=?");
                    pst.setInt(1, u.getRoomno());
                    ResultSet sr = pst.executeQuery();
                    if (sr.next()) {
                        status = sqlFunction.bookinRoom(u.getRoomno(),u.getClientname(),u.getNo_of_person(),Date.valueOf(u.getCheckin()),Date.valueOf(u.getCheckout()));
                    }
                }
                excel.excel(u.getRoomno(),u.getClientname(),u.getNo_of_person(),Date.valueOf(u.getCheckin()),Date.valueOf(u.getCheckout()));
//                excel.selectall();
        }catch(Exception e){
            System.out.println(e);
        }
        return status;
    }
    public static int cancelBooking(hotelBean u) {
        int status=sqlFunction.cancelBooking(u.getClientname(),u.getRoomno());
        return status;
    }
    public static int updateProfile(hotelBean u) {
        int status=0;
        try {
            conn = ConnectionProvider.getCon();
            ArrayList<Object> params = new ArrayList<>();
            String query="";
            pst = conn.prepareStatement("select guestid from guest where guestid = ?");
            pst.setString(1, u.getGuestid());
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                query = "update guest set ";
//                ArrayList<Object> params = new ArrayList<>();
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
//
            }else {
                query = "update member set ";
//                ArrayList<Object> params = new ArrayList<>();
                boolean isAlreadyAdded = false;
                if (u.getGuestname() != null) {
                    query += "membername = ?";
                    params.add(u.getGuestname());
                    isAlreadyAdded = true;
                }
                if (u.getEmail() != null) {
                    if (isAlreadyAdded) query += ", ";
                    query += "memberemail = ?";
                    params.add(u.getEmail());
                    isAlreadyAdded = true;
                }
                if (u.getContactno() != 0) {
                    if (isAlreadyAdded) query += ", ";
                    query += "membercontactno = ?";
                    params.add(u.getContactno());
                    isAlreadyAdded = true;
                }
                if (u.getAddress() != null) {
                    if (isAlreadyAdded) query += ", ";
                    query += "memberaddress = ?";
                    params.add(u.getAddress());
                }
                query += " where memberid = ?";
                if (params.size() < 1) {
                    return -1;
                }
                System.out.println(query);
            }
                try{
                    conn = ConnectionProvider.getCon();
                    pst = conn.prepareStatement(query);
                    for (int i = 0; i < params.size(); i++) {
                        Object param = params.get(i);
                        if (param instanceof String) {
                            pst.setString(i + 1, (String) param);
                        } else {
                            pst.setInt(i + 1, (Integer) param);
                        }
                    }
                    pst.setString(params.size() + 1, u.getGuestid());
                    status = pst.executeUpdate();
                } catch (SQLException e) {
//           System.out.println(e);
                    e.printStackTrace();
                }
        }catch(SQLException ec){
            ec.printStackTrace();
        }
        return status;
    }
    public static int removeuser(hotelBean u) {
        int status=0;
        status = sqlFunction.user("guest",u.getGuestid());
        return status;
    }
    public static int removeMember(hotelBean u) {
        int status=0;
        status=sqlFunction.member("member",u.getMemberid());
        return status;
    }
    public static int changeUserToMember(hotelBean u) {
        int status=0;
        sqlFunction.changeUserToMember(u.getGuestid());
        status=sqlFunction.user("guest",u.getGuestid());
        System.out.println(status);
        return status;
    }
    public static int changeMemberToUser(hotelBean u) {
        int status=0;
        sqlFunction.changeMemberToUser(u.getMemberid());
        status=sqlFunction.member("member",u.getMemberid());
        System.out.println(status);
        return status;
    }
    public static int checkIfUser(hotelBean u,String id) {
        int status = sqlFunction.checkIfUser("guest",id);
        return status;
    }
}