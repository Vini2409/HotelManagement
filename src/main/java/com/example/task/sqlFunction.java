package com.example.task;


import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class sqlFunction {
    static Connection conn;
    static PreparedStatement pst;

    public static List<hotelBean> filter(Integer room,Integer floor,Integer price,String type) {
        List<hotelBean> result = new ArrayList<>();
        String[] keys ={"ava_room_id","floor", "price", "type"};
        Object[] values = {room,floor,price,type};
        StringBuilder query = new StringBuilder("SELECT * FROM room");
        ArrayList<Object> params = new ArrayList<>();
        boolean isadded = false;
        for (int i = 0; i < keys.length; i++) {
            Object v = values[i];
            String c = keys[i];
            if (v == null) continue;
            params.add(v);
            if(isadded) {
                query.append(" and ");
            } else {
                query.append(" where ");
                isadded = true;
            }
            query.append(c).append(" = ?");
        }

        try {
            conn = ConnectionProvider.getCon();
            pst = conn.prepareStatement(query.toString());
            System.out.println(query.toString());
            for(int i =0;i <params.size(); ++i) {
                Object p = params.get(i);
                if (p instanceof String) {
                    pst.setString(i+1, (String) p);
                }else{
                    pst.setInt(i+1, (Integer)p);
                }
            }
            ResultSet rs =pst.executeQuery();
            while(rs.next()) {
                int ava_room_id =rs.getInt("ava_room_id");
                int r_floor = rs.getInt("floor");
                int r_price = rs.getInt("price");
                String r_type = rs.getString("type");
                hotelBean hb = new hotelBean();
                hb.setAva_room_id(ava_room_id);
                hb.setFloor(r_floor);
                hb.setPrice(r_price);
                hb.setType(r_type);
                result.add(hb);
            }
        } catch (Exception e) {
             e.printStackTrace();
        }
        return result;
    }


    public static int insertQuery(String tableName,String name, String id, String email, int contactNumber, String address, String password) {
        int status = 0;
        try {
            conn = ConnectionProvider.getCon();
            pst = conn.prepareStatement("insert into "+tableName+" values(?,?,?,?,?,?)");
            pst.setString(1, name);
            pst.setString(2, id);
            pst.setString(3, email);
            pst.setInt(4, contactNumber);
            pst.setString(5, address);
            pst.setString(6, password);
            System.out.println(id);
            status = pst.executeUpdate();
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return status;
    }
    public static int bookinRoom(int roomnumber, String id, int no_of_person, Date checkin, Date checkout) {
        int status=0;
        try {
            conn = ConnectionProvider.getCon();
            pst = conn.prepareStatement("insert into bookingroom(roomno,clientname,no_of_person,checkin,checkout) values(?,?,?,?,?)");
            pst.setInt(1, roomnumber);
            pst.setString(2, id);
            pst.setInt(3, no_of_person);
            pst.setDate(4, checkin);
            pst.setDate(5, checkout);
            status = pst.executeUpdate();
        }catch (Exception ex) {
            System.out.println(ex);
        }
        return status;
    }
    public static int deleteQuery(String tableName,int roomnumber){
        int status=0;
        try{
            conn=ConnectionProvider.getCon();
            pst=conn.prepareStatement("delete from "+tableName+" where ava_room_id = ?");
            pst.setInt(1,roomnumber);
            status=pst.executeUpdate();
        }catch(Exception ex){
            System.out.println(ex);
        }
        return status;
    }
    public static int insertRoom(String tableName,int ava_room_number,int floor,int price,String type){
        int status=0;
        try{
            conn=ConnectionProvider.getCon();
            pst=conn.prepareStatement("insert into "+tableName+" values(?,?,?,?)");
            pst.setInt(1,ava_room_number);
            pst.setInt(2, floor);
            pst.setInt(3, price);
            pst.setString(4,type);
            status=pst.executeUpdate();
        }catch(Exception ex){
            System.out.println(ex);
        }
        return status;
    }
    public static int member(String tableName,String id){
        int status=0;
        try{
            conn=ConnectionProvider.getCon();
            pst=conn.prepareStatement("delete from "+tableName+" where memberid = ?");
            pst.setString(1,id);
            status=pst.executeUpdate();
        }catch(Exception ex){
            System.out.println(ex);
        }
        return status;
    }
    public static int user(String tableName,String id){
        int status=0;
        try{
            conn=ConnectionProvider.getCon();
            pst=conn.prepareStatement("delete from "+tableName+" where guestid = ?");
            pst.setString(1,id);
            status=pst.executeUpdate();
        }catch(Exception ex){
            System.out.println(ex);
        }
        return status;
    }
    public static int loginRecep(String tableName,String name,String password){
        int status=0;
        try{
            conn = ConnectionProvider.getCon();
            conn = ConnectionProvider.getCon();
            pst = conn.prepareStatement("Select username,userpass from hotel where username=? and userpass=?");
            pst.setString(1, name);
            pst.setString(2, password);
            ResultSet rs = pst.executeQuery();
            while(rs.next()){
                status=1;
            }
        }catch(Exception ex){
            System.out.println(ex);
        }
        return status;
    }
    public static int guestLogin(String id,String password){
        int status=0;
        try{
            conn = ConnectionProvider.getCon();
            pst = conn.prepareStatement("Select (memberid,guestpass) from member where memberid = ? and guestpass = ? union all select (guestid,guestpass) from guest where guestid = ? and guestpass = ?");
            pst.setString(1, id);
            pst.setString(2, password);
            pst.setString(3, id);
            pst.setString(4, password);
            ResultSet rs = pst.executeQuery();
            while(rs.next()){
                status=1;
            }
        }catch(Exception ex){
            System.out.println(ex);
        }
        return status;
    }
    public static int cancelBooking(String name,int roomNumber){
        int status=0;
        try{
            conn=ConnectionProvider.getCon();
            pst=conn.prepareStatement("delete from bookingroom where clientname = ? AND roomno = ?");
            pst.setString(1,name);
            pst.setInt(2,roomNumber);
            status=pst.executeUpdate();
        }catch(Exception ex){
            System.out.println(ex);
        }
        return status;
    }
    public static int checkIfUser(String tableName,String id){
        int status=0;
        try{
            conn = ConnectionProvider.getCon();
            pst = conn.prepareStatement("select guestid from "+tableName+" where guestid = ?");
            System.out.println(id);
            pst.setString(1,id);
            ResultSet rs= pst.executeQuery();
            if(rs.next()){
                status=1;
            }
        }catch(Exception ex){
            System.out.println(ex);
        }
        return status;
    }
    public static void changeMemberToUser(String id){
        try{
            conn = ConnectionProvider.getCon();
            pst = conn.prepareStatement("Insert into guest (guestname, guestid, email, contactno, address, guestpass) select membername,memberid,memberemail,membercontactno,memberaddress,guestpass from member where memberid = ?");
            pst.setString(1, id);
            pst.executeUpdate();
        }catch(Exception ex){
            System.out.println(ex);
        }
    }
    public static void changeUserToMember(String id){
        try{
            conn=ConnectionProvider.getCon();
            pst=conn.prepareStatement("Insert into member (membername, memberid, memberemail, membercontactno, memberaddress, guestpass) select guestname,guestid,email,contactno,address,guestpass from guest where guestid = ?");
            pst.setString(1,id);
            pst.executeUpdate();
        }catch(Exception ex){
            System.out.println(ex);
        }
    }
    public static void search(Date checkin,Date checkout){
        try{
            conn=ConnectionProvider.getCon();
            pst=conn.prepareStatement("update room set booked=true from bookingroom where roomno=ava_room_id AND ((checkin <= ? AND checkout >= ?) OR (checkin <= ? AND checkout >= ?) OR (checkin >? AND checkout < ?))");
            pst.setDate(1, checkin);
            pst.setDate(2, checkin);
            pst.setDate(3, checkout);
            pst.setDate(4, checkout);
            pst.setDate(5, checkin);
            pst.setDate(6, checkout);
            pst.executeUpdate();
        }catch(Exception ex){
            System.out.println(ex);
        }
    }

}
