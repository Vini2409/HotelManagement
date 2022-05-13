package com.example.task;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class login {
    static Connection conn;
    static PreparedStatement pst;

    public static int login(hotelBean u) {
        int status=0;
        try {
            conn = ConnectionProvider.getCon();
            pst = conn.prepareStatement("Select userid,username,userpass from hotel where userid=? and username=? and userpass=?");
            pst.setInt(1, u.getUserid());
            pst.setString(2, u.getUsername());
            pst.setString(3, u.getUserpass());
            ResultSet rs = pst.executeQuery();
            if (rs.next())
                status=1;
            else
                status=0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return status;
    }
}
