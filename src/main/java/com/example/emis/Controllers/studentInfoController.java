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
import javafx.scene.layout.HBox;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

import static com.example.emis.Others.Alerts.*;

public class studentInfoController implements Initializable {
    private boolean isRegistration = false;
    private boolean isRegistered = false;
    private String emailUsing = "";

    @FXML
    private HBox hBoxMain;

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
    private MFXComboBox<String> comboBoxCivilStatus;

    @FXML
    private MFXComboBox<String> comboBoxFirstChoice;

    @FXML
    private MFXComboBox<String> comboBoxSecondChoice;

    @FXML
    private MFXComboBox<String> comboBoxSex;

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
    private MFXTextField textFieldElemSchool;

    @FXML
    private MFXTextField textFieldElemSchoolAddress;

    @FXML
    private MFXTextField textFieldElemSchoolSY;

    @FXML
    private MFXTextField textFieldJuniorHS;

    @FXML
    private MFXTextField textFieldJuniorHSAddress;

    @FXML
    private MFXTextField textFieldJuniorHSSY;

    @FXML
    void hBoxMainRequestFocus() {
        hBoxMain.requestFocus();
    }

    @FXML
    void btnClearOnAction() {
        if (alertConfirmClearFieldsRegistration()) {
            textFieldLastName.setText("");
            textFieldFirstName.setText("");
            textFieldMiddleName.setText("");
            datePickerDateOfBirth.setValue(null);
            textFieldAge.setText("");
            comboBoxSex.setValue("SELECT SEX");
            comboBoxCivilStatus.setValue("SELECT CIVIL STATUS");
            textFieldReligion.setText("");
            textFieldCitizenShip.setText("");
            textFieldContactNumber.setText("");
            textFieldEmailAddress.setText(emailUsing);
            textFieldHomeAddress.setText("");
            textFieldProvincialAddress.setText("");
            comboBoxFirstChoice.setValue("SELECT FIRST CHOICE");
            comboBoxSecondChoice.setValue("SELECT SECOND CHOICE");
            textFieldElemSchool.setText("");
            textFieldElemSchoolAddress.setText("");
            textFieldElemSchoolSY.setText("");
            textFieldJuniorHS.setText("");
            textFieldJuniorHSAddress.setText("");
            textFieldJuniorHSSY.setText("");
            checkBoxForm137.setSelected(false);
            checkBoxForm138.setSelected(false);
            checkBoxGoodMoral.setSelected(false);
        }
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
                hBoxMainRequestFocus();
                hideRegisterDoneElements();
                setComboBoxesValue();
                setListenerForRegistration();
            } else {
                // registered na
            }

            textFieldEmailAddress.setEditable(false);
        });
    }

    private void setComboBoxesValue() {

    }


    private void setListenerForRegistration() {

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
