package com.forepaw.clinic.controllers.fxcontrollers;

import com.forepaw.clinic.DeleteRolePage;
import com.forepaw.clinic.HomePage;
import com.forepaw.clinic.RemoveAppointmentPage;
import com.forepaw.clinic.UpdateRolePage;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;

public class AddRoleController {

    public Label addRoleLabel;
    public TextField roleNameText;
    public TextField priorityText;
    public TextArea descriptionText;
    public TextField roleIdText;
    public Label viewRolesLabel;
    public Label updateRoleLabel;
    public Label forepawLabel;
    public ImageView forepawLogo;
    public Label deleteRoleLabel;

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
        //TODO
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
