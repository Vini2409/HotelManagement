package com.example.task;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
        int status=0;
        try {
            conn=ConnectionProvider.getCon();
            pst=conn.prepareStatement("select guestid from guest where email = ?");
            pst.setString(1,u.getEmail());
            ResultSet rs=pst.executeQuery();
            if(rs.next()){
               pst=conn.prepareStatement("update guest set guestpass = ? where email = ?");
                pst.setString(1,u.getGuestpass());
                pst.setString(2, u.getEmail());
                status=pst.executeUpdate();
            }
            else {
                pst=conn.prepareStatement("select memberid from member where memberemail = ?");
                pst.setString(1,u.getEmail());
                ResultSet re=pst.executeQuery();
                if(re.next()){
                    pst=conn.prepareStatement("update member set guestpass = ? where memberemail = ?");
                    pst.setString(1,u.getGuestpass());
                    pst.setString(2, u.getEmail());
                    status=pst.executeUpdate();
                }
            }
        }catch(Exception ex){
            System.out.println(ex);
        }
        return status;
    }
}
