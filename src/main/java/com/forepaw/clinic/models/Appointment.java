package com.forepaw.clinic.models;

public class Appointment {
    private String appointId;
    private String customerId;
    private String employeeId;
    private String date;
    private String time;
    private String notes;

    public Appointment() {
    }

    public Appointment(String appointId, String customerId, String employeeId, String date, String time, String notes) {
        this.appointId = appointId;
        this.customerId = customerId;
        this.employeeId = employeeId;
        this.date = date;
        this.time = time;
        this.notes = notes;
    }

    public String getAppointId() {
        return appointId;
    }

    public void setAppointId(String appointId) {
        this.appointId = appointId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}
