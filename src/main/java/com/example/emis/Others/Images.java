package com.example.emis.Others;

public enum Images {
    IMAGES_LOGO("/com/example/emis/Images/logo.png");

    private final String url;

    Images(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }
}
