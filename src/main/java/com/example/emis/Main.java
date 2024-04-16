package com.example.emis;

import io.github.palexdev.materialfx.theming.JavaFXThemes;
import io.github.palexdev.materialfx.theming.MaterialFXStylesheets;
import io.github.palexdev.materialfx.theming.UserAgentBuilder;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

import static com.example.emis.Enums.ImagesEnum.*;
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

    public static void setStyleSheets() {
        UserAgentBuilder.builder()
                .themes(JavaFXThemes.MODENA) // Optional if you don't need JavaFX's default theme, still recommended though
                .themes(MaterialFXStylesheets.forAssemble(true)) // Adds the MaterialFX's default theme. The boolean argument is to include legacy controls
                .setDeploy(true) // Whether to deploy each theme's assets on a temporary dir on the disk
                .setResolveAssets(true) // Whether to try resolving @import statements and resources urls
                .build() // Assembles all the added themes into a single CSSFragment (very powerful class check its documentation)
                .setGlobal(); // Finally, sets the produced stylesheet as the global User-Agent stylesheet
    }

    public static void main(String[] args) {
        launch();
    }
}