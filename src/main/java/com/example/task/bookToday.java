package com.example.task;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.sql.Date;

public class bookToday {
    static Connection conn;
    static PreparedStatement pst;
    public static int bookToday(hotelBean u) {
        int status =0;
        long ctm = System.currentTimeMillis();
        Date d = new Date(ctm);
        LocalDate localDate = d.toLocalDate();
        Date sqldate = Date.valueOf(localDate);
        System.out.println(sqldate);
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
                    pst.setDate(2, sqldate);
                    pst.setDate(3, sqldate);
                    pst.setDate(4, Date.valueOf(u.getCheckout()));
                    pst.setDate(5, Date.valueOf(u.getCheckout()));
                    pst.setDate(6, sqldate);
                    pst.setDate(7, Date.valueOf(u.getCheckout()));
                    ResultSet rq = pst.executeQuery();
                    if (rq.next()) {
                        return -1;
                    } else {
                        pst = conn.prepareStatement("insert into bookingroom(roomno,clientname,no_of_person,checkin,checkout) values(?,?,?,?,?)");
                        pst.setInt(1, u.getRoomno());
                        pst.setString(2, u.getClientname());
                        pst.setInt(3, u.getNo_of_person());
                        pst.setDate(4, sqldate);
                        pst.setDate(5, Date.valueOf(u.getCheckout()));
                        status = pst.executeUpdate();
                    }

                } else {
                    System.out.println(u.getRoomno());
                    pst = conn.prepareStatement("select * from room where ava_room_id=?");
                    pst.setInt(1, u.getRoomno());
                    ResultSet sr = pst.executeQuery();
                    if (sr.next()) {
                        pst = conn.prepareStatement("insert into bookingroom(roomno,clientname,no_of_person,checkin,checkout) values(?,?,?,?,?)");
                        pst.setInt(1, u.getRoomno());
                        pst.setString(2, u.getClientname());
                        pst.setInt(3, u.getNo_of_person());
                        pst.setDate(4, sqldate);
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
}
