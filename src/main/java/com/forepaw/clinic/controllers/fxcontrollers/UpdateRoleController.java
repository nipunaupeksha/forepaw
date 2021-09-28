package com.forepaw.clinic.controllers.fxcontrollers;

import com.forepaw.clinic.AddRolePage;
import com.forepaw.clinic.DeleteRolePage;
import com.forepaw.clinic.HomePage;
import com.forepaw.clinic.UpdateRolePage;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;

public class UpdateRoleController {
    public ImageView forepawLogo;
    public Label forepawLabel;
    public Label addRoleLabel;
    public Label viewRolesLabel;
    public Label deleteRoleLabel;
    public Label updateRoleLabel;
    public TextArea descriptionText;
    public TextField roleIdText;
    public ComboBox roleNameComboBox;
    public ComboBox priorityComboBox;

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
    protected void addRoleMouseClicked() {
        try {
            Stage stage = (Stage) addRoleLabel.getScene().getWindow();
            stage.close();
            new AddRolePage().start(stage);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    protected void updateRoleMouseClicked() {
        try {
            Stage stage = (Stage) updateRoleLabel.getScene().getWindow();
            stage.close();
            new UpdateRolePage().start(stage);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    protected void viewRolesMouseClicked() {
        //TODO
        /*try {
            Stage stage = (Stage) viewRolesLabel.getScene().getWindow();
            stage.close();
            new ViewRolesPage().start(stage);
        } catch (IOException e) {
            e.printStackTrace();
        }*/
    }

    @FXML
    protected void deleteRoleMouseClicked() {
        try {
            Stage stage = (Stage) deleteRoleLabel.getScene().getWindow();
            stage.close();
            new DeleteRolePage().start(stage);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
