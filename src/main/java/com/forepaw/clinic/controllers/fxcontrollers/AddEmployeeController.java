package com.forepaw.clinic.controllers.fxcontrollers;

import com.forepaw.clinic.*;
import com.forepaw.clinic.controllers.dbcontrollers.EmployeeController;
import com.forepaw.clinic.controllers.dbcontrollers.RoleController;
import com.forepaw.clinic.methods.VetClinicMethods;
import com.forepaw.clinic.models.Employee;
import com.forepaw.clinic.models.Role;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class AddEmployeeController {

    public Label forepawLabel;
    public Label updateEmployeeLabel;
    public Label viewEmployeesLabel;
    public Label deleteEmployeeLabel;
    public Label addEmployeeButton;
    public TextField firstNameText;
    public TextField lastNameText;
    public TextField phoneText;
    public TextField emailText;
    public TextArea addressText;
    public TextField employeeIdText;
    public ComboBox roleComboBox;
    public ImageView forepawLogo;
    public Label warningLabel;

    @FXML
    public void initialize() {
        String val = VetClinicMethods.getNewId("e", "employee");
        if (val.trim().length()>0) {
            employeeIdText.setText(val);
        } else {
            employeeIdText.setText("e000");
        }
        phoneText.setText("+94");
        try {
            ArrayList<Role>roleList = RoleController.getAllRoles();
            ArrayList<String>roleListNames = new ArrayList<>();
            for(Role role:roleList){
                roleListNames.add(role.getRoleId()+" - "+role.getRoleName());
            }
            roleComboBox.setItems(FXCollections.observableArrayList(roleListNames));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
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
    protected void viewEmployeesMouseClicked() {
        try {
            Stage stage = (Stage) viewEmployeesLabel.getScene().getWindow();
            stage.close();
            new ViewEmployeesPage().start(stage);
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

    @FXML
    protected void addEmployeeMouseClicked() {
        warningLabel.setTextFill(Color.RED);

        String employeeId = employeeIdText.getText().trim();
        String role = (String) roleComboBox.getValue(); //get the selected item from the combobox
        String roleId = role.split("-")[0].trim();
        System.out.println(roleId);
        String firstName = firstNameText.getText().trim();
        String lastName = lastNameText.getText().trim();
        String phone = phoneText.getText().trim();
        String email = emailText.getText().trim();
        String address = addressText.getText().trim();

        if (checkEmail(email) == true) {
            if (roleId.equals("") && firstName.equals("") && lastName.equals("") && phone.equals("")
                    && address.equals("")) {
                warningLabel.setText("Cannot have null claims.");
            } else {
                Employee employee = new Employee(employeeId, roleId, firstName, lastName, phone, email, address);
                try {
                    boolean status = EmployeeController.addEmployee(employee);
                    if (status != true) {
                        warningLabel.setText("Could not add the employee.");
                    } else {
                        warningLabel.setTextFill(Color.GREEN);
                        warningLabel.setText("Employee added.");
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }
        } else {
            warningLabel.setText("Incorrect E-mail");
        }
    }

    //e-mail validation method
    private boolean checkEmail(String source) {
        Pattern p = Pattern.compile("[@][a-zA-Z]+[.][a-zA-Z]{3}");
        Matcher m = p.matcher(source);
        return m.find() ? true : false;
    }

    //TODO - Write Phone Number  Validation
}
