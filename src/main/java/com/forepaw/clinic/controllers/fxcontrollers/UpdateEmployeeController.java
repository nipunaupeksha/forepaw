package com.forepaw.clinic.controllers.fxcontrollers;

import com.forepaw.clinic.*;
import com.forepaw.clinic.controllers.dbcontrollers.EmployeeController;
import com.forepaw.clinic.controllers.dbcontrollers.RoleController;
import com.forepaw.clinic.models.Employee;
import com.forepaw.clinic.models.Role;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UpdateEmployeeController {
    public ComboBox roleComboBox;
    public TextField employeeIdText;
    public TextArea addressText;
    public TextField emailText;
    public TextField phoneText;
    public TextField lastNameText;
    public TextField firstNameText;
    public Label updateEmployeeLabel;
    public Label forepawLabel;
    public ImageView forepawLogo;
    public Label addEmployeeLabel;
    public Label viewEmployeesLabel;
    public Label deleteEmployeeLabel;
    public Label warningLabel;
    public String empId;
    public ImageView searchLabel;

    @FXML
    public void initialize(){
        phoneText.setText("+94");
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
    protected void searchMouseClicked() {
        String employeeId = employeeIdText.getText().trim().toLowerCase();
        if (employeeId.equals("")) {
            warningLabel.setTextFill(Color.RED);
            warningLabel.setText("Employee Id is null");
        } else {
            try {
                Employee employee = EmployeeController.searchEmployee(employeeId);
                if (employee != null) {
                    ArrayList<Role> roleList = RoleController.getAllRoles();
                    if (roleList != null) {
                        String roleId = employee.getRoleId();
                        Role employeeRole = RoleController.searchRole(roleId);
                        int increment = 0;
                        for (Role role : roleList) {
                            if (role.getRoleId().equals(roleId)) {
                                if (increment != 0) {
                                    //swap the first role to be the role added during add empolyee
                                    Role temporaryRole = roleList.get(0);
                                    roleList.set(0, role);
                                    roleList.set(increment, temporaryRole);
                                }
                            }
                            increment++;
                        }

                        List<String> comboRolesList = new ArrayList<>();
                        for (Role role : roleList) {
                            comboRolesList.add(role.getRoleId() + " - " + role.getRoleName());
                        }
                        empId = employeeId;
                        firstNameText.setText(employee.getFirstName());
                        lastNameText.setText(employee.getLastName());
                        phoneText.setText(employee.getPhone());
                        emailText.setText(employee.getEmail());
                        addressText.setText(employee.getAddress());
                        roleComboBox.setItems(FXCollections.observableArrayList(comboRolesList));
                    } else {
                        warningLabel.setText("Roles cannot be fetched");
                    }
                } else {
                    warningLabel.setText("The user does not exist.");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
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
        String employeeId = employeeIdText.getText().trim().toLowerCase();
        if (empId.trim().equals("") || !empId.trim().equals(employeeId)) {
            warningLabel.setText("Employee ID mismatch.");
        } else {
            String firstName = firstNameText.getText().trim();
            String lastName = lastNameText.getText().trim();
            String email = emailText.getText().trim();
            String phone = phoneText.getText().trim();
            String address = addressText.getText().trim();
            String role = (String) roleComboBox.getValue(); //get the selected item from the combobox
            String roleId = role.split("-")[0].trim();
            if (checkEmail(email) != false || !email.equals("")) {
                if (!roleId.equals("") && !firstName.equals("") && !lastName.equals("") && !phone.equals("")
                        && !address.equals("")) {
                    Employee employee = new Employee(employeeId, roleId, firstName, lastName, phone, email, address);
                    try {
                        boolean status = EmployeeController.updateEmployee(employee);
                        if(status==true){
                            warningLabel.setTextFill(Color.GREEN);
                            warningLabel.setText("Employee updated.");
                            employeeIdText.setText("");
                            firstNameText.setText("");
                            lastNameText.setText("");
                            emailText.setText("");
                            phoneText.setText("+94");
                            addressText.setText("");
                        }else{
                            warningLabel.setTextFill(Color.RED);
                            warningLabel.setText("Employee not updated.");
                        }
                    } catch (SQLException e) {
                        e.printStackTrace();
                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                    }
                }
            } else {
                warningLabel.setText("Invalid email");
            }
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

    //e-mail validation method
    private boolean checkEmail(String source) {
        Pattern p = Pattern.compile("[@][a-zA-Z]+[.][a-zA-Z]{3}");
        Matcher m = p.matcher(source);
        return m.find() ? true : false;
    }
}
