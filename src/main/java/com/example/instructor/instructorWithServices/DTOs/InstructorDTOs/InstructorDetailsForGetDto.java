package com.example.instructor.instructorWithServices.DTOs.InstructorDTOs;

public class InstructorDetailsForGetDto {
    private int id;
    private String hobby;
    private String youtubeChannel;

    public InstructorDetailsForGetDto() {
    }

    public InstructorDetailsForGetDto(int id, String hobby, String youtubeChannel) {
        this.id = id;
        this.hobby = hobby;
        this.youtubeChannel = youtubeChannel;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    public String getYoutubeChannel() {
        return youtubeChannel;
    }

    public void setYoutubeChannel(String youtubeChannel) {
        this.youtubeChannel = youtubeChannel;
    }
}
