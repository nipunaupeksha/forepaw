package com.forepaw.clinic.controllers.fxcontrollers;

import com.forepaw.clinic.LoginPage;
import com.forepaw.clinic.controllers.dbcontrollers.UserController;
import com.forepaw.clinic.models.User;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;

public class LoginPageController {
    public Label loginButton;
    public PasswordField passwordText;
    public TextField usernameText;
    public Label warningLabel;

    @FXML
    protected void onLoginButtonClicked() {
        if (usernameText.getText().trim().equals("") || passwordText.getText().trim().equals("")) {
            warningLabel.setText("Fill the empty fields.");
        } else {
            User user = new User(usernameText.getText(), passwordText.getText());
            try {
                boolean checkUser = UserController.checkUser(user);
                if (checkUser == true) {
                    Stage stage = (Stage) loginButton.getScene().getWindow();
                    stage.close();
                    new LoginPage().start(stage);
                } else {
                    warningLabel.setText("Invalid credentials.");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
