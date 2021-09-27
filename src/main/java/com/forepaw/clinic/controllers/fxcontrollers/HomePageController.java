package com.forepaw.clinic.controllers.fxcontrollers;

import com.forepaw.clinic.HomePage;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import java.io.IOException;


public class HomePageController {
    public Label addEmployee;
    public Label updateEmployee;
    public Label viewEmployees;
    public Label deleteEmployee;
    public Label addCustomer;
    public Label updateCustomer;
    public Label viewCustomers;
    public Label deleteCustomer;
    public Label addRole;
    public Label updateRole;
    public Label viewRoles;
    public Label deleteRole;
    public Label addAppointment;
    public Label updateAppointment;
    public Label viewAppointments;
    public Label removeAppointment;
    public Label addUser;

    //employees
    @FXML
    protected void addEmployeeMouseClicked() {
        //TODO
    }

    @FXML
    protected void addEmployeeMouseEntered() {
        addEmployee.setFont(Font.font("Poppins", FontWeight.BOLD, 14));
    }

    @FXML
    protected void addEmployeeMouseExited() {
        addEmployee.setFont(Font.font("Poppins", FontWeight.NORMAL, 14));
    }

    @FXML
    protected void updateEmployeeMouseClicked() {
        //TODO
    }

    @FXML
    protected void updateEmployeeMouseEntered() {
        updateEmployee.setFont(Font.font("Poppins", FontWeight.BOLD, 14));
    }

    @FXML
    protected void updateEmployeeMouseExited() {
        addEmployee.setFont(Font.font("Poppins", FontWeight.NORMAL, 14));
    }

    @FXML
    protected void viewEmployeesMouseClicked() {
        //TODO
    }

    @FXML
    protected void viewEmployeesMouseEntered() {
        viewEmployees.setFont(Font.font("Poppins", FontWeight.BOLD, 14));
    }

    @FXML
    protected void viewEmployeesMouseExited() {
        viewEmployees.setFont(Font.font("Poppins", FontWeight.NORMAL, 14));
    }

    @FXML
    protected void deleteEmployeeMouseClicked() {
        //TODO
    }

    @FXML
    protected void deleteEmployeeMouseEntered() {
        deleteEmployee.setFont(Font.font("Poppins", FontWeight.BOLD, 14));
    }

    @FXML
    protected void deleteEmployeeMouseExited() {
        deleteEmployee.setFont(Font.font("Poppins", FontWeight.NORMAL, 14));
    }

    //customers
    @FXML
    protected void addCustomerMouseClicked() {
        /*try {
            Stage stage = (Stage) addCustomer.getScene().getWindow();
            stage.close();
            new AddCustomerPage().start(stage);
        } catch (IOException e) {
            e.printStackTrace();
        }*/
    }

    @FXML
    protected void addCustomerMouseEntered() {
        addCustomer.setFont(Font.font("Poppins", FontWeight.BOLD, 14));
    }

    @FXML
    protected void addCustomerMouseExited() {
        addCustomer.setFont(Font.font("Poppins", FontWeight.NORMAL, 14));
    }

    @FXML
    protected void updateCustomerMouseClicked() {
        //TODO
    }

    @FXML
    protected void updateCustomerMouseEntered() {
        updateCustomer.setFont(Font.font("Poppins", FontWeight.BOLD, 14));
    }

    @FXML
    protected void updateCustomerMouseExited() {
        updateCustomer.setFont(Font.font("Poppins", FontWeight.NORMAL, 14));
    }

    @FXML
    protected void viewCustomersMouseClicked() {
        //TODO
    }

    @FXML
    protected void viewCustomersMouseEntered() {
        viewCustomers.setFont(Font.font("Poppins", FontWeight.BOLD, 14));
    }

    @FXML
    protected void viewCustomersMouseExited() {
        viewCustomers.setFont(Font.font("Poppins", FontWeight.NORMAL, 14));
    }

    @FXML
    protected void deleteCustomerMouseClicked() {
        //TODO
    }

    @FXML
    protected void deleteCustomerMouseEntered() {
        deleteCustomer.setFont(Font.font("Poppins", FontWeight.BOLD, 14));
    }

    @FXML
    protected void deleteCustomerMouseExited() {
        deleteCustomer.setFont(Font.font("Poppins", FontWeight.NORMAL, 14));
    }

    //roles
    @FXML
    protected void addRoleMouseClicked() {
        //TODO
    }

    @FXML
    protected void addRoleMouseEntered() {
        addRole.setFont(Font.font("Poppins", FontWeight.BOLD, 14));
    }

    @FXML
    protected void addRoleMouseExited() {
        addRole.setFont(Font.font("Poppins", FontWeight.NORMAL, 14));
    }

    @FXML
    protected void updateRoleMouseClicked() {
        //TODO
    }

    @FXML
    protected void updateRoleMouseEntered() {
        updateRole.setFont(Font.font("Poppins", FontWeight.BOLD, 14));
    }

    @FXML
    protected void updateRoleMouseExited() {
        updateRole.setFont(Font.font("Poppins", FontWeight.NORMAL, 14));
    }

    @FXML
    protected void viewRolesMouseClicked() {
        //TODO
    }

    @FXML
    protected void viewRolesMouseEntered() {
        viewRoles.setFont(Font.font("Poppins", FontWeight.BOLD, 14));
    }

    @FXML
    protected void viewRolesMouseExited() {
        viewRoles.setFont(Font.font("Poppins", FontWeight.NORMAL, 14));
    }

    @FXML
    protected void deleteRoleMouseClicked() {
        //TODO
    }

    @FXML
    protected void deleteRoleMouseEntered() {
        deleteRole.setFont(Font.font("Poppins", FontWeight.BOLD, 14));
    }

    @FXML
    protected void deleteRoleMouseExited() {
        deleteRole.setFont(Font.font("Poppins", FontWeight.NORMAL, 14));
    }

    //appointments
    @FXML
    protected void addAppointmentMouseClicked() {
        //TODO
    }

    @FXML
    protected void addAppointmentMouseEntered() {
        addAppointment.setFont(Font.font("Poppins", FontWeight.BOLD, 14));
    }

    @FXML
    protected void addAppointmentMouseExited() {
        addAppointment.setFont(Font.font("Poppins", FontWeight.NORMAL, 14));
    }

    @FXML
    protected void updateAppointmentMouseClicked() {
        //TODO
    }

    @FXML
    protected void updateAppointmentMouseEntered() {
        updateAppointment.setFont(Font.font("Poppins", FontWeight.BOLD, 14));
    }

    @FXML
    protected void updateAppointmentMouseExited() {
        updateAppointment.setFont(Font.font("Poppins", FontWeight.NORMAL, 14));
    }

    @FXML
    protected void viewAppointmentsMouseClicked() {
        //TODO
    }

    @FXML
    protected void viewAppointmentsMouseEntered() {
        viewAppointments.setFont(Font.font("Poppins", FontWeight.BOLD, 14));
    }

    @FXML
    protected void viewAppointmentsMouseExited() {
        viewAppointments.setFont(Font.font("Poppins", FontWeight.NORMAL, 14));
    }

    @FXML
    protected void removeAppointmentMouseClicked() {
        //TODO
    }

    @FXML
    protected void removeAppointmentMouseEntered() {
        removeAppointment.setFont(Font.font("Poppins", FontWeight.BOLD, 14));
    }

    @FXML
    protected void removeAppointmentMouseExited() {
        removeAppointment.setFont(Font.font("Poppins", FontWeight.NORMAL, 14));
    }

    //users
    @FXML
    protected void addUserMouseClicked() {
        //TODO
    }

    @FXML
    protected void addUserMouseEntered() {
        addUser.setFont(Font.font("Poppins", FontWeight.BOLD, 14));
    }

    @FXML
    protected void addUserMouseExited() {
        addUser.setFont(Font.font("Poppins", FontWeight.NORMAL, 14));
    }

}
