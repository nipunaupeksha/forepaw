package com.forepaw.clinic.controllers.fxcontrollers;

import com.forepaw.clinic.DeleteRolePage;
import com.forepaw.clinic.HomePage;
import com.forepaw.clinic.RemoveAppointmentPage;
import com.forepaw.clinic.UpdateRolePage;
import com.forepaw.clinic.controllers.dbcontrollers.RoleController;
import com.forepaw.clinic.models.Role;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Locale;

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
    public Label warningLabel;

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
        String roleId = roleIdText.getText().trim().toLowerCase();
        if (!roleId.equals("")) {
            String name = roleNameText.getText().trim();
            String priority = priorityText.getText().trim();
            String description = descriptionText.getText().trim();
            if (!name.equals("") && !priority.equals("") && !description.equals("")) {
                Role role = new Role(roleId, name, priority, description);
                try {
                    boolean status = RoleController.addRole(role);
                    if (status == true) {
                        warningLabel.setTextFill(Color.GREEN);
                        warningLabel.setText("Role added.");
                    } else {
                        warningLabel.setTextFill(Color.RED);
                        warningLabel.setText("Role could not be added");
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            } else {
                warningLabel.setText("There are null claims");
            }
        } else {
            warningLabel.setText("Role Id is null");
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
