package com.example.instructor.instructorWithServices.Controllers;

import com.example.instructor.instructorWithServices.DTOs.StudentDTOs.StudentForGetAll;
import com.example.instructor.instructorWithServices.DTOs.StudentDTOs.StudentForGetSingle;
import com.example.instructor.instructorWithServices.Entities.Student;
import com.example.instructor.instructorWithServices.Services.StudentService.IStudentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {
    IStudentService studentService;

    public StudentController(IStudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping
    public void createStudent(@RequestBody Student student){
        studentService.save(student);
    }

    @PutMapping
    public String assignStudentToCourse(@RequestParam int studentId,@RequestParam int courseId){
        return studentService.assignStudentToCourse(studentId,courseId);
    }

    @GetMapping
    public List<StudentForGetAll>getStudents(@RequestParam int page,@RequestParam int size){
        return studentService.findAll(page,size);
    }

    @GetMapping("/course")
    public List<StudentForGetAll>getStudentsByCourseId(@RequestParam int courseId){
        return studentService.getStudentsByCourseId(courseId);
    }

    @GetMapping("/single")
    public StudentForGetSingle getStudentById(@RequestParam int studentId){
        return studentService.findById(studentId);
    }
}
