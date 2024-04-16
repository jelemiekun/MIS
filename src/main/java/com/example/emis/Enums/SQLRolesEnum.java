package com.example.emis.Enums;

public enum SQLRolesEnum {
    STUDENT_ROLE_ENUM("student"),
    TEACHER_ROLE_ENUM("teacher"),
    MIS_ROLE_ENUM("mis");

    private final String role;

    SQLRolesEnum(String role) {
        this.role = role;
    }

    public String getRole() { return role; }
}
