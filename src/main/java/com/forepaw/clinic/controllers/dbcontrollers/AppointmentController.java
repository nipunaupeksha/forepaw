package com.forepaw.clinic.controllers.dbcontrollers;

import com.forepaw.clinic.dbconnection.DBConnection;
import com.forepaw.clinic.models.Appointment;
import com.forepaw.clinic.models.Employee;

import java.sql.*;

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

    //search appointment
    public static Appointment searchAppointment(String appointmentId) throws ClassNotFoundException, SQLException {
        String sql = "Select * from appointment where appointmentId='" + appointmentId + "'";
        Connection conn = DBConnection.getDBConnection().getConnection();
        Statement stm = conn.createStatement();
        ResultSet rst = stm.executeQuery(sql);
        Appointment appointment = null;
        if (rst.next()) {
            appointment = new Appointment(rst.getString("appointmentId"),rst.getString("customerId"),
                    rst.getString("employeeId"), rst.getString("date"), rst.getString("time"),
                    rst.getString("notes"));
        }
        return appointment;
    }

    //delete appointment
    public static boolean deleteAppointment(String appointmentId) throws ClassNotFoundException, SQLException {
        String sql = "Delete from appointment where appointmentId='" + appointmentId + "'";
        Connection conn = DBConnection.getDBConnection().getConnection();
        Statement stm = conn.createStatement();
        int res = stm.executeUpdate(sql);
        return res > 0;
    }
}
