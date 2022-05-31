package com.example.task;


import java.sql.*;
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
            pst = conn.prepareStatement("insert into bookingroom(roomno,guestid,no_of_person,checkin,checkout) values(?,?,?,?,?)");
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
            pst = conn.prepareStatement("Select username,userpass from "+tableName+" where username=? and userpass=?");
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
            pst = conn.prepareStatement("Select guestid,guestpass from guest where guestid = ? and guestpass = ?");
            pst.setString(1, id);
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
    public static int cancelBooking(String name,int roomNumber){
        int status=0;
        try{
            conn=ConnectionProvider.getCon();
            pst=conn.prepareStatement("delete from bookingroom where guestid = ? AND roomno = ?");
            pst.setString(1,name);
            pst.setInt(2,roomNumber);
            status=pst.executeUpdate();
        }catch(Exception ex){
            System.out.println(ex);
        }
        return status;
    }
    public static int changePassword(String tableName,String guestPassword, String email){
        int status = 0;
        try {
            conn=ConnectionProvider.getCon();
            pst=conn.prepareStatement("update "+tableName+" set guestpass = ? where email = ?");
            pst.setString(1,guestPassword);
            pst.setString(2,email);
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
            pst = conn.prepareStatement("select guestid,member from "+tableName+" where guestid = ? and member != true");
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
    public static int changeMemberToUser(String tableName,String id){
        int status = 0;
        try{
            conn = ConnectionProvider.getCon();
            pst = conn.prepareStatement("update "+tableName+" set member = false where guestid = ?");
            pst.setString(1, id);
            status=pst.executeUpdate();
        }catch(Exception ex){
            System.out.println(ex);
        }
        return status;
    }
    public static int changeUserToMember(String tableName,String id){
        int status = 0;
        try{
            conn=ConnectionProvider.getCon();
            pst=conn.prepareStatement("update "+tableName+" set member = true where guestid = ?");
            pst.setString(1,id);
            status = pst.executeUpdate();
        }catch(Exception ex){
            System.out.println(ex);
        }
        return status;
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
    public static int updateRoom(String tableName,int id,int floor,int price,String type){
        int status=0;
        String query = "update "+tableName+" set ";
        ArrayList<Object> params = new ArrayList<>();
        boolean isAlreadyAdded = false;
        if (floor != 0) {
            query += "floor = ?";
            params.add(floor);
            isAlreadyAdded = true;
        }
        if (price != 0) {
            if (isAlreadyAdded) query += ", ";
            query += "price = ?";
            params.add(price);
            isAlreadyAdded = true;
        }
        if (type != null) {
            if (isAlreadyAdded) query += ", ";
            query += "type = ?";
            params.add(type);
        }
        query += " where ava_room_id = ?";
        if (params.size() < 1) {
            return -1;
        }
        System.out.println(query);
        try {
            conn=ConnectionProvider.getCon();
            pst=conn.prepareStatement(query);
            for (int i = 0; i < params.size(); i++) {
                Object param = params.get(i);
                if (param instanceof String) {
                    pst.setString(i+1, (String) param);
                } else {
                    pst.setInt(i+1, (Integer) param);
                }
            }
            pst.setInt(params.size()+1, id);
            status=pst.executeUpdate();
        } catch (SQLException e) {
//            System.out.println(e);
            e.printStackTrace();
        }
        return status;
    }
    public static int manageuser(String tableName,int roomNumber,String guestid,int numberOfPeople,Date checkin, Date checkout) {
        int status = 0;
        try {
            conn = ConnectionProvider.getCon();
            System.out.println(checkin);
            pst = conn.prepareStatement("select* from "+tableName+" where roomno=?");
            pst.setInt(1, roomNumber);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                pst = conn.prepareStatement("select * from "+tableName+" where roomno=? AND ((checkin <= ? AND checkout >= ?) OR (checkin<=? AND checkout>=?) OR (checkin >? AND checkout < ?))");
                pst.setInt(1, roomNumber);
                pst.setDate(2, checkin);
                pst.setDate(3, checkin);
                pst.setDate(4, checkout);
                pst.setDate(5, checkout);
                pst.setDate(6, checkin);
                pst.setDate(7, checkout);
                ResultSet rq = pst.executeQuery();
                if (rq.next()) {
                    return -1;
                } else {
                    status = bookinRoom(roomNumber, guestid, numberOfPeople, checkin, checkout);
                }

            } else {
                System.out.println(roomNumber);
                pst = conn.prepareStatement("select * from room where ava_room_id=?");
                pst.setInt(1, roomNumber);
                ResultSet sr = pst.executeQuery();
                if (sr.next()) {
                    status = bookinRoom(roomNumber, guestid, numberOfPeople, checkin, checkout);
                }
            }
//                excel.excel(u.getRoomno(),u.getGuestid(),u.getNo_of_person(),Date.valueOf(u.getCheckin()),Date.valueOf(u.getCheckout()));
//                excel.selectall();
        } catch (Exception e) {
            System.out.println(e);
        }
        return status;
    }
    public static int updateProfile(String tableName,String name, String id, String email, int contactNumber, String address) {
        int status = 0;
        ArrayList<Object> params = new ArrayList<>();
        String query = "";
        query = "update "+tableName+" set ";
//                ArrayList<Object> params = new ArrayList<>();
        boolean isAlreadyAdded = false;
        if (name != null) {
            query += "guestname = ?";
            params.add(name);
            isAlreadyAdded = true;
        }
        if (email != null) {
            if (isAlreadyAdded) query += ", ";
            query += "email = ?";
            params.add(email);
            isAlreadyAdded = true;
        }
        if (contactNumber != 0) {
            if (isAlreadyAdded) query += ", ";
            query += "contactno = ?";
            params.add(contactNumber);
            isAlreadyAdded = true;
        }
        if (address != null) {
            if (isAlreadyAdded) query += ", ";
            query += "address = ?";
            params.add(address);
        }
        query += " where guestid = ?";
        if (params.size() < 1) {
            return -1;
        }
        System.out.println(query);
        try {
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
            pst.setString(params.size() + 1, id);
            status = pst.executeUpdate();
        } catch (SQLException ec) {
            ec.printStackTrace();
        }
        return status;
    }
    public static List<hotelBean> getAllAvalibleRoom(String tableName){
        List<hotelBean> list= new ArrayList<>();
        try {
            conn=ConnectionProvider.getCon();
            pst=conn.prepareStatement("select * from "+tableName+" order by ava_room_id");
            ResultSet rs=pst.executeQuery();
            while(rs.next()) {
                hotelBean u = new hotelBean();
                u.setAva_room_id(rs.getInt("ava_room_id"));
                u.setFloor(rs.getInt("floor"));
                u.setPrice(rs.getInt("price"));
                u.setType(rs.getString("type"));
                list.add(u);
            }
        }catch(Exception ex){
            System.out.println(ex);
        }
        return list;
    }
    public static List<hotelBean> roomsearch(int floor,int price,String type,Date checkin,Date checkout){
        System.out.println("Hello");
        System.out.println(floor+".");
        String query = "select * from room where ";
        ArrayList<Object> params = new ArrayList<>();
        List<hotelBean> list= new ArrayList<>();
        boolean isAlreadyAdded = false;
        if (floor != 0) {
            query += "floor = ?";
            params.add(floor);
            isAlreadyAdded = true;
        }
        if (price != 0) {
            if (isAlreadyAdded) query += " and ";
            query += "price <= ?";
            params.add(price);
            isAlreadyAdded = true;
        }
        if (type != null) {
            if (isAlreadyAdded) query += " and ";
            query += "type = ? ";
            params.add(type);
            isAlreadyAdded = true;
        }
        if(checkout!=null && checkin!=null){
            search(checkin,checkout);
            System.out.println(checkin+"+");
            if(isAlreadyAdded) query += " and ";
            query+="booked = false";
        }

        query+=" order by ava_room_id";
        System.out.println(query);
        System.out.println(params.size());
        try {
            conn=ConnectionProvider.getCon();
            pst=conn.prepareStatement(query);
            for (int i = 0; i < params.size(); i++) {
                Object param = params.get(i);
                if (param instanceof String) {
                    pst.setString(i+1, (String) param);
                } else {
                    pst.setInt(i+1, (Integer) param);
                }
            }
            ResultSet rs =pst.executeQuery();
            while(rs.next()) {
                hotelBean a=new hotelBean();
                a.setAva_room_id(rs.getInt("ava_room_id"));
                a.setFloor(rs.getInt("floor"));
                a.setPrice(rs.getInt("price"));
                a.setType(rs.getString("type"));
                list.add(a);
            }
            pst=conn.prepareStatement("update room set booked=false");
            pst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
    public static List<hotelBean> getAllBookedRecords(String tableName) {
        List<hotelBean> list = new ArrayList<>();
        System.out.println();
        try {
            conn = ConnectionProvider.getCon();
            pst = conn.prepareStatement("Select * from "+tableName);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                hotelBean u = new hotelBean();
                u.setRoomno(rs.getInt("roomno"));
                u.setGuestid(rs.getString("guestid"));
                u.setNo_of_person(rs.getInt("no_of_person"));
                u.setCheckin(Utils.fromDate(rs.getDate("checkin")));
                u.setCheckout(Utils.fromDate(rs.getDate("checkout")));
                list.add(u);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return list;
    }
    public static List<hotelBean> getAllUser(String tableName) {
        List<hotelBean> list = new ArrayList<>();
        try {
            conn = ConnectionProvider.getCon();
            pst = conn.prepareStatement("SELECT * from " + tableName + " where member = false");
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                hotelBean u = new hotelBean();
                u.setGuestname(rs.getString("guestname"));
                u.setGuestid(rs.getString("guestid"));
                u.setEmail(rs.getString("email"));
                u.setContactno(rs.getInt("contactno"));
                u.setAddress(rs.getString("address"));
                list.add(u);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return list;
    }
    public static List<hotelBean> getBookingDetails(String tableName,String id) {
        List<hotelBean> list = new ArrayList<>();
        System.out.println();
        try {
            conn = ConnectionProvider.getCon();
            pst = conn.prepareStatement("SELECT roomno,guestid,checkin,checkout FROM "+tableName+" where guestid = ?");
            pst.setString(1,id);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                hotelBean u = new hotelBean();
                u.setRoomno(rs.getInt("roomno"));
                u.setGuestid(rs.getString("guestid"));
                u.setCheckin(Utils.fromDate(rs.getDate("checkin")));
                u.setCheckout(Utils.fromDate(rs.getDate("checkout")));
                list.add(u);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return list;
    }
    public static List<hotelBean> getAllUserMember(String tableName) {
        List<hotelBean> list = new ArrayList<>();
        try {
            conn = ConnectionProvider.getCon();
            pst = conn.prepareStatement("SELECT * from "+tableName+" where member = true");
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                hotelBean u = new hotelBean();
                u.setGuestname(rs.getString("guestname"));
                u.setGuestid(rs.getString("guestid"));
                u.setEmail(rs.getString("email"));
                u.setContactno(rs.getInt("contactno"));
                u.setAddress(rs.getString("address"));
                list.add(u);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return list;
    }
}
