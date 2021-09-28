package com.forepaw.clinic.controllers.dbcontrollers;

import com.forepaw.clinic.dbconnection.DBConnection;
import com.forepaw.clinic.models.Appointment;
import com.forepaw.clinic.models.Employee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AppointmentController {
    //add new appointment
    public static boolean addAppointment(Appointment appointment)throws SQLException, ClassNotFoundException{
        String sql = "Insert into appointment values(?,?,?,?,?,?)";
        Connection conn = DBConnection.getDBConnection().getConnection();
        PreparedStatement stm = conn.prepareStatement(sql);
        stm.setObject(1, appointment.getAppointId());
        stm.setObject(2, appointment.getCustomerId());
        stm.setObject(3, appointment.getEmployeeId());
        stm.setObject(4, appointment.getDate());
        stm.setObject(5, appointment.getTime());
        stm.setObject(6, appointment.getNotes());
        int res = stm.executeUpdate();
        return res > 0;
    }
}
