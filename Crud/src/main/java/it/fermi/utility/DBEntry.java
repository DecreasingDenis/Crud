package it.fermi.utility;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBEntry {

    public static String url = "jdbc:mysql://10.0.9.240:3306/popa";
    public static String username = "popa";
    public static String password = "pop10101l";

    public static Connection conn;

    public static Connection getConnection() {
        try{
            if(conn == null || conn.isClosed()) {
                conn = DriverManager.getConnection(url, username, password);
            }
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
        return conn;
    }

}
