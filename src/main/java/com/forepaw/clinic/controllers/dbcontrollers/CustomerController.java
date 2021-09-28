package com.forepaw.clinic.controllers.dbcontrollers;

import com.forepaw.clinic.dbconnection.DBConnection;
import com.forepaw.clinic.models.Customer;

import java.sql.*;
import java.util.ArrayList;

public class CustomerController {
    //add new customer
    public static boolean addCustomer(Customer customer)throws SQLException, ClassNotFoundException{
        String sql = "Insert into customer values(?,?,?,?,?,?)";
        Connection conn = DBConnection.getDBConnection().getConnection();
        PreparedStatement stm = conn.prepareStatement(sql);
        stm.setObject(1, customer.getCustomerId());
        stm.setObject(2, customer.getFirstName());
        stm.setObject(3, customer.getLastName());
        stm.setObject(4, customer.getPhone());
        stm.setObject(5, customer.getEmail());
        stm.setObject(6, customer.getAddress());
        int res = stm.executeUpdate();
        return res > 0;
    }

    //search customer - returning customer
    public static Customer searchCustomer(String customerId) throws ClassNotFoundException, SQLException {
        String sql = "Select * from customer where customerId='" + customerId + "'";
        Connection conn = DBConnection.getDBConnection().getConnection();
        Statement stm = conn.createStatement();
        ResultSet rst = stm.executeQuery(sql);
        Customer customer = null;
        if (rst.next()) {
            customer = new Customer(rst.getString("customerId"), rst.getString("firstName"),
                    rst.getString("lastName"), rst.getString("phone"),
                    rst.getString("email"), rst.getString("address"));
        }
        return customer;
    }

    //delete customer
    public static boolean deleteCustomer(String customerId) throws ClassNotFoundException, SQLException {
        String sql = "Delete from employee where employeeId='" + customerId + "'";
        Connection conn = DBConnection.getDBConnection().getConnection();
        Statement stm = conn.createStatement();
        int res = stm.executeUpdate(sql);
        return res > 0;
    }

    //update customer
    public static boolean updateCustomer(Customer customer) throws ClassNotFoundException, SQLException {
        String sql = "Update customer set firstName=?,secondName=?,phone=?,email=?,address=? where customerId=?";
        Connection conn = DBConnection.getDBConnection().getConnection();
        PreparedStatement stm = conn.prepareStatement(sql);
        stm.setObject(1, customer.getFirstName());
        stm.setObject(2, customer.getLastName());
        stm.setObject(3, customer.getPhone());
        stm.setObject(4, customer.getEmail());
        stm.setObject(5, customer.getAddress());
        stm.setObject(6, customer.getCustomerId());
        int res = stm.executeUpdate();
        return res > 0;
    }
    //get all customers
    public static ArrayList<Customer> getAllCustomers() throws ClassNotFoundException, SQLException {
        String sql = "Select * from customer";
        Connection conn = DBConnection.getDBConnection().getConnection();
        Statement stm = conn.createStatement();
        ResultSet rst = stm.executeQuery(sql);
        ArrayList<Customer> customerList = new ArrayList();
        while (rst.next()) {
            Customer customer = new Customer(rst.getString("customerId"), rst.getString("firstName"), rst.getString("lastName"),
                    rst.getString("phone"), rst.getString("email"), rst.getString("address"));
            customerList.add(customer);
        }
        return customerList;
    }
}
