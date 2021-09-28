package com.forepaw.clinic.controllers.fxcontrollers;

import com.forepaw.clinic.AddCustomerPage;
import com.forepaw.clinic.DeleteCustomerPage;
import com.forepaw.clinic.HomePage;
import com.forepaw.clinic.UpdateCustomerPage;
import com.forepaw.clinic.controllers.dbcontrollers.CustomerController;
import com.forepaw.clinic.models.Customer;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public class ViewCustomersController {
    public ImageView forepawLogo;
    public Label addCustomerLabel;
    public Label forepawLabel;
    public Label updateCustomerLabel;
    public Label deleteCustomerLabel;
    public TableView customerTable;

    @FXML
    public void initialize() {
        try {
            ArrayList<Customer>customers = CustomerController.getAllCustomers();
            for(Customer customer:customers){
                Object obj[] = {customer.getCustomerId(), customer.getFirstName()+" "+customer.getLastName(),customer.getEmail(),
                        customer.getPhone(), customer.getAddress()};
                customerTable.getItems().add(obj);
            }
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
        try {
            Stage stage = (Stage) deleteCustomerLabel.getScene().getWindow();
            stage.close();
            new DeleteCustomerPage().start(stage);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
