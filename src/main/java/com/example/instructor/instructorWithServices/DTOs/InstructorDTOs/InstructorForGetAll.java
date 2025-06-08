package com.example.instructor.instructorWithServices.DTOs.InstructorDTOs;

public class InstructorForGetAll {
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private InstructorDetailsForGetDto instructorDetails;


    public InstructorForGetAll() {
    }

    public InstructorForGetAll(int id, String firstName, String lastName, String email, InstructorDetailsForGetDto instructorDetails) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.instructorDetails = instructorDetails;
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
}
