package com.example.emis.Controllers;

import io.github.palexdev.materialfx.controls.MFXCheckbox;
import io.github.palexdev.materialfx.controls.MFXComboBox;
import io.github.palexdev.materialfx.controls.MFXDatePicker;
import io.github.palexdev.materialfx.controls.MFXTextField;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;

public class studentInfoController implements Initializable {
    private boolean isRegistration = false;
    private boolean isRegistered = false;
    private String emailUsing = "";

    @FXML
    private AnchorPane anchorPaneEnrollDeclineButtons;

    @FXML
    private AnchorPane anchorPaneSubmit;

    @FXML
    private MFXCheckbox checkBoxForm137;

    @FXML
    private MFXCheckbox checkBoxForm138;

    @FXML
    private MFXCheckbox checkBoxGoodMoral;

    @FXML
    private MFXComboBox<?> comboBoxCivilStatus;

    @FXML
    private MFXComboBox<?> comboBoxFirstChoice;

    @FXML
    private MFXComboBox<?> comboBoxSecondChoice;

    @FXML
    private MFXComboBox<?> comboBoxSex;

    @FXML
    private MFXDatePicker datePickerDateOfBirth;

    @FXML
    private Label labelStatus;

    @FXML
    private MFXTextField textFieldAge;

    @FXML
    private MFXTextField textFieldCitizenShip;

    @FXML
    private MFXTextField textFieldContactNumber;

    @FXML
    private MFXTextField textFieldEmailAddress;

    @FXML
    private MFXTextField textFieldFirstName;

    @FXML
    private MFXTextField textFieldHomeAddress;

    @FXML
    private MFXTextField textFieldLastName;

    @FXML
    private MFXTextField textFieldMiddleName;

    @FXML
    private MFXTextField textFieldReligion;

    @FXML
    private MFXTextField textFieldProvincialAddress;

    @FXML
    void btnClearOnAction() {

    }

    @FXML
    void btnDeclineOnAction() {

    }

    @FXML
    void btnEnrollOnAction() {

    }

    @FXML
    void btnSubmitApplicationOnAction() {

    }

    public void setRegistrationAndEmail(boolean isRegistration, String emailUsing) {
        this.isRegistration = isRegistration;
        this.emailUsing = emailUsing;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Platform.runLater(() -> {
            if (isRegistration) {
                hideRegisterDoneElements();
            }
        });
    }

    private void hideRegisterDoneElements() {
        anchorPaneEnrollDeclineButtons.setVisible(false);
        labelStatus.setVisible(false);
        anchorPaneSubmit.setVisible(true);
    }

    private void showRegisterDoneElements() {
        anchorPaneEnrollDeclineButtons.setVisible(true);
        labelStatus.setVisible(true);
        anchorPaneSubmit.setVisible(false);
    }
}
