package com.example.task;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionProvider implements Provider {
   static Connection con=null;
   public static Connection getCon() {
	   try {
		   Class.forName("org.postgresql.Driver");
		   con=DriverManager.getConnection(connURL,username,pwd);
	   }catch(Exception ex) {
		   ex.printStackTrace();
	   }
	   return con;
   }
}
