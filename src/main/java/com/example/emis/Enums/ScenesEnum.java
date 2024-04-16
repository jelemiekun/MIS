package com.example.emis.Enums;

public enum ScenesEnum {
    LOGIN_REGISTER_SCENE("Enrollment System", "/com/example/emis/FXML/loginRegister.fxml"),
    MAIN_SCENE("Enrollment System", "/com/example/emis/FXML/main.fxml"),
    SECTION_SCENE("Enrollment System", "/com/example/emis/FXML/section.fxml"),
    STRAND_SCENE("Enrollment System", "/com/example/emis/FXML/strand.fxml"),
    STUDENT_INFO_SCENE("Enrollment System", "/com/example/emis/FXML/studentInfo.fxml"),
    TEACHER_SCENE("Enrollment System", "/com/example/emis/FXML/teacher.fxml"),
    TEACHER_CREDENTIALS_SCENE("Enrollment System", "/com/example/emis/FXML/teacherCredentials.fxml");

    private final String title;
    private final String URL;

    ScenesEnum(String title, String URL) {
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
