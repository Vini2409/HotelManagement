package com.example.task;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class usersBooked {
    static Connection conn;
    static PreparedStatement pst;
    public static List<hotelBean> getAllRecords(){
        List<hotelBean> list= new ArrayList<>();
        try {
            conn=ConnectionProvider.getCon();
            pst=conn.prepareStatement("select * from bookingroom");
            ResultSet rs=pst.executeQuery();
            while(rs.next()) {
                hotelBean u = new hotelBean();
                u.setRoomno(rs.getInt("roomno"));
                u.setClientname(rs.getString("clientname"));
                u.setAge(rs.getInt("age"));
                u.setPhoneno(rs.getInt("phoneno"));
                u.setNo_of_person(rs.getInt("no_of_person"));
                u.setCheckin(Utils.fromDate(rs.getDate("checkin")));
                u.setCheckout(Utils.fromDate(rs.getDate("checkout")));
                list.add(u);
            }
            conn.close();
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return list;
    }
}
