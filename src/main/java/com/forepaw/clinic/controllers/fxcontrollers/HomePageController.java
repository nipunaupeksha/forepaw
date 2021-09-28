package com.forepaw.clinic.controllers.fxcontrollers;

import com.forepaw.clinic.*;
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
        try {
            Stage stage = (Stage) addEmployee.getScene().getWindow();
            stage.close();
            new AddEmployeePage().start(stage);
        } catch (IOException e) {
            e.printStackTrace();
        }
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
        try {
            Stage stage = (Stage) updateEmployee.getScene().getWindow();
            stage.close();
            new UpdateEmployeePage().start(stage);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    protected void updateEmployeeMouseEntered() {
        updateEmployee.setFont(Font.font("Poppins", FontWeight.BOLD, 14));
    }

    @FXML
    protected void updateEmployeeMouseExited() {
        updateEmployee.setFont(Font.font("Poppins", FontWeight.NORMAL, 14));
    }

    @FXML
    protected void viewEmployeesMouseClicked() {
        try {
            Stage stage = (Stage) viewEmployees.getScene().getWindow();
            stage.close();
            new ViewEmployeesPage().start(stage);
        } catch (IOException e) {
            e.printStackTrace();
        }
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
        try {
            Stage stage = (Stage) deleteEmployee.getScene().getWindow();
            stage.close();
            new DeleteEmployeePage().start(stage);
        } catch (IOException e) {
            e.printStackTrace();
        }
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
        try {
            Stage stage = (Stage) addCustomer.getScene().getWindow();
            stage.close();
            new AddCustomerPage().start(stage);
        } catch (IOException e) {
            e.printStackTrace();
        }
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
        try {
            Stage stage = (Stage) updateCustomer.getScene().getWindow();
            stage.close();
            new UpdateCustomerPage().start(stage);
        } catch (IOException e) {
            e.printStackTrace();
        }
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
        try {
            Stage stage = (Stage) viewCustomers.getScene().getWindow();
            stage.close();
            new ViewCustomersPage().start(stage);
        } catch (IOException e) {
            e.printStackTrace();
        }
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
        try {
            Stage stage = (Stage) deleteCustomer.getScene().getWindow();
            stage.close();
            new DeleteCustomerPage().start(stage);
        } catch (IOException e) {
            e.printStackTrace();
        }
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
        try {
            Stage stage = (Stage) addRole.getScene().getWindow();
            stage.close();
            new AddRolePage().start(stage);
        } catch (IOException e) {
            e.printStackTrace();
        }
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
        try {
            Stage stage = (Stage) updateRole.getScene().getWindow();
            stage.close();
            new UpdateRolePage().start(stage);
        } catch (IOException e) {
            e.printStackTrace();
        }
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
        /*try {
            Stage stage = (Stage) viewRoles.getScene().getWindow();
            stage.close();
            new ViewRolesPage().start(stage);
        } catch (IOException e) {
            e.printStackTrace();
        }*/
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
        try {
            Stage stage = (Stage) deleteRole.getScene().getWindow();
            stage.close();
            new DeleteRolePage().start(stage);
        } catch (IOException e) {
            e.printStackTrace();
        }
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
        try {
            Stage stage = (Stage) addAppointment.getScene().getWindow();
            stage.close();
            new AddAppointmentPage().start(stage);
        } catch (IOException e) {
            e.printStackTrace();
        }
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
        /*try {
            Stage stage = (Stage) updateAppointment.getScene().getWindow();
            stage.close();
            new UpdateAppointmentPage().start(stage);
        } catch (IOException e) {
            e.printStackTrace();
        }*/
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
        try {
            Stage stage = (Stage) addUser.getScene().getWindow();
            stage.close();
            new AddUserPage().start(stage);
        } catch (IOException e) {
            e.printStackTrace();
        }
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
