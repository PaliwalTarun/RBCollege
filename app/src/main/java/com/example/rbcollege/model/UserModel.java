package com.example.rbcollege.model;

public class UserModel {
    private int id;
    private String facultyName;
    private String subjectName;
    private String contentDelivered;
    private int numberOfStudent;
//    private int dateTime;


    public UserModel() {
        this.id = id;
        this.facultyName = facultyName;
        this.subjectName = subjectName;
        this.contentDelivered = contentDelivered;
        this.numberOfStudent = numberOfStudent;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFacultyName() {
        return facultyName;
    }

    public void setFacultyName(String facultyName) {
        this.facultyName = facultyName;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public String getContentDelivered() {
        return contentDelivered;
    }

    public void setContentDelivered(String contentDelivered) {
        this.contentDelivered = contentDelivered;
    }

    public int getNumberOfStudent() {
        return numberOfStudent;
    }

    public void setNumberOfStudent(int numberOfStudent) {
        this.numberOfStudent = numberOfStudent;
    }
}
