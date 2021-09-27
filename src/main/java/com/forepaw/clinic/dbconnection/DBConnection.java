package com.forepaw.clinic.dbconnection;

import java.nio.channels.ConnectionPendingException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private static DBConnection dbConnection;
    private Connection conn;
    private DBConnection() throws ClassNotFoundException, SQLException{
        Class.forName("com.mysql.jdbc.Driver");
        conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/forepaw","root","");
    }
    public static DBConnection getDBConnection() throws ClassNotFoundException, SQLException{
        if(dbConnection==null){
            dbConnection=new DBConnection();
        }
        return dbConnection;
    }
    public Connection getConnection(){
        return conn;
    }
}
