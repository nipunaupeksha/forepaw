package com.forepaw.clinic.controllers.dbcontrollers;

import com.forepaw.clinic.dbconnection.DBConnection;
import com.forepaw.clinic.models.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UserController {
    //check the validity of username
    public static boolean checkValidity(String userName) throws SQLException, ClassNotFoundException {
        String sql = "Select * from user where userName='" + userName + "'";
        Connection conn = DBConnection.getDBConnection().getConnection();
        Statement stm = conn.createStatement();
        ResultSet rst = stm.executeQuery(sql);
        if (rst.next()) {
            return false;
        } else {
            return true;
        }
    }

    //check whether the username and password is correct
    public static boolean checkUser(User user) throws SQLException, ClassNotFoundException{
        String sql = "Select * from user where userName='" + user.getUsername() + "' && password='" + user.getPassword() + "'";
        Connection conn = DBConnection.getDBConnection().getConnection();
        Statement stm = conn.createStatement();
        ResultSet rst = stm.executeQuery(sql);
        if (rst.next()) {
            return true;
        } else {
            return false;
        }
    }
}
