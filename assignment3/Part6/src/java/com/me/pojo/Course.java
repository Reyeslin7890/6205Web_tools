package com.me.pojo;

public class Course {

    private String name;
    private String crn;
    private String instructor;
    private String courseDescription;

    public Course() {
    }

    public Course(String name, String crn, String instructor, String courseDescription) {
        this.name = name;
        this.crn = crn;
        this.instructor = instructor;
        this.courseDescription = courseDescription;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCrn() {
        return crn;
    }

    public void setCrn(String crn) {
        this.crn = crn;
    }

    public String getInstructor() {
        return instructor;
    }

    public void setInstructor(String instructor) {
        this.instructor = instructor;
    }

    public String getCourseDescription() {
        return courseDescription;
    }

    public void setCourseDescription(String courseDescription) {
        this.courseDescription = courseDescription;
    }

}
