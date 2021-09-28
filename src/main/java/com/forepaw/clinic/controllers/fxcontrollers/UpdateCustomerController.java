package com.forepaw.clinic.controllers.fxcontrollers;

import com.forepaw.clinic.AddCustomerPage;
import com.forepaw.clinic.DeleteCustomerPage;
import com.forepaw.clinic.HomePage;
import com.forepaw.clinic.ViewCustomersPage;
import com.forepaw.clinic.controllers.dbcontrollers.CustomerController;
import com.forepaw.clinic.models.Customer;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UpdateCustomerController {
    public ImageView forepawLogo;
    public Label forepawLabel;
    public Label addCustomerLabel;
    public Label viewCustomersLabel;
    public Label deleteCustomerLabel;
    public Label updateCustomerLabel;
    public TextField firstNameText;
    public TextField lastNameText;
    public TextField phoneText;
    public TextField emailText;
    public TextArea addressText;
    public TextField customerIdText;
    public Label warningLabel;
    public ImageView searchLabel;
    public String custId;

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
        String customerId = customerIdText.getText().trim().toLowerCase();
        if (customerId.equals(custId)) {
            String firstName = firstNameText.getText().trim();
            String lastName = lastNameText.getText().trim();
            String phone = phoneText.getText().trim();
            String email = emailText.getText().trim();
            String address = addressText.getText().trim();
            if (checkEmail(email) == true && !email.equals("")) {
                if (!firstName.equals("") && !lastName.equals("") && !phone.equals("") && !address.equals("")) {
                    Customer customer = new Customer(customerId, firstName, lastName, phone, email, address);
                    try {
                        boolean status = CustomerController.updateCustomer(customer);
                        if (status == true) {
                            warningLabel.setTextFill(Color.GREEN);
                            warningLabel.setText("Customer updated");
                            customerIdText.setText("");
                            firstNameText.setText("");
                            lastNameText.setText("");
                            phoneText.setText("+94");
                            emailText.setText("");
                            addressText.setText("");
                        } else {
                            warningLabel.setTextFill(Color.RED);
                            warningLabel.setText("Customer could not be updated");
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
        } else {
            warningLabel.setText("Customer Id violation");
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
    protected void deleteCustomerMouseClicked() {
        try {
            Stage stage = (Stage) deleteCustomerLabel.getScene().getWindow();
            stage.close();
            new DeleteCustomerPage().start(stage);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    protected void searchMouseClicked() {
        String customerId = customerIdText.getText().trim().toLowerCase();
        if (customerId.equals("")) {
            warningLabel.setText("Customer ID is null");
        } else {
            custId = customerId;
            try {
                Customer customer = CustomerController.searchCustomer(customerId);
                if (customer == null) {
                    warningLabel.setText("Customer doesn't exist");
                } else {
                    firstNameText.setText(customer.getFirstName());
                    lastNameText.setText(customer.getLastName());
                    phoneText.setText(customer.getPhone());
                    emailText.setText(customer.getEmail());
                    addressText.setText(customer.getAddress());

                    warningLabel.setText("");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    //e-mail validation method
    private boolean checkEmail(String source) {
        Pattern p = Pattern.compile("[@][a-zA-Z]+[.][a-zA-Z]{3}");
        Matcher m = p.matcher(source);
        return m.find() ? true : false;
    }
}
