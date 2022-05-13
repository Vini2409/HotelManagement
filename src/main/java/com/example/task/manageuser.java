package com.example.task;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class manageuser {
    static Connection conn;
    static PreparedStatement pst;
    public static int manageuser(hotelBean u) {
        int status=0;
        try {
            conn=ConnectionProvider.getCon();
            pst=conn.prepareStatement("select* from bookingroom where roomno=?");
            pst.setInt(1,u.getRoomno());
            ResultSet rs=pst.executeQuery();
            if(rs.next()){
                pst=conn.prepareStatement("select * from bookingroom where roomno=? AND checkin = ? AND checkout = ?");
                pst.setInt(1,u.getRoomno());
                pst.setDate(2, Date.valueOf(u.getCheckin()));
                pst.setDate(3, Date.valueOf(u.getCheckout()));
                ResultSet rq=pst.executeQuery();
                if(rq.next()){
                    return -1;
                }
                else {
                    pst = conn.prepareStatement("select * from bookingroom where roomno=? AND checkin != ? AND checkout != ?");
                    pst.setInt(1, u.getRoomno());
                    pst.setDate(2, Date.valueOf(u.getCheckin()));
                    pst.setDate(3, Date.valueOf(u.getCheckout()));
                    ResultSet rp = pst.executeQuery();
                    if (rp.next()) {
                        pst = conn.prepareStatement("insert into bookingroom(roomno,clientname,age,phoneno,no_of_person,checkin,checkout) values(?,?,?,?,?,?,?)");
                        pst.setInt(1, u.getRoomno());
                        pst.setString(2, u.getClientname());
                        pst.setInt(3, u.getAge());
                        pst.setInt(4, u.getPhoneno());
                        pst.setInt(5, u.getNo_of_person());
                        pst.setDate(6, Date.valueOf(u.getCheckin()));
                        pst.setDate(7, Date.valueOf(u.getCheckout()));
                        status = pst.executeUpdate();
                    }
                }

            }
            else{
                pst=conn.prepareStatement("select * from room where ava_room_id=?");
                pst.setInt(1,u.getRoomno());
                ResultSet sr=pst.executeQuery();
                if(sr.next()){
                    pst = conn.prepareStatement("insert into bookingroom(roomno,clientname,age,phoneno,no_of_person,checkin,checkout) values(?,?,?,?,?,?,?)");
                    pst.setInt(1, u.getRoomno());
                    pst.setString(2, u.getClientname());
                    pst.setInt(3, u.getAge());
                    pst.setInt(4, u.getPhoneno());
                    pst.setInt(5, u.getNo_of_person());
                    pst.setDate(6, Date.valueOf(u.getCheckin()));
                    pst.setDate(7, Date.valueOf(u.getCheckout()));
                    status = pst.executeUpdate();
                }
            }
            conn.close();
        }catch(Exception ex){
            System.out.println(ex);
        }
        return status;
    }
    public static int cancelBooking(hotelBean u) {
        int status=0;
        try {
            conn=ConnectionProvider.getCon();
            pst=conn.prepareStatement("delete from bookingroom where phoneno = ?");
            pst.setInt(1,u.getPhoneno());
            status=pst.executeUpdate();
            conn.close();
        }catch(Exception ex){
            System.out.println(ex);
        }
        return status;
    }
}