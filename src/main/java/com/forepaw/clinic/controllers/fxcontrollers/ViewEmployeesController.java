package com.forepaw.clinic.controllers.fxcontrollers;

import com.forepaw.clinic.AddEmployeePage;
import com.forepaw.clinic.DeleteEmployeePage;
import com.forepaw.clinic.HomePage;
import com.forepaw.clinic.UpdateEmployeePage;
import com.forepaw.clinic.controllers.dbcontrollers.CustomerController;
import com.forepaw.clinic.controllers.dbcontrollers.EmployeeController;
import com.forepaw.clinic.models.Customer;
import com.forepaw.clinic.models.Employee;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;

public class ViewEmployeesController {
    public ImageView forepawLogo;
    public Label forepawLabel;
    public Label addEmployeeLabel;
    public Label updateEmployeeLabel;
    public Label deleteEmployeeLabel;
    public TableView employeeTable;

    @FXML
    private TableColumn<Employee, String>col_eid;
    @FXML
    private TableColumn<Employee, String>col_name;
    @FXML
    private TableColumn<Employee, String>col_role;
    @FXML
    private TableColumn<Employee, String>col_phone;
    @FXML
    private TableColumn<Employee, String>col_email;
    @FXML
    private TableColumn<Employee, String>col_address;

    public void initCols(){
        col_eid.setCellValueFactory(new PropertyValueFactory<Employee,String>("employeeId"));
        col_name.setCellValueFactory(new PropertyValueFactory<Employee,String>("firstName"));
        col_role.setCellValueFactory(new PropertyValueFactory<Employee,String>("roleId"));
        col_phone.setCellValueFactory(new PropertyValueFactory<Employee,String>("phone"));
        col_email.setCellValueFactory(new PropertyValueFactory<Employee,String>("email"));
        col_address.setCellValueFactory(new PropertyValueFactory<Employee,String>("address"));
    }

    public void initialize() {
        try {
            initCols();
            ArrayList<Employee> employees = EmployeeController.getAllEmployees();
            employeeTable.getItems().add(FXCollections.observableArrayList(employees));
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @FXML
    protected void forepawLabelClicked() {
        try {
            Stage stage = (Stage) forepawLabel.getScene().getWindow();
            stage.close();
            new HomePage().start(stage);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    protected void forepawLogoClicked() {
        try {
            Stage stage = (Stage) forepawLogo.getScene().getWindow();
            stage.close();
            new HomePage().start(stage);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    protected void addEmployeeMouseClicked() {
        try {
            Stage stage = (Stage) addEmployeeLabel.getScene().getWindow();
            stage.close();
            new AddEmployeePage().start(stage);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    protected void updateEmployeeMouseClicked() {
        try {
            Stage stage = (Stage) updateEmployeeLabel.getScene().getWindow();
            stage.close();
            new UpdateEmployeePage().start(stage);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    protected void deleteEmployeeMouseClicked() {
        try {
            Stage stage = (Stage) deleteEmployeeLabel.getScene().getWindow();
            stage.close();
            new DeleteEmployeePage().start(stage);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
