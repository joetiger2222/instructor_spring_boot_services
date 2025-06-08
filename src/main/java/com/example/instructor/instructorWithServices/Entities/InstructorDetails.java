package com.example.instructor.instructorWithServices.Entities;

import jakarta.persistence.*;

@Entity
@Table(name = "instructor_detais")
public class InstructorDetails {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "hobby")
    private String hobby;

    @Column(name = "youtube_channel")
    private String youtubeChannel;

    @OneToOne(mappedBy = "instructorDetails")
    private Instructor instructor;

    public InstructorDetails() {
    }

    public InstructorDetails(String hobby, String youtubeChannel) {
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

    public Instructor getInstructor() {
        return instructor;
    }

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }
}
