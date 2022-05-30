package com.example.task;

import java.io.FileWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.RandomAccessFile;
public class excel {
    static Connection conn;
    static PreparedStatement pst;

    public static void excel(int roomno,String clientname,int no_of_people,Date checkin,Date checkout) {
//            String filename = "C:\\Users\\vinis\\Downloads\\data-.csv";
//            Statement stmt;
//            try {
//                FileWriter fw = new FileWriter(filename);
//                fw.append("ROOM NUMBER");
//                fw.append(',');
//                fw.append("CLIENT NAME");
//                fw.append(',');
//                fw.append("N0_OF_PEOPLE");
//                fw.append(',');
//                fw.append("CHECKIN DATE");
//                fw.append(',');
//                fw.append("CHECK OUT DATE");
//                fw.append('\n');
//                conn = ConnectionProvider.getCon();
//                String query = "select * from bookingroom";
//                stmt = conn.createStatement();
//                ResultSet rs = stmt.executeQuery(query);
//                while (rs.next()) {
//                    fw.append(rs.getString(5));
//                    fw.append(',');
//                    fw.append(rs.getString(4));
//                    fw.append(',');
//                    fw.append(rs.getString(1));
//                    fw.append(',');
//                    fw.append(rs.getString(2));
//                    fw.append(',');
//                    fw.append(rs.getString(3));
//                    fw.append('\n');
//                }
//                fw.flush();
//                fw.close();
//                conn.close();
//                System.out.println("Successfully Created Csv file.");
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
        File file = new File("C:\\\\Users\\\\vinis\\\\Downloads\\\\data-.csv");
        String recordString;

        try {

            RandomAccessFile raf = new RandomAccessFile(file, "rw");
            while (raf.getFilePointer() < raf.length())
            {
                recordString = raf.readLine();
            }
            recordString = roomno + "," + clientname + "," + no_of_people + "," + checkin +","+checkout;
            raf.writeBytes(recordString);
            raf.writeBytes(System.lineSeparator());
            System.out.println("User added");
            raf.close();
        }
        catch (IOException ex) {
            System.out.println(ex);
        }
    }
}
