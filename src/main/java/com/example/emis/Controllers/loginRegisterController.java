package com.example.emis.Controllers;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

import static com.example.emis.Others.Alerts.*;
import static com.example.emis.Enums.ImagesEnum.*;
import static com.example.emis.Others.SQL.*;
import static com.example.emis.Enums.ScenesEnum.*;

public class loginRegisterController implements Initializable {

    private boolean createAnAccountAs = false;
    private boolean toggleLoginPassword = false;
    private boolean toggleRegisterNewPassword = false;
    private boolean toggleRegisterConfirmNewPassword = false;

    @FXML
    private AnchorPane anchorPane;

    @FXML
    private AnchorPane anchorPaneRegister;

    @FXML
    private AnchorPane anchorPaneLogin;

    @FXML
    private JFXButton btnRegisterAccount;

    @FXML
    private Label labelCreateAnAccountAs;

    @FXML
    private PasswordField passwordFieldLoginPassword;

    @FXML
    private TextField textFieldRegisterShowConfirmNewPassword;

    @FXML
    private PasswordField passwordFieldRegisterNewPassword;

    @FXML
    private TextField textFieldRegisterShowNewPassword;

    @FXML
    private PasswordField passwordFieldConfirmNewPassword;

    @FXML
    private TextField textFieldLoginEmail;

    @FXML
    private TextField textFieldLoginPassword;

    @FXML
    private TextField textFieldRegisterEmail;

    @FXML
    private ImageView imageToggleLoginPassword;

    @FXML
    private ImageView toggleConfirmNewPassword;

    @FXML
    private ImageView toggleNewPassword;

    @FXML
    private JFXCheckBox checkBoxTermsAndConditions;

    @FXML
    void anchorPaneRequestFocus() {
        anchorPane.requestFocus();
    }

    @FXML
    void createAccountToggleStudentTeacherClicked() {
        createAnAccountAs = !createAnAccountAs;

        labelCreateAnAccountAs.setText("Create an account as " + (createAnAccountAs ? "student" : "teacher"));
    }

    @FXML
    void createAnAccountClicked() {
        anchorPaneLogin.setVisible(false);
        anchorPaneRegister.setVisible(true);
        clearFields();
    }

    @FXML
    void loginAccountClicked() {
        anchorPaneLogin.setVisible(true);
        anchorPaneRegister.setVisible(false);
        clearFields();
    }

    @FXML
    void logInOnAction() throws IOException {
        String email = textFieldLoginEmail.getText().trim();
        String password = toggleLoginPassword ? textFieldLoginPassword.getText().trim() : passwordFieldLoginPassword.getText().trim();

        if (!email.isEmpty() && !password.isEmpty()) {
            if (SQLLogin(email, password)) {
                goToMain(email);
            } else {
                alertLoginIncorrectCredentials();
            }
        } else {
            alertSomeFieldsAreBlank();
        }
    }

    @FXML
    void registerAccountOnAction() {
        boolean isTeacher = createAnAccountAs;
        String email = textFieldRegisterEmail.getText().trim();
        String newPassword = toggleRegisterNewPassword ? textFieldRegisterShowNewPassword.getText().trim() : passwordFieldRegisterNewPassword.getText().trim();
        String confirmNewPassword = toggleRegisterConfirmNewPassword ? textFieldRegisterShowConfirmNewPassword.getText().trim() : passwordFieldConfirmNewPassword.getText().trim();

        if (!SQLIsEmailDuplicate(email)) {
            if (newPassword.equals(confirmNewPassword)) {
                if (isTeacher) {
                    // sql for teacher
                } else {
                    // sql for student
                }

                alertRegisterSuccess();
                loginAccountClicked();
            } else {
                alertRegisterPasswordDoNotMatch();
            }
        } else {
            alertRegisterEmailExists();
        }
    }

    @FXML
    void loginFieldsPressedEnter(KeyEvent event) throws IOException {
        if (event.getCode() == KeyCode.ENTER)
            logInOnAction();
    }

    @FXML
    void registerFieldsPressedEnter(KeyEvent event) {
        if (event.getCode() == KeyCode.ENTER)
            registerAccountOnAction();
    }

    @FXML
    void termsAndConditions() {
        btnRegisterAccount.setDisable(!checkBoxTermsAndConditions.isSelected());
    }

    @FXML
    void toggleLoginPassword() {
        toggleLoginPassword = !toggleLoginPassword;

        imageToggleLoginPassword.setImage(toggleLoginPassword ? new Image(Objects.requireNonNull(getClass().getResourceAsStream(HIDE_PASSWORD_IMAGE.getUrl()))) : new Image(Objects.requireNonNull(getClass().getResourceAsStream(SHOW_PASSWORD_IMAGE.getUrl()))));
        textFieldLoginPassword.setVisible(toggleLoginPassword);
        passwordFieldLoginPassword.setVisible(!toggleLoginPassword);

        if (!toggleLoginPassword)
            passwordFieldLoginPassword.setText(textFieldLoginPassword.getText());
        else
            textFieldLoginPassword.setText(passwordFieldLoginPassword.getText());
    }

    @FXML
    void toggleHideShowRegisterNewPassword() {
        toggleRegisterNewPassword = !toggleRegisterNewPassword;

        toggleNewPassword.setImage(toggleRegisterNewPassword ? new Image(Objects.requireNonNull(getClass().getResourceAsStream(HIDE_PASSWORD_IMAGE.getUrl()))) : new Image(Objects.requireNonNull(getClass().getResourceAsStream(SHOW_PASSWORD_IMAGE.getUrl()))));
        textFieldRegisterShowNewPassword.setVisible(toggleRegisterNewPassword);
        passwordFieldRegisterNewPassword.setVisible(!toggleRegisterNewPassword);

        if (!toggleRegisterNewPassword)
            passwordFieldRegisterNewPassword.setText(textFieldRegisterShowNewPassword.getText());
        else
            textFieldRegisterShowNewPassword.setText(passwordFieldRegisterNewPassword.getText());
    }

    @FXML
    void toggleHideShowRegisterConfirmNewPassword() {
        toggleRegisterConfirmNewPassword = !toggleRegisterConfirmNewPassword;

        toggleConfirmNewPassword.setImage(toggleRegisterConfirmNewPassword ? new Image(Objects.requireNonNull(getClass().getResourceAsStream(HIDE_PASSWORD_IMAGE.getUrl()))) : new Image(Objects.requireNonNull(getClass().getResourceAsStream(SHOW_PASSWORD_IMAGE.getUrl()))));
        textFieldRegisterShowConfirmNewPassword.setVisible(toggleRegisterConfirmNewPassword);
        passwordFieldConfirmNewPassword.setVisible(!toggleRegisterConfirmNewPassword);

        if (!toggleRegisterConfirmNewPassword)
            passwordFieldConfirmNewPassword.setText(textFieldRegisterShowConfirmNewPassword.getText());
        else
            textFieldRegisterShowConfirmNewPassword.setText(passwordFieldConfirmNewPassword.getText());
    }


    private void clearFields() {
        textFieldLoginEmail.setText("");

        textFieldLoginPassword.setText("");
        passwordFieldLoginPassword.setText("");

        textFieldRegisterEmail.setText("");

        textFieldRegisterShowNewPassword.setText("");
        passwordFieldRegisterNewPassword.setText("");

        textFieldRegisterShowConfirmNewPassword.setText("");
        passwordFieldConfirmNewPassword.setText("");

        toggleLoginPassword = false;
        toggleRegisterNewPassword = false;
        toggleRegisterConfirmNewPassword = false;

        textFieldLoginPassword.setVisible(false);
        passwordFieldLoginPassword.setVisible(true);

        textFieldRegisterShowNewPassword.setVisible(false);
        passwordFieldRegisterNewPassword.setVisible(true);

        textFieldRegisterShowConfirmNewPassword.setVisible(false);
        passwordFieldConfirmNewPassword.setVisible(true);

        btnRegisterAccount.setDisable(true);
        checkBoxTermsAndConditions.setSelected(false);
    }

    private void goToMain(String email) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(MAIN_SCENE.getURL()));
        Parent root = loader.load();
        mainController mainControllerInstance = loader.getController();
        mainControllerInstance.setEmailUsing(email);
        Stage stage = new Stage();
        Scene scene = new Scene(root);
        stage.setTitle(MAIN_SCENE.getTitle());
        stage.getIcons().add(new Image(String.valueOf(getClass().getResource(LOGO_IMAGE.getUrl()))));
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();

        Stage thisStage = (Stage) anchorPane.getScene().getWindow();
        thisStage.close();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Platform.runLater(this::anchorPaneRequestFocus);
    }
}
