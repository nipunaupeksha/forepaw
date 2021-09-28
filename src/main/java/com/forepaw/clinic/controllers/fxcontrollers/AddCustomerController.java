package com.forepaw.clinic.controllers.fxcontrollers;

import com.forepaw.clinic.DeleteCustomerPage;
import com.forepaw.clinic.HomePage;
import com.forepaw.clinic.UpdateCustomerPage;
import com.forepaw.clinic.ViewCustomersPage;
import com.forepaw.clinic.controllers.dbcontrollers.CustomerController;
import com.forepaw.clinic.models.Customer;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AddCustomerController {
    public ImageView forepawLogo;
    public Label forepawLabel;
    public Label addCustomerLabel;
    public TextField firstNameText;
    public TextField lastNameText;
    public TextField phoneText;
    public TextField emailText;
    public TextArea addressText;
    public TextField customerIdText;
    public Label updateCustomerLabel;
    public Label viewCustomersLabel;
    public Label deleteCustomerLabel;
    public Label warningLabel;

    @FXML
    protected void forepawLogoMouseClicked() {
        try {
            Stage stage = (Stage) forepawLogo.getScene().getWindow();
            stage.close();
            new HomePage().start(stage);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    protected void forepawLabelMouseClicked() {
        try {
            Stage stage = (Stage) forepawLabel.getScene().getWindow();
            stage.close();
            new HomePage().start(stage);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    protected void addCustomerMouseClicked() {
        String customerId = customerIdText.getText().trim().toLowerCase();
        String firstName = firstNameText.getText().trim();
        String lastName = lastNameText.getText().trim();
        String phone = phoneText.getText().trim();
        String email = emailText.getText().trim();
        String address = addressText.getText().trim();

        if(checkEmail(email)==true && !email.equals("")){
            if(!firstName.equals("") && !lastName.equals("") && !phone.equals("") && !email.equals("") && !address.equals("")){
                Customer customer = new Customer(customerId, firstName, lastName, phone, email,address);
                try{
                    boolean status = CustomerController.addCustomer(customer);
                    if(status==true){
                        warningLabel.setTextFill(Color.GREEN);
                        warningLabel.setText("Customer added");
                    }else{
                        warningLabel.setTextFill(Color.RED);
                        warningLabel.setText("Customer could not be added");
                    }
                }catch(SQLException e){e.printStackTrace();}catch(ClassNotFoundException e){e.printStackTrace();}
            }else{
                warningLabel.setText("Invalid claims");
            }
        }else{
            warningLabel.setText("Invalid Email");
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

    //e-mail validation method
    private boolean checkEmail(String source) {
        Pattern p = Pattern.compile("[@][a-zA-Z]+[.][a-zA-Z]{3}");
        Matcher m = p.matcher(source);
        return m.find() ? true : false;
    }
}
