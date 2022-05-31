package com.example.task;
import java.sql.*;
import java.util.ArrayList;

public class manageuser {
    static Connection conn;
    static PreparedStatement pst;
    public static int manageuser(hotelBean u) {
        int status=sqlFunction.manageuser("bookingroom",u.getRoomno(),u.getGuestid(),u.getNo_of_person(),Date.valueOf(u.getCheckin()),Date.valueOf(u.getCheckout()));
        return status;
    }
    public static int cancelBooking(hotelBean u) {
        int status=sqlFunction.cancelBooking(u.getGuestid(),u.getRoomno());
        return status;
    }
    public static int updateProfile(hotelBean u) {
        int status=sqlFunction.updateProfile("guest",u.getGuestname(),u.getGuestid(),u.getEmail(),u.getContactno(),u.getAddress());
        return status;

    }
    public static int removeuser(hotelBean u) {
        int status=0;
        status = sqlFunction.user("guest",u.getGuestid());
        return status;
    }
    public static int removeMember(hotelBean u) {
        int status=0;
        status=sqlFunction.member("member",u.getGuestid());
        return status;
    }
    public static int changeUserToMember(hotelBean u) {
        int status=0;
        status = sqlFunction.changeUserToMember("guest",u.getGuestid());
//        sqlFunction.user("guest",u.getGuestid());
        System.out.println(status);
        return status;
    }
    public static int changeMemberToUser(hotelBean u) {
        int status=0;
        status=sqlFunction.changeMemberToUser("guest",u.getGuestid());
//        sqlFunction.member("member",u.getMemberid());
        System.out.println(status);
        return status;
    }
    public static int checkIfUser(hotelBean u,String id) {
        int status = sqlFunction.checkIfUser("guest",id);
        return status;
    }
}