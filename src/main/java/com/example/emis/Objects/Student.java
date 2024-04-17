package com.example.emis.Objects;

import java.time.LocalDate;

public class Student {
    private final String LRN;
    //private final String email;
    private String strand;
    private String section;
    private String teachers;
    private final String lastName;
    private final String firstName;
    private final String middleName;
    private final LocalDate birthdate;
    private final int age;
    private final String sex;
    private final String civilStatus;
    private final String religion;
    private final String citizenship;
    private final String phone;
    private final String homeAddress;
    private final String provincialAddress;
    private final String firstChoice;
    private final String secondChoice;
    private final String elemSchool;
    private final String elemSchoolAddress;
    private final String elemSchoolSY;
    private final String juniorHS;
    private final String juniorHSAddress;
    private final String juniorHSSY;
    //private final String documentStatus;
    private boolean form137;
    private boolean form138;
    private boolean goodMoral;
    private boolean isApplied;
    private boolean isAdmissionProcessed;
    private boolean isEnrolled;

    public Student(String LRN, String lastName, String firstName, String middleName, LocalDate birthdate, int age, String sex, String civilStatus, String religion, String citizenship, String phone, String homeAddress, String provincialAddress, String firstChoice, String secondChoice, String elemSchool, String elemSchoolAddress, String elemSchoolSY, String juniorHS, String juniorHSAddress, String juniorHSSY, boolean form137, boolean form138, boolean goodMoral) {
        this.LRN = LRN;
        this.lastName = lastName;
        this.firstName = firstName;
        this.middleName = middleName;
        this.birthdate = birthdate;
        this.age = age;
        this.sex = sex;
        this.civilStatus = civilStatus;
        this.religion = religion;
        this.citizenship = citizenship;
        this.phone = phone;
        this.homeAddress = homeAddress;
        this.provincialAddress = provincialAddress;
        this.firstChoice = firstChoice;
        this.secondChoice = secondChoice;
        this.elemSchool = elemSchool;
        this.elemSchoolAddress = elemSchoolAddress;
        this.elemSchoolSY = elemSchoolSY;
        this.juniorHS = juniorHS;
        this.juniorHSAddress = juniorHSAddress;
        this.juniorHSSY = juniorHSSY;
        this.form137 = form137;
        this.form138 = form138;
        this.goodMoral = goodMoral;
    }

    public String getLRN() {
        return LRN;
    }

    /*public String getEmail() {
        return email;
    }*/

    public String getStrand() {
        return strand;
    }

    public String getSection() {
        return section;
    }

    public String getTeachers() {
        return teachers;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public int getAge() {
        return age;
    }

    public String getSex() {
        return sex;
    }

    public String getCivilStatus() {
        return civilStatus;
    }

    public String getReligion() {
        return religion;
    }

    public String getCitizenship() {
        return citizenship;
    }

    public String getPhone() {
        return phone;
    }

    public String getHomeAddress() {
        return homeAddress;
    }

    public String getProvincialAddress() {
        return provincialAddress;
    }

    public String getFirstChoice() {
        return firstChoice;
    }

    public String getSecondChoice() {
        return secondChoice;
    }

    public String getElemSchool() {
        return elemSchool;
    }

    public String getElemSchoolAddress() {
        return elemSchoolAddress;
    }

    public String getElemSchoolSY() {
        return elemSchoolSY;
    }

    public String getJuniorHS() {
        return juniorHS;
    }

    public String getJuniorHSAddress() {
        return juniorHSAddress;
    }

    public String getJuniorHSSY() {
        return juniorHSSY;
    }

    /*public String getDocumentStatus() {
        return documentStatus;
    }*/

    public boolean isForm137() {
        return form137;
    }

    public boolean isForm138() {
        return form138;
    }

    public boolean isGoodMoral() {
        return goodMoral;
    }

    public boolean isApplied() {
        return isApplied;
    }

    public boolean isAdmissionProcessed() {
        return isAdmissionProcessed;
    }

    public boolean isEnrolled() {
        return isEnrolled;
    }

    public void setStrand(String strand) {
        this.strand = strand;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public void setTeachers(String teachers) {
        this.teachers = teachers;
    }

    public void setForm137(boolean form137) {
        this.form137 = form137;
    }

    public void setForm138(boolean form138) {
        this.form138 = form138;
    }

    public void setGoodMoral(boolean goodMoral) {
        this.goodMoral = goodMoral;
    }

    public void setApplied(boolean applied) {
        isApplied = applied;
    }

    public void setAdmissionProcessed(boolean admissionProcessed) {
        isAdmissionProcessed = admissionProcessed;
    }

    public void setEnrolled(boolean enrolled) {
        isEnrolled = enrolled;
    }
}
