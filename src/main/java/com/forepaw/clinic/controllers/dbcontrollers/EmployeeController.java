package com.forepaw.clinic.controllers.dbcontrollers;

import com.forepaw.clinic.dbconnection.DBConnection;
import com.forepaw.clinic.models.Employee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class EmployeeController {
    //add new employee
    public static boolean addEmployee(Employee employee)throws SQLException, ClassNotFoundException{
        String sql = "Insert into employee values(?,?,?,?,?,?,?)";
        Connection conn = DBConnection.getDBConnection().getConnection();
        PreparedStatement stm = conn.prepareStatement(sql);
        stm.setObject(1, employee.getEmployeeId());
        stm.setObject(2, employee.getRoleId());
        stm.setObject(3, employee.getFirstName());
        stm.setObject(4, employee.getLastName());
        stm.setObject(5, employee.getPhone());
        stm.setObject(6, employee.getEmail());
        stm.setObject(7, employee.getAddress());
        int res = stm.executeUpdate();
        return res > 0;
    }
}
