package com.example.emis.Objects;

import java.time.LocalDate;

public class Student {
    private String LRN;
    private String email;
    private String strand;
    private String section;
    private String teachers;
    private String lastName;
    private String firstName;
    private String middleName;
    private String fullName;
    private LocalDate birthdate;
    private int age;
    private String sex;
    private String civilStatus;
    private String religion;
    private String citizenship;
    private String phone;
    private String homeAddress;
    private String provincialAddress;
    private String firstChoice;
    private String secondChoice;
    private String elemSchool;
    private String elemSchoolAddress;
    private String elemSchoolSY;
    private String juniorHS;
    private String juniorHSAddress;
    private String juniorHSSY;
    private String documentStatus;
    private boolean form137;
    private boolean form138;
    private boolean goodMoral;
    private boolean isApplied;
    private boolean isAdmissionProcessed;
    private boolean isEnrolled;

    public Student(String LRN, String email, String lastName, String firstName, String middleName, LocalDate birthdate, int age, String sex, String civilStatus, String religion, String citizenship, String phone, String section, String homeAddress, String provincialAddress, String firstChoice, String secondChoice, String elemSchool, String elemSchoolAddress, String elemSchoolSY, String juniorHS, String juniorHSAddress, String juniorHSSY, boolean form137, boolean form138, boolean goodMoral) {
        this.LRN = LRN;
        this.email = email;
        this.lastName = lastName;
        this.firstName = firstName;
        this.middleName = middleName;
        this.fullName = lastName + ", " + firstName + " " + middleName;
        this.birthdate = birthdate;
        this.age = age;
        this.sex = sex;
        this.civilStatus = civilStatus;
        this.religion = religion;
        this.citizenship = citizenship;
        this.phone = phone;
        this.section = section;
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

    public Student(String email, String lastName, String firstName, String middleName, String documentStatus,boolean isApplied, boolean isAdmissionProcessed, boolean isEnrolled) {
        this.email = email;
        this.lastName = lastName;
        this.firstName = firstName;
        this.middleName = middleName;
        this.fullName = lastName + ", " + firstName + " " + middleName;
        this.documentStatus = documentStatus;
        this.isApplied = isApplied;
        this.isAdmissionProcessed = isAdmissionProcessed;
        this.isEnrolled = isEnrolled;
    }

    public Student(String lastName, String firstName, String middleName, String strand, String section) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.middleName = middleName;
        this.fullName = lastName + ", " + firstName + " " + middleName;
        this.strand = strand;
        this.section = section;
    }

    public String getLRN() {
        return LRN;
    }

    public String getEmail() {
        return email;
    }

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

    public String getFullName() {
        return fullName;
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

    public String getDocumentStatus() {
        return documentStatus;
    }

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
