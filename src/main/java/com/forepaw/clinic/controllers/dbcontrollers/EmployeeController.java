package com.forepaw.clinic.controllers.dbcontrollers;

import com.forepaw.clinic.dbconnection.DBConnection;
import com.forepaw.clinic.models.Employee;

import java.sql.*;

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

    //search employee - returning employee
    public static Employee searchEmployee(String employeeId) throws ClassNotFoundException, SQLException {
        String sql = "Select * from employee where employeeId='" + employeeId + "'";
        Connection conn = DBConnection.getDBConnection().getConnection();
        Statement stm = conn.createStatement();
        ResultSet rst = stm.executeQuery(sql);
        Employee employee = null;
        if (rst.next()) {
            employee = new Employee(rst.getString("employeeId"), rst.getString("roleId"),
                    rst.getString("firstName"), rst.getString("lastName"), rst.getString("phone"),
                    rst.getString("email"), rst.getString("address"));
        }
        return employee;
    }

    //delete employee
    public static boolean deleteEmployee(String employeeId) throws ClassNotFoundException, SQLException {
        String sql = "Delete from employee where employeeId='" + employeeId + "'";
        Connection conn = DBConnection.getDBConnection().getConnection();
        Statement stm = conn.createStatement();
        int res = stm.executeUpdate(sql);
        return res > 0;
    }
}
