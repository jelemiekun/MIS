package com.example.emis;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

import static com.example.emis.Enums.ImagesEnum.*;
import static com.example.emis.Models.mainModel.*;
import static com.example.emis.Others.SQL.*;
import static com.example.emis.Enums.ScenesEnum.*;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        SQLCreateConnection();
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource(LOGIN_REGISTER_SCENE.getURL()));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle(LOGIN_REGISTER_SCENE.getTitle());
        stage.setResizable(false);
        stage.getIcons().add(new Image(Objects.requireNonNull(getClass().getResourceAsStream(LOGO_IMAGE.getUrl()))));
        stage.setScene(scene);
        setStyleSheets();
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}