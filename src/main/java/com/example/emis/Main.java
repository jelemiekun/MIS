package com.example.emis;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

import static com.example.emis.Others.Images.*;
import static com.example.emis.Others.Scenes.*;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource(SCENES_LOGIN_REGISTER.getURL()));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle(SCENES_LOGIN_REGISTER.getTitle());
        stage.setResizable(false);
        stage.getIcons().add(new Image(Objects.requireNonNull(getClass().getResourceAsStream(IMAGES_LOGO.getUrl()))));
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}