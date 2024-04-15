package com.example.emis.Others;

public enum Scenes {
    SCENES_LOGIN_REGISTER("Enrollment System", "/com/example/emis/FXML/loginRegister.fxml"),
    MAIN("Enrollment System", "/com/example/emis/FXML/main.fxml"),
    STUDENT_INFO("Enrollment System", "/com/example/emis/FXML/studentInfo.fxml");

    private final String title;
    private final String URL;

    Scenes(String title, String URL) {
        this.title = title;
        this.URL = URL;
    }

    public String getTitle() {
        return title;
    }

    public String getURL() {
        return URL;
    }
}
