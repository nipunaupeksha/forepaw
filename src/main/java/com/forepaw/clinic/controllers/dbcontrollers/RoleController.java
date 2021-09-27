package com.forepaw.clinic.controllers.dbcontrollers;

import com.forepaw.clinic.dbconnection.DBConnection;
import com.forepaw.clinic.models.Employee;
import com.forepaw.clinic.models.Role;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class RoleController {
    //search employee - returning employee
    public static Role searchRole(String roleId) throws ClassNotFoundException, SQLException {
        String sql = "Select * from role where roleId='" + roleId + "'";
        Connection conn = DBConnection.getDBConnection().getConnection();
        Statement stm = conn.createStatement();
        ResultSet rst = stm.executeQuery(sql);
        Role role = null;
        if (rst.next()) {
            role = new Role(rst.getString("roleId"), rst.getString("roleName"), rst.getShort("rolePriority"),
                    rst.getString("roleDescription"));
        }
        return role;
    }
}
