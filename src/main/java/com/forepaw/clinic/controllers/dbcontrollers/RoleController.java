package com.forepaw.clinic.controllers.dbcontrollers;

import com.forepaw.clinic.dbconnection.DBConnection;
import com.forepaw.clinic.models.Employee;
import com.forepaw.clinic.models.Role;

import java.sql.*;
import java.util.ArrayList;

public class RoleController {
    //search role - returning role
    public static Role searchRole(String roleId) throws ClassNotFoundException, SQLException {
        String sql = "Select * from role where roleId='" + roleId + "'";
        Connection conn = DBConnection.getDBConnection().getConnection();
        Statement stm = conn.createStatement();
        ResultSet rst = stm.executeQuery(sql);
        Role role = null;
        if (rst.next()) {
            role = new Role(rst.getString("roleId"), rst.getString("roleName"), rst.getString("rolePriority"),
                    rst.getString("roleDescription"));
        }
        return role;
    }

    //get all roles
    public static ArrayList<Role> getAllRoles() throws ClassNotFoundException, SQLException {
        String sql = "Select * from role";
        Connection conn = DBConnection.getDBConnection().getConnection();
        Statement stm = conn.createStatement();
        ResultSet rst = stm.executeQuery(sql);
        ArrayList<Role> roleList = new ArrayList();
        while (rst.next()) {
            Role role = new Role(rst.getString("roleId"), rst.getString("roleName"), rst.getString("rolePriority"),
                    rst.getString("roleDescription"));
            roleList.add(role);
        }
        return roleList;
    }

    //add role
    public static boolean addRole(Role role)throws SQLException, ClassNotFoundException{
        String sql = "Insert into role values(?,?,?,?)";
        Connection conn = DBConnection.getDBConnection().getConnection();
        PreparedStatement stm = conn.prepareStatement(sql);
        stm.setObject(1, role.getRoleId());
        stm.setObject(2, role.getRoleName());
        stm.setObject(3, role.getRolePriority());
        stm.setObject(4, role.getRoleDescription());
        int res = stm.executeUpdate();
        return res > 0;
    }

    //delete roll
    public static boolean deleteRole(String roleId) throws SQLException, ClassNotFoundException{
        String sql = "Delete from role where roleId='"+roleId+"'";
        Connection conn = DBConnection.getDBConnection().getConnection();
        Statement stm = conn.createStatement();
        int res = stm.executeUpdate(sql);
        return res > 0;
    }
}
