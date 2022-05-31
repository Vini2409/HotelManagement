package com.example.task;

import java.sql.Connection;
import java.sql.PreparedStatement;


public class authendication {
    static Connection conn;
    static PreparedStatement pst;
    public static int login(hotelBean u) {
        int status=0;
        status = sqlFunction.loginRecep("hotel",u.getUsername(),u.getUserpass());
        return status;
    }
    public static int signup(hotelBean u){
        int status=0;
        status = sqlFunction.insertQuery("guest",u.getGuestname(),u.getGuestid(),u.getEmail(),u.getContactno(),u.getAddress(),u.getGuestpass());
        return status;
    }
    public static int guestlogin(hotelBean u) {
        int status = sqlFunction.guestLogin(u.getGuestid(),u.getGuestpass());
        return status;
    }
    public static int changePassword(hotelBean u) {
        int status=sqlFunction.changePassword("guest,",u.getGuestpass(),u.getEmail());
        return status;
    }
}
