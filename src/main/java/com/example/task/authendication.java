package com.example.task;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class authendication {
    static Connection conn;
    static PreparedStatement pst;
    public static int login(hotelBean u) {
        int status=0;
        try {
            conn = ConnectionProvider.getCon();
            pst = conn.prepareStatement("Select username,userpass from hotel where username=? and userpass=?");
            pst.setString(1, u.getUsername());
            pst.setString(2, u.getUserpass());
            ResultSet rs = pst.executeQuery();
            if (rs.next())
                status=1;
        } catch(Exception ex){
            System.out.println(ex);
        }
        return status;
    }
    public static int signup(hotelBean u){
        int status=0;
        try{
            conn = ConnectionProvider.getCon();
            pst=conn.prepareStatement("insert into guest values(?,?,?,?,?,?)");
            pst.setString(1,u.getGuestname());
            pst.setString(2, u.getGuestid());
            pst.setString(3, u.getEmail());
            pst.setInt(4, u.getContactno());
            pst.setString(5, u.getAddress());
            pst.setString(6,u.getGuestpass());
            status=pst.executeUpdate();
        }catch(Exception exe){
            System.out.println(exe);
        }
        return status;
    }
    public static int guestlogin(hotelBean u) {
        int status=0;
        try {
            conn = ConnectionProvider.getCon();
            pst = conn.prepareStatement("Select guestid,guestpass from guest where guestid=? and guestpass=?");
            pst.setString(1, u.getGuestid());
            pst.setString(2, u.getGuestpass());
            ResultSet rs = pst.executeQuery();
            if (rs.next())
                status=1;
        } catch(Exception ex){
            System.out.println(ex);
        }
        return status;
    }
    public static int changePassword(hotelBean u) {
        int status=0;
        try {
            conn=ConnectionProvider.getCon();
            pst=conn.prepareStatement("update guest set guestpass=? where email=?");
            pst.setString(1,u.getGuestpass());
            pst.setString(2, u.getEmail());
            status=pst.executeUpdate();
        }catch(Exception ex){
            System.out.println(ex);
        }
        return status;
    }
    public static int memberLogin(hotelBean u) {
        int status=0;
        try {
            conn = ConnectionProvider.getCon();
            pst = conn.prepareStatement("Select memberid,guestpass from member where memberid = ? and guestpass = ?");
            pst.setString(1, u.getMemberid());
            pst.setString(2, u.getGuestpass());
            ResultSet rs = pst.executeQuery();
            if (rs.next())
                status=1;
        } catch(Exception ex){
            System.out.println(ex);
        }
        return status;
    }
    public static int memberSignup(hotelBean u){
        int status=0;
        try{
            System.out.println(u.getGuestpass()+"si");
            conn = ConnectionProvider.getCon();
            pst=conn.prepareStatement("insert into member(membername,memberid,memberemail,membercontactno,memberaddress,guestpass) values (?,?,?,?,?,?)");
            pst.setString(1,u.getMembername());
            pst.setString(2, u.getMemberid());
            pst.setString(3, u.getMemberemail());
            pst.setInt(4, u.getMembercontactno());
            pst.setString(5, u.getMemberaddress());
            pst.setString(6,u.getGuestpass());
            status=pst.executeUpdate();
        }catch(Exception exe){
            System.out.println(exe);
        }
        return status;
    }
    public static int changePasswordMember(hotelBean u) {
        int status=0;
        try {
            System.out.println(u.getGuestpass()+"ch");
            conn=ConnectionProvider.getCon();
            pst=conn.prepareStatement("update member set guestpass = ? where memberemail = ?");
            pst.setString(1,u.getGuestpass());
            pst.setString(2, u.getMemberemail());
            status=pst.executeUpdate();
        }catch(Exception ex){
            System.out.println(ex+"+");
        }
        return status;
    }
}
