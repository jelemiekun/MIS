package com.example.emis.Others;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

import java.util.Optional;

public class Alerts {
    public static void alertNoConnection() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText("Connection Error");
        alert.setContentText("Unable to connect to the database. Please check your connection and try again.");
        alert.showAndWait();
    }

    public static void alertRegisterEmailExists() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText("Duplicate email registration");
        alert.setContentText("Email already registered. Please use a different email.");
        alert.show();
    }

    public static void alertRegisterPasswordDoNotMatch() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText("Password mismatch");
        alert.setContentText("New password and confirm new password does not match.");
        alert.show();
    }

    public static void alertRegisterSuccess() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Success");
        alert.setHeaderText("Registration Successful");
        alert.setContentText("Your registration has been completed successfully. You can now log in with your credentials.");
        alert.showAndWait();
    }

    public static void alertApplicationSubmitted() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Success");
        alert.setHeaderText("Application submitted!");
        alert.setContentText("Your application has been submitted. Please await further instructions regarding enrollment status.");
        alert.showAndWait();
    }

    public static void alertRegisterNotSuccess() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText("Registration Failed");
        alert.setContentText("Your registration has been unsuccessful. Please try again later.");
        alert.showAndWait();
    }

    public static void alertUnexpectedError() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText("Unexpected Error");
        alert.setContentText("Something went wrong. Please try again later");
        alert.show();
    }

    public static void alertSomeFieldsAreBlank() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText("Fields blank");
        alert.setContentText("One or more fields is blank. Please enter a value.");
        alert.show();
    }

    public static void alertInvalidAge() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText("Age error");
        alert.setContentText("Age input is invalid. Please enter a valid value.");
        alert.show();
    }

    public static void alertInvalidLRN() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText("LRN error");
        alert.setContentText("LRN input is invalid. Please enter a valid value.");
        alert.show();
    }

    public static void alertLoginIncorrectCredentials() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText("Incorrect email/password");
        alert.setContentText("The email or password you entered is incorrect. Please try again.");
        alert.show();
    }

    public static boolean alertConfirmClearFieldsRegistration() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Confirm");
        alert.setHeaderText("Clear all fields?");
        alert.setContentText("Select 'yes' to clear all and 'cancel' to cancel.");

        ButtonType buttonTypeYes = new ButtonType("Yes");
        ButtonType buttonTypeNo = new ButtonType("Cancel");

        alert.getButtonTypes().setAll(buttonTypeYes, buttonTypeNo);
        Optional<ButtonType> result = alert.showAndWait();
        if (result.isPresent() && result.get() == buttonTypeYes) {
            return true; // clicked 'yes'
        } else {
            return false; // clicked 'no'
        }
    }

    public static boolean alertSubmitApplication() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Confirm");
        alert.setHeaderText("Submit application?");
        alert.setContentText("Select 'yes' to submit and 'cancel' to cancel.");

        ButtonType buttonTypeYes = new ButtonType("Yes");
        ButtonType buttonTypeNo = new ButtonType("Cancel");

        alert.getButtonTypes().setAll(buttonTypeYes, buttonTypeNo);
        Optional<ButtonType> result = alert.showAndWait();
        if (result.isPresent() && result.get() == buttonTypeYes) {
            return true; // clicked 'yes'
        } else {
            return false; // clicked 'no'
        }
    }

    public static boolean alertConfirmLogout() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Confirm");
        alert.setHeaderText("Confirm log-out?");
        alert.setContentText("Select 'yes' to log-out and 'no' to stay logged-in.");

        ButtonType buttonTypeYes = new ButtonType("Yes");
        ButtonType buttonTypeNo = new ButtonType("No");

        alert.getButtonTypes().setAll(buttonTypeYes, buttonTypeNo);
        Optional<ButtonType> result = alert.showAndWait();
        if (result.isPresent() && result.get() == buttonTypeYes) {
            return true; // clicked 'yes'
        } else {
            return false; // clicked 'no'
        }
    }
}
