package com.forepaw.clinic.controllers.fxcontrollers;

import com.forepaw.clinic.HomePage;
import com.forepaw.clinic.controllers.dbcontrollers.UserController;
import com.forepaw.clinic.models.User;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;

public class AddUserController {

    public PasswordField retypePasswordText;
    public PasswordField passwordText;
    public TextField userIdText;
    public TextField usernameText;
    public Label addUserLabel;
    public Label deleteUserLabel;
    public ImageView forepawLogo;
    public Label forepawLabel;
    public Label updateUserLabel;
    public Label viewUsersLabel;
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
    protected void addUserMouseClicked() {
        warningLabel.setTextFill(Color.RED); //set warning label color first

        String userId = userIdText.getText();
        String password = passwordText.getText().trim();
        String retypePassword = retypePasswordText.getText().trim();

        if(!password.equals(retypePassword) || password.equals("")){
            warningLabel.setText("Password error.");
        }else{
            String username = usernameText.getText().trim();
            try {
                boolean checkValidity = UserController.checkValidity(username);
                if(checkValidity != true || username.equals("")){
                    warningLabel.setText("Username error.");
                }else{
                    User user = new User(userId, username, password);
                    boolean status = UserController.addUser(user);
                    if(status==true){
                        warningLabel.setTextFill(Color.GREEN);
                        warningLabel.setText("User added.");
                    }else{
                        warningLabel.setText("User not added.");
                    }
                }
            }catch(SQLException e){
                e.printStackTrace();
            }catch(ClassNotFoundException e){
                e.printStackTrace();
            }
        }
    }

    @FXML
    protected void updateUserMouseClicked() {
        /*try {
            Stage stage = (Stage) updateUserLabel.getScene().getWindow();
            stage.close();
            new UpdateUserPage().start(stage);
        } catch (IOException e) {
            e.printStackTrace();
        }*/
    }

    @FXML
    protected void viewUsersMouseClicked() {
        /*try {
            Stage stage = (Stage) viewUsersLabel.getScene().getWindow();
            stage.close();
            new ViewUsersPage().start(stage);
        } catch (IOException e) {
            e.printStackTrace();
        }*/
    }

    @FXML
    protected void deleteUserMouseClicked() {
        /*try {
            Stage stage = (Stage) deleteUserLabel.getScene().getWindow();
            stage.close();
            new DeleteUserPage().start(stage);
        } catch (IOException e) {
            e.printStackTrace();
        }*/
    }

}
