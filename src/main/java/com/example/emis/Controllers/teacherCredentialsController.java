package com.example.emis.Controllers;

import com.jfoenix.controls.JFXButton;
import io.github.palexdev.materialfx.controls.MFXTextField;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

import java.net.URL;
import java.util.EventListener;
import java.util.ResourceBundle;

import static com.example.emis.Others.SQL.*;

public class teacherCredentialsController implements Initializable {
    private boolean isRegistration = false;
    private String emailToRegister = "";
    private String passwordToRegister = "";

    @FXML
    private JFXButton btnAddEditTeacherAccount;

    @FXML
    private MFXTextField textFieldTeacherEmail;

    @FXML
    private MFXTextField textFieldTeacherPassword;

    @FXML
    private Label labelRegistration;

    @FXML
    void btnAddEditTeacherAccountOnAction() {
        Platform.runLater(() -> {
            if (!isRegistration) {
                // ia add na sa sql (mula kay mis)
            }

            Stage thisStage = (Stage) btnAddEditTeacherAccount.getScene().getWindow();
            thisStage.close();
        });
    }

    @FXML
    void pressedEnter(KeyEvent event) {
        if (event.getCode() == KeyCode.ENTER)
            btnAddEditTeacherAccountOnAction();
    }

    public void setRegistration(boolean isRegistration, String email, String password) {
        this.isRegistration = isRegistration;
        this.emailToRegister = email;
        this.passwordToRegister = password;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Platform.runLater(() -> {
            if (isRegistration) {
                labelRegistration.setVisible(true);
                
                btnAddEditTeacherAccount.setText("OKAY");

                textFieldTeacherEmail.setText(emailToRegister);
                textFieldTeacherPassword.setText(encryptString(passwordToRegister));

                textFieldTeacherEmail.setEditable(false);
                textFieldTeacherPassword.setEditable(false);
            }
        });
    }
}
