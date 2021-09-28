package com.forepaw.clinic.controllers.dbcontrollers;

import com.forepaw.clinic.dbconnection.DBConnection;
import com.forepaw.clinic.models.Employee;

import java.sql.*;
import java.util.ArrayList;

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

    //update employee
    public static boolean updateEmployee(Employee employee) throws ClassNotFoundException, SQLException {
        String sql = "Update employee set roleId=?,firstName=?,secondName=?,phone=?,email=?,address=? where employeeId=?";
        Connection conn = DBConnection.getDBConnection().getConnection();
        PreparedStatement stm = conn.prepareStatement(sql);
        stm.setObject(1, employee.getRoleId());
        stm.setObject(2, employee.getFirstName());
        stm.setObject(3, employee.getLastName());
        stm.setObject(4, employee.getPhone());
        stm.setObject(5, employee.getEmail());
        stm.setObject(6, employee.getAddress());
        stm.setObject(7, employee.getEmployeeId());
        int res = stm.executeUpdate();
        return res > 0;
    }

    //get all employees
    public static ArrayList<Employee> getAllEmployees() throws ClassNotFoundException, SQLException {
        String sql = "Select * from employee";
        Connection conn = DBConnection.getDBConnection().getConnection();
        Statement stm = conn.createStatement();
        ResultSet rst = stm.executeQuery(sql);
        ArrayList<Employee> employeeList = new ArrayList();
        while (rst.next()) {
            Employee employee = new Employee(rst.getString("employeeId"),rst.getString("roleId"),rst.getString("firstName"), rst.getString("lastName"), rst.getString("phone"), rst.getString("email"), rst.getString("address"));
            employeeList.add(employee);
        }
        return employeeList;
    }

    //filter employees according to role
    public static ArrayList<Employee> getAllEmployees(String roleId) throws ClassNotFoundException, SQLException {
        String sql = "Select * from employee where roleId='"+roleId+"'";
        Connection conn = DBConnection.getDBConnection().getConnection();
        Statement stm = conn.createStatement();
        ResultSet rst = stm.executeQuery(sql);
        ArrayList<Employee> employeeList = new ArrayList();
        while (rst.next()) {
            Employee employee = new Employee(rst.getString("employeeId"),rst.getString("roleId"),rst.getString("firstName"), rst.getString("lastName"), rst.getString("phone"), rst.getString("email"), rst.getString("address"));
            employeeList.add(employee);
        }
        return employeeList;
    }
}
