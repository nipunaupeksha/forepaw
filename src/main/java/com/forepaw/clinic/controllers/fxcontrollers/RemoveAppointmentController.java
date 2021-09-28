package com.forepaw.clinic.controllers.fxcontrollers;

import com.forepaw.clinic.AddAppointmentPage;
import com.forepaw.clinic.HomePage;
import com.forepaw.clinic.UpdateRolePage;
import com.forepaw.clinic.controllers.dbcontrollers.AppointmentController;
import com.forepaw.clinic.models.Appointment;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;

public class RemoveAppointmentController {
    public ImageView forepawLogo;
    public Label forepawLabel;
    public Label addAppointmentLabel;
    public Label removeAppointmentLabel;
    public TextField appointmentIdText;
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
    protected void addAppointmentMouseClicked() {
        try {
            Stage stage = (Stage) addAppointmentLabel.getScene().getWindow();
            stage.close();
            new AddAppointmentPage().start(stage);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    protected void removeAppointmentMouseClicked() {
        String appointmentId = appointmentIdText.getText().trim().toLowerCase();
        if (!appointmentId.equals("")) {
            try {
                Appointment appointment = AppointmentController.searchAppointment(appointmentId);
                if(appointment!=null){
                    boolean status = AppointmentController.deleteAppointment(appointmentId);
                    if(status==true){
                        warningLabel.setTextFill(Color.GREEN);
                        warningLabel.setText("Appointment deleted");
                    }else{
                        warningLabel.setTextFill(Color.RED);
                        warningLabel.setText("Could not delete the appointment");
                    }
                }else{
                    warningLabel.setText("No appointments with that id");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        } else {
            warningLabel.setText("appointment id is null");
        }
    }
}
