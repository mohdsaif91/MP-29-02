package com.mycompany.mp2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * 
 * CopyRight cosmos
 */
/**
 * @author saif
 */
public class ConnectionClass {

    static Connection con;
    //  postgres://ikrrzbfqkyakhc:fddd0c585773cf0e09c5fab36199fafd9a4ca1cf01974644e04674001c9dfbaa@ec2-23-20-129-146.compute-1.amazonaws.com:5432/dfvdhftdt5i9q3
//

    static String url = "jdbc:postgresql://ec2-23-20-129-146.compute-1.amazonaws.com:5432/dfvdhftdt5i9q3";
    static String password = "fddd0c585773cf0e09c5fab36199fafd9a4ca1cf01974644e04674001c9dfbaa";
    static String user = "ikrrzbfqkyakhc";
//    static String url = "jdbc:postgresql://database-1.chnt7rhokzdz.us-east-1.rds.amazonaws.com:5432/sherifwebsite";
//    static String user = "postgres";
//    static String password = "postgres";

    public static Connection getConnection() {
        try {
            Class.forName("org.postgresql.Driver");
            con = DriverManager.getConnection(url, user, password);
            return con;
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionClass.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ConnectionClass.class.getName()).log(Level.SEVERE, null, ex);
        }
        return con;
    }

}
