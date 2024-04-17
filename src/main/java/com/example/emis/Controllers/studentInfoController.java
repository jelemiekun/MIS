package com.example.emis.Controllers;

import com.example.emis.Objects.Student;
import io.github.palexdev.materialfx.controls.MFXCheckbox;
import io.github.palexdev.materialfx.controls.MFXComboBox;
import io.github.palexdev.materialfx.controls.MFXDatePicker;
import io.github.palexdev.materialfx.controls.MFXTextField;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;

import java.net.URL;
import java.time.LocalDate;
import java.util.Objects;
import java.util.ResourceBundle;

import static com.example.emis.Others.Alerts.*;
import static com.example.emis.Others.SQL.*;

public class studentInfoController implements Initializable {
    private boolean isRegistration = false;
    private boolean isRegistered = false;
    private String emailUsing = "";
    private String fullName = "";
    private boolean comboBoxesClickable = false;

    @FXML
    private HBox hBoxMain;

    @FXML
    private FlowPane flowPane;

    @FXML
    private AnchorPane anchorPaneEnrollDeclineButtons;

    @FXML
    private AnchorPane anchorPaneSubmit;

    @FXML
    private Label labelStatus;

    @FXML
    private Label labelGuide;

    @FXML
    private MFXCheckbox checkBoxForm137;

    @FXML
    private MFXCheckbox checkBoxForm138;

    @FXML
    private MFXCheckbox checkBoxGoodMoral;

    @FXML
    private MFXDatePicker datePickerDateOfBirth;

    @FXML
    private MFXComboBox<String> comboBoxCivilStatus;

    @FXML
    private MFXComboBox<String> comboBoxFirstChoice;

    @FXML
    private MFXComboBox<String> comboBoxSecondChoice;

    @FXML
    private MFXComboBox<String> comboBoxSex;

    @FXML
    private MFXTextField textFieldAge;

    @FXML
    private MFXTextField textFieldCitizenShip;

    @FXML
    private MFXTextField textFieldLRN;

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
    void btnSubmitApplicationOnAction() {
        try {
            String LRN = textFieldLRN.getText().trim();
            String lastName = textFieldLastName.getText().trim();
            String firstName = textFieldFirstName.getText().trim();
            String middleName = textFieldMiddleName.getText().trim();
            LocalDate birthdate = datePickerDateOfBirth.getValue();
            int age = Integer.parseInt(textFieldAge.getText().trim());
            String sex = comboBoxSex.getValue();
            String civilStatus = comboBoxCivilStatus.getValue();
            String religion = textFieldReligion.getText().trim();
            String citizenship = textFieldCitizenShip.getText().trim();
            String phone = textFieldContactNumber.getText().trim();
            String homeAddress = textFieldHomeAddress.getText().trim();
            String provincialAddress = textFieldProvincialAddress.getText().trim();
            String firstChoice = comboBoxFirstChoice.getValue();
            String secondChoice = comboBoxSecondChoice.getValue();
            String elemSchool = textFieldElemSchool.getText().trim();
            String elemSchoolAddress = textFieldElemSchoolAddress.getText().trim();
            String elemSchoolSY = textFieldElemSchoolSY.getText().trim();
            String juniorHS = textFieldJuniorHS.getText().trim();
            String juniorHSAddress = textFieldJuniorHSAddress.getText().trim();
            String juniorHSSY = textFieldJuniorHSSY.getText().trim();
            boolean form137 = checkBoxForm137.isSelected();
            boolean form138 = checkBoxForm138.isSelected();
            boolean goodMoral = checkBoxGoodMoral.isSelected();
            String documentStatus = (form137 && form138 && goodMoral) ? "Complete" : "Incomplete";

            if (LRN.matches("\\d*")) {
                if (LRN.isEmpty() || lastName.isEmpty() || firstName.isEmpty() || middleName.isEmpty() ||
                        String.valueOf(birthdate).isEmpty() || textFieldAge.getText().trim().isEmpty() || sex.equals("SELECT SEX") ||
                        civilStatus.equals("SELECT CIVIL STATUS") || religion.isEmpty() || citizenship.isEmpty() || phone.isEmpty() ||
                        homeAddress.isEmpty() || provincialAddress.isEmpty() || firstChoice.equals("SELECT FIRST CHOICE") || secondChoice.equals("SELECT SECOND CHOICE") ||
                        elemSchool.isEmpty() || elemSchoolAddress.isEmpty() || elemSchoolSY.isEmpty() || juniorHS.isEmpty() ||
                        juniorHSAddress.isEmpty() || juniorHSSY.isEmpty()) {
                    alertSomeFieldsAreBlank();
                } else {
                    if (alertSubmitApplication()) {
                        String[] data = {LRN, lastName, firstName, middleName, String.valueOf(birthdate), String.valueOf(age),
                                sex, civilStatus, religion, citizenship, phone,
                                homeAddress, provincialAddress,
                                firstChoice, secondChoice,
                                elemSchool, elemSchoolAddress, elemSchoolSY,
                                juniorHS, juniorHSAddress, juniorHSSY,
                                documentStatus, String.valueOf(form137), String.valueOf(form138), String.valueOf(goodMoral)};
                        if (SQLSubmitApplication(emailUsing, data)) {
                            alertApplicationSubmitted();
                            setSubmitted(true);
                        } else {
                            alertUnexpectedError();
                        }
                    }
                }
            } else {
                alertInvalidLRN();
            }
        } catch (Exception e) {
            alertInvalidAge();
        }
    }

    private void setSubmitted(boolean disableCheckboxes) {
        disableFields();
        flowPane.getChildren().remove(anchorPaneSubmit);
        labelStatus.setText("SUBMITTED");
        labelStatus.setStyle("-fx-text-fill: black;");

        if (disableCheckboxes)
            disableCheckBoxes();
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
            textFieldLRN.setText("");
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

    private void setComboBoxesValue() {
        comboBoxesClickable = true;

        ObservableList<String> observableListSex = FXCollections.observableArrayList(
                "SELECT SEX", "MALE", "FEMALE"
        );
        ObservableList<String> observableListCivilStatus = FXCollections.observableArrayList(
                "SELECT CIVIL STATUS", "MARRIED", "WIDOWED", "SEPARATED", "DIVORCED", "SINGLE"
        );
        ObservableList<String> observableListFirstChoice = FXCollections.observableArrayList("SELECT FIRST CHOICE");
        ObservableList<String> observableListSecondChoice = FXCollections.observableArrayList("SELECT SECOND CHOICE");

        ObservableList<String> observableListStrandAvailable = FXCollections.observableArrayList();
        if (SQLGetStrands() != null) {
            observableListStrandAvailable.addAll(Objects.requireNonNull(SQLGetStrands()));
        } else {
            alertUnexpectedError();
        }

        observableListFirstChoice.addAll(observableListStrandAvailable);
        observableListSecondChoice.addAll(observableListStrandAvailable);

        comboBoxSex.setItems(observableListSex);
        comboBoxCivilStatus.setItems(observableListCivilStatus);
        comboBoxFirstChoice.setItems(observableListFirstChoice);
        comboBoxSecondChoice.setItems(observableListSecondChoice);

        comboBoxSex.setValue("SELECT SEX");
        comboBoxCivilStatus.setValue("SELECT CIVIL STATUS");
        comboBoxFirstChoice.setValue("SELECT FIRST CHOICE");
        comboBoxSecondChoice.setValue("SELECT SECOND CHOICE");
    }

    private void disableFields() {
        comboBoxCivilStatus.setDisable(true);
        comboBoxFirstChoice.setDisable(true);
        comboBoxSecondChoice.setDisable(true);
        comboBoxSex.setDisable(true);
        datePickerDateOfBirth.setDisable(true);
        textFieldAge.setDisable(true);
        textFieldCitizenShip.setDisable(true);
        textFieldLRN.setDisable(true);
        textFieldContactNumber.setDisable(true);
        textFieldEmailAddress.setDisable(true);
        textFieldFirstName.setDisable(true);
        textFieldHomeAddress.setDisable(true);
        textFieldLastName.setDisable(true);
        textFieldMiddleName.setDisable(true);
        textFieldReligion.setDisable(true);
        textFieldProvincialAddress.setDisable(true);
        textFieldElemSchool.setDisable(true);
        textFieldElemSchoolAddress.setDisable(true);
        textFieldElemSchoolSY.setDisable(true);
        textFieldJuniorHS.setDisable(true);
        textFieldJuniorHSAddress.setDisable(true);
        textFieldJuniorHSSY.setDisable(true);
        comboBoxCivilStatus.setDisable(true);
        comboBoxSex.setDisable(true);
        comboBoxFirstChoice.setDisable(true);
        comboBoxSecondChoice.setDisable(true);
    }

    private void setSubmittedValues() {
        Student student = SQLGetStudentData(emailUsing);

        if (student != null) {
            textFieldLRN.setText(student.getLRN());
            textFieldLastName.setText(student.getLastName());
            textFieldFirstName.setText(student.getFirstName());
            textFieldMiddleName.setText(student.getMiddleName());
            datePickerDateOfBirth.setValue(student.getBirthdate());
            textFieldAge.setText(String.valueOf(student.getAge()));
            comboBoxSex.setValue(student.getSex());
            comboBoxCivilStatus.setValue(student.getCivilStatus());
            textFieldReligion.setText(student.getReligion());
            textFieldCitizenShip.setText(student.getCitizenship());
            textFieldContactNumber.setText(student.getPhone());
            textFieldHomeAddress.setText(student.getHomeAddress());
            textFieldProvincialAddress.setText(student.getProvincialAddress());
            comboBoxFirstChoice.setValue(student.getFirstChoice());
            comboBoxSecondChoice.setValue(student.getSecondChoice());
            textFieldElemSchool.setText(student.getElemSchool());
            textFieldElemSchoolAddress.setText(student.getElemSchoolAddress());
            textFieldElemSchoolSY.setText(student.getElemSchoolSY());
            textFieldJuniorHS.setText(student.getJuniorHS());
            textFieldJuniorHSAddress.setText(student.getJuniorHSAddress());
            textFieldJuniorHSSY.setText(student.getJuniorHSSY());

            // Set checkbox values
            checkBoxForm137.setSelected(student.isForm137());
            checkBoxForm138.setSelected(student.isForm138());
            checkBoxGoodMoral.setSelected(student.isGoodMoral());

            fullName = student.getFullName();
        } else {
            alertUnexpectedError();
        }
    }


    private void disableCheckBoxes() {
        checkBoxForm137.setDisable(true);
        checkBoxForm138.setDisable(true);
        checkBoxGoodMoral.setDisable(true);
    }



    private void hideRegisterDoneElements() {
        anchorPaneEnrollDeclineButtons.setVisible(false);
        anchorPaneSubmit.setVisible(true);
    }

    private void labelSetApplicationProcessed(boolean isEnrolled) {
        disableCheckBoxes();
        anchorPaneEnrollDeclineButtons.setVisible(false);
        labelStatus.setText(isEnrolled ? "ENROLLED" : "DECLINED");
        labelStatus.setStyle(isEnrolled ? "-fx-text-fill: #00e813;" : "-fx-text-fill: #ff0000;" );
    }

    @FXML
    void hBoxMainRequestFocus() {
        hBoxMain.requestFocus();
    }

    @FXML
    void sexClicked() {
        if (comboBoxesClickable)
            comboBoxSex.show();
        else
            comboBoxSex.hide();
    }

    @FXML
    void civilStatusClicked() {
        if (comboBoxesClickable)
            comboBoxCivilStatus.show();
        else
            comboBoxCivilStatus.hide();
    }

    @FXML
    void firstChoiceClicked() {
        if (comboBoxesClickable)
            comboBoxFirstChoice.show();
        else
            comboBoxFirstChoice.hide();
    }

    @FXML
    void secondChoiceClicked() {
        if (comboBoxesClickable)
            comboBoxSecondChoice.show();
        else
            comboBoxSecondChoice.hide();
    }

    @FXML
    void btnEnrollOnAction() {
        if (alertConfirmEnroll(fullName)) {
            if (SQLAcceptStudentApplication(emailUsing)) {
                labelSetApplicationProcessed(true);
            } else {
                alertUnexpectedError();
            }
        }
    }

    @FXML
    void btnDeclineOnAction() {
        if (alertConfirmDecline(fullName)) {
            if (SQLDeclineStudentApplication(emailUsing)) {
                labelSetApplicationProcessed(false);
            } else {
                alertUnexpectedError();
            }
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Platform.runLater(() -> {
            if (isRegistration) {
                setRegistration();
            } else {
                setNotRegistration();
            }

            setEmailField();
        });
    }

    private void setRegistration() {
        anchorPaneEnrollDeclineButtons.setVisible(false);
        if (!SQLIsApplied(emailUsing)) {
            hBoxMainRequestFocus();
            hideRegisterDoneElements();
            setComboBoxesValue();
            textFieldEmailAddress.setDisable(true);
        } else {
            setSubmittedValues();
            setSubmitted(true);
        }
    }

    private void setNotRegistration() {
        updateGUISetNotRegistration();

        boolean[] getProcessedAndEnrolledBoolean = SQLGetProcessedAndEnrolledBoolean(emailUsing);

        if (getProcessedAndEnrolledBoolean != null) {
            boolean processed = getProcessedAndEnrolledBoolean[0];
            boolean enrolled = getProcessedAndEnrolledBoolean[1];

            if (!processed) {
                anchorPaneEnrollDeclineButtons.setVisible(true);
            } else {
                if (enrolled) {
                    labelSetApplicationProcessed(true);
                } else {
                    labelSetApplicationProcessed(false);
                }
            }
        } else {
            alertUnexpectedError();
        }
    }

    private void updateGUISetNotRegistration() {
        labelGuide.setVisible(false);
        flowPane.getChildren().remove(anchorPaneSubmit);
        setSubmittedValues();
        setSubmitted(false);
    }

    public void setRegistrationAndEmail(boolean isRegistration, String emailUsing) {
        this.isRegistration = isRegistration;
        this.emailUsing = emailUsing;
    }

    private void setEmailField() {
        textFieldEmailAddress.setText(emailUsing);
        textFieldEmailAddress.setEditable(false);
    }

}
