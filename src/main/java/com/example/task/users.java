package com.example.task;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class users {
    public static List<hotelBean> getAllBookedRecords() {
        List<hotelBean> list;
        list=sqlFunction.getAllBookedRecords("bookingroom");
        return list;
    }

    public static List<hotelBean> getAllUser() {
        List<hotelBean> list;
        list=sqlFunction.getAllUser("guest");
        return list;
    }

    public static List<hotelBean> getBookingDetails(hotelBean h) {
        List<hotelBean> list;
        list=sqlFunction.getBookingDetails("bookingroom",h.getGuestid());
        return list;
    }
    public static List<hotelBean> getAllUserMember() {
        List<hotelBean> list;
        list=sqlFunction.getAllUserMember("guest");
        return list;
    }
}