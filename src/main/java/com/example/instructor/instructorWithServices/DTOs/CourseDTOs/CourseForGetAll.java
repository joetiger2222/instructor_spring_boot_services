package com.example.instructor.instructorWithServices.DTOs.CourseDTOs;

public class CourseForGetAll {
    private int id;
    private String name;

    public CourseForGetAll() {
    }

    public CourseForGetAll(int id, String name) {
        this.id = id;
        this.name = name;
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
}
