package com.forepaw.clinic.controllers.fxcontrollers;

import com.forepaw.clinic.*;
import com.forepaw.clinic.controllers.dbcontrollers.CustomerController;
import com.forepaw.clinic.models.Customer;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;

public class DeleteCustomerController {
    public ImageView searchLabel;
    public TextField customerIdText;
    public TextArea addressText;
    public TextField emailText;
    public TextField phoneText;
    public TextField lastNameText;
    public TextField firstNameText;
    public Label deleteCustomerLabel;
    public Label viewCustomersLabel;
    public Label updateCustomerLabel;
    public Label addCustomerLabel;
    public Label forepawLabel;
    public ImageView forepawLogo;
    public Label warningLabel;
    public String custId;

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
    protected void addCustomerMouseClicked() {
        try {
            Stage stage = (Stage) addCustomerLabel.getScene().getWindow();
            stage.close();
            new AddCustomerPage().start(stage);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    protected void updateCustomerMouseClicked() {
        try {
            Stage stage = (Stage) updateCustomerLabel.getScene().getWindow();
            stage.close();
            new UpdateCustomerPage().start(stage);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    protected void deleteCustomerMouseClicked() {
        String customerId = customerIdText.getText().trim().toLowerCase();
        try {
            if(custId.equals(customerId)){
                boolean status = CustomerController.deleteCustomer(customerId);
            }else{
                warningLabel.setText("Invalid customer details");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @FXML
    protected void viewCustomersMouseClicked() {
        try {
            Stage stage = (Stage) viewCustomersLabel.getScene().getWindow();
            stage.close();
            new ViewCustomersPage().start(stage);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    protected void searchMouseClicked() {
        String customerId = customerIdText.getText().trim().toLowerCase();
        custId = customerId;
        if (customerId.equals("")) {
            warningLabel.setText("Customer Id is null");
        } else {
            try {
                Customer customer = CustomerController.searchCustomer(customerId);
                if (customer == null) {
                    warningLabel.setText("Customer is not in database");
                } else {
                    firstNameText.setText(customer.getFirstName());
                    lastNameText.setText(customer.getLastName());
                    phoneText.setText(customer.getPhone());
                    emailText.setText(customer.getEmail());
                    addressText.setText(customer.getAddress());
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

}
