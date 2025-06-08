package com.example.instructor.instructorWithServices.DTOs.InstructorDTOs;

import com.example.instructor.instructorWithServices.DTOs.CourseDTOs.CourseForGetAll;
import com.example.instructor.instructorWithServices.Entities.Course;

import java.util.List;

public class InstructorForGetSingle {
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private InstructorDetailsForGetDto instructorDetails;
    private List<CourseForGetAll>courses;

    public InstructorForGetSingle() {
    }

    public InstructorForGetSingle(int id, String firstName, String lastName, String email, InstructorDetailsForGetDto instructorDetails, List<CourseForGetAll> courses) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.instructorDetails = instructorDetails;
        this.courses = courses;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public InstructorDetailsForGetDto getInstructorDetails() {
        return instructorDetails;
    }

    public void setInstructorDetails(InstructorDetailsForGetDto instructorDetails) {
        this.instructorDetails = instructorDetails;
    }

    public List<CourseForGetAll> getCourses() {
        return courses;
    }

    public void setCourses(List<CourseForGetAll> courses) {
        this.courses = courses;
    }
}
