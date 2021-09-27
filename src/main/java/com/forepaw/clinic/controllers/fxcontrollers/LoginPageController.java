package com.forepaw.clinic.controllers.fxcontrollers;

import com.forepaw.clinic.LoginPage;
import com.forepaw.clinic.controllers.dbcontrollers.UserController;
import com.forepaw.clinic.models.User;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.sql.SQLException;

public class LoginPageController {
    @FXML
    private Label loginButton;
    private PasswordField passwordText;
    private TextField usernameText;
    private Label warningLabel;

    @FXML
    protected void onLoginButtonClicked() {
        User user = new User(usernameText.getText(), passwordText.getText());
        try {
            boolean checkUser = UserController.checkUser(user);
            if (checkUser == true) {
                LoginPage.launch();
            } else {
                warningLabel.setText("Invalid credentials.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
