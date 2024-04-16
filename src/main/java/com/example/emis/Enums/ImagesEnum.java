package com.example.emis.Enums;

public enum ImagesEnum {
    LOGO_IMAGE("/com/example/emis/Images/logo.png"),
    SHOW_PASSWORD_IMAGE("/com/example/emis/Images/Show Password.png"),
    HIDE_PASSWORD_IMAGE("/com/example/emis/Images/Hide Password.png");

    private final String url;

    ImagesEnum(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }
}
