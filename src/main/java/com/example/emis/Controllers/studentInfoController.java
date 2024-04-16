package com.example.emis.Controllers;

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
    private MFXComboBox<?> comboBoxCivilStatus;

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
    private MFXTextField textFieldLastName;

    @FXML
    private MFXTextField textFieldMiddleName;

    @FXML
    private MFXTextField textFieldReligion;

    @FXML
    void btnDeclineOnAction(ActionEvent event) {

    }

    @FXML
    void btnEnrollOnAction(ActionEvent event) {

    }

}
