package com.example.task;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Utils {
    private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    public static Date toDate(String str) throws ParseException {
        return sdf.parse(str);
    }
    public static String fromDate(Date date) {
        if (date == null) return "";
        return sdf.format(date);
    }
}
