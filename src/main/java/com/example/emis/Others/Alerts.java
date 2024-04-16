package com.example.emis.Others;

import javafx.scene.control.Alert;

public class Alerts {
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

    public static void alertLoginIncorrectCredentials() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText("Incorrect email/password");
        alert.setContentText("The email or password you entered is incorrect. Please try again.");
        alert.show();
    }
}
