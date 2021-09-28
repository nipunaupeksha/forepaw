package com.forepaw.clinic.controllers.fxcontrollers;

import com.forepaw.clinic.AddCustomerPage;
import com.forepaw.clinic.RemoveAppointmentPage;
import com.forepaw.clinic.controllers.dbcontrollers.AppointmentController;
import com.forepaw.clinic.controllers.dbcontrollers.CustomerController;
import com.forepaw.clinic.controllers.dbcontrollers.EmployeeController;
import com.forepaw.clinic.methods.VetClinicMethods;
import com.forepaw.clinic.models.Appointment;
import com.forepaw.clinic.models.Customer;
import com.forepaw.clinic.models.Employee;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AddAppointmentController {
    public ImageView forepawLogo;
    public Label forepawLabel;
    public Label removeAppointmentLabel;
    public Label addAppointmentLabel;
    public ComboBox customerComboBox;
    public ComboBox doctorComboBox;
    public DatePicker dateText;
    public ComboBox ampmComboBox;
    public ComboBox hourComboBox;
    public ComboBox minuteComboBox;
    public TextField appointmentIdText;
    public Label warningLabel;
    public TextArea notesText;

    @FXML
    public void initialize(){
        try{
            //set id
            String val = VetClinicMethods.getNewId("a","appointment");
            if(val!=null){
                appointmentIdText.setText(val);
            }else{
                appointmentIdText.setText("");
            }
            //get all customers
            ArrayList<Customer> customerList = CustomerController.getAllCustomers();
            //get all doctors
            String doctorRoleId = "r001";
            ArrayList<Employee> employeeList = EmployeeController.getAllEmployees(doctorRoleId);
            //put them in combo boxes
            ArrayList<String> editedCustomerList = new ArrayList<>();
            ArrayList<String> editedDoctorsList = new ArrayList<>();
            for(Customer customer: customerList){
                editedCustomerList.add(customer.getCustomerId()+" - "+customer.getFirstName()+" "+customer.getLastName());
            }
            for(Employee employee: employeeList){
                editedDoctorsList.add(employee.getEmployeeId()+" - "+employee.getFirstName()+" "+employee.getLastName());
            }
            customerComboBox.setItems(FXCollections.observableArrayList(editedCustomerList));
            doctorComboBox.setItems(FXCollections.observableArrayList(editedDoctorsList));

            //set time
            ArrayList<String> hoursList = new ArrayList<>();
            ArrayList<String> minutesList = new ArrayList<>();
            String[] ampmArray = {"AM", "PM"};
            List<String> ampmList = Arrays.asList(ampmArray);
            ampmComboBox.setItems(FXCollections.observableArrayList(ampmList));

            for(int i=1;i<=12;i++){
                hoursList.add(Integer.toString(i));
            }
            for(int i=0;i<60;i++){
                minutesList.add(Integer.toString(i));
            }
            hourComboBox.setItems(FXCollections.observableArrayList(hoursList));
            minuteComboBox.setItems(FXCollections.observableArrayList(minutesList));

        }catch(SQLException e){
            e.printStackTrace();
        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }
    }

    @FXML
    protected void forepawLabelClicked() {
        try {
            Stage stage = (Stage) forepawLabel.getScene().getWindow();
            stage.close();
            new AddCustomerPage().start(stage);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    protected void forepawLogoClicked() {
        try {
            Stage stage = (Stage) forepawLogo.getScene().getWindow();
            stage.close();
            new AddCustomerPage().start(stage);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    protected void addAppointmentMouseClicked() {
        String appointmentId = appointmentIdText.getText().trim().toLowerCase();
        if (!appointmentId.equals("")) {
            try {
                //String date = (String)dateText.getValue();
                String customer = ((String)customerComboBox.getValue()).split("-")[0].trim();
                String doctor = ((String)doctorComboBox.getValue()).split(" - ")[0].trim();
                String date = dateText.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
                String time = ((String)hourComboBox.getValue()+"."+(String)minuteComboBox.getValue()+" "+
                        (String)ampmComboBox.getValue()).trim();
                String notes = notesText.getText().trim();

                if(!customer.equals("") && !doctor.equals("") && !date.equals("") && !time.equals("") && !notes.equals("")){
                    Appointment appointment = new Appointment(appointmentId, customer, doctor, date, time, notes);
                    boolean status = AppointmentController.addAppointment(appointment);
                    if(status==true){
                        warningLabel.setTextFill(Color.GREEN);
                        warningLabel.setText("Appointment Added");
                    }else{
                        warningLabel.setTextFill(Color.RED);
                        warningLabel.setText("Appointment could not be added");
                    }
                }else{
                    warningLabel.setText("There are null fields");
                }

            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        } else {
            warningLabel.setText("Appointment Id is null");
        }
    }

    @FXML
    protected void removeAppointmentMouseClicked() {
        try {
            Stage stage = (Stage) removeAppointmentLabel.getScene().getWindow();
            stage.close();
            new RemoveAppointmentPage().start(stage);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
