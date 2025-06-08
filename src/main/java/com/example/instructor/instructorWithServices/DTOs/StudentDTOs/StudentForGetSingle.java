package com.example.instructor.instructorWithServices.DTOs.StudentDTOs;

import com.example.instructor.instructorWithServices.DTOs.CourseDTOs.CourseForGetAll;

import java.util.List;

public class StudentForGetSingle {
    private int id;
    private String name;
    private List<CourseForGetAll>courses;

    public StudentForGetSingle(int id, String name, List<CourseForGetAll> courses) {
        this.id = id;
        this.name = name;
        this.courses = courses;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<CourseForGetAll> getCourses() {
        return courses;
    }

    public void setCourses(List<CourseForGetAll> courses) {
        this.courses = courses;
    }
}
