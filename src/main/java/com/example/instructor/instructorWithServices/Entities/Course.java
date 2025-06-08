package com.example.instructor.instructorWithServices.Entities;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "course")
public class Course {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @ManyToOne(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
    @JoinColumn(name = "instructor_id")
    private Instructor instructor;

    @ManyToMany
    @JoinTable(name = "course_student",joinColumns = @JoinColumn(name = "course_id"),inverseJoinColumns = @JoinColumn(name = "student_id"))
    private List<Student>students;

    public Course() {
    }

    public Course(String name) {
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

    public Instructor getInstructor() {
        return instructor;
    }

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public void addStudentToCourse(Student student){
        if(students==null){
            students=new ArrayList<>();
        }
        students.add(student);
    }
}
