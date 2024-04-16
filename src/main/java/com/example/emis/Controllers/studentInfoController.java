package com.example.emis.Controllers;

import io.github.palexdev.materialfx.controls.MFXCheckbox;
import io.github.palexdev.materialfx.controls.MFXComboBox;
import io.github.palexdev.materialfx.controls.MFXDatePicker;
import io.github.palexdev.materialfx.controls.MFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

public class studentInfoController {

    @FXML
    private AnchorPane anchorPaneEnrollDeclineButtons;

    @FXML
    private AnchorPane anchorPaneSubmittion;

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
    private MFXTextField textxFieldProvincialAddress;

    @FXML
    void btnClearOnAction(ActionEvent event) {

    }

    @FXML
    void btnDeclineOnAction(ActionEvent event) {

    }

    @FXML
    void btnEnrollOnAction(ActionEvent event) {

    }

    @FXML
    void btnSubmitApplicationOnAction(ActionEvent event) {

    }

}
