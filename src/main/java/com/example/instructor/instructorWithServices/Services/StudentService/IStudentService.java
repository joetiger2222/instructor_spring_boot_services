package com.example.instructor.instructorWithServices.Services.StudentService;

import com.example.instructor.instructorWithServices.DTOs.CourseDTOs.CourseForGetAll;
import com.example.instructor.instructorWithServices.DTOs.StudentDTOs.StudentForGetAll;
import com.example.instructor.instructorWithServices.DTOs.StudentDTOs.StudentForGetSingle;
import com.example.instructor.instructorWithServices.Entities.Course;
import com.example.instructor.instructorWithServices.Entities.Student;

import java.util.List;

public interface IStudentService {
    List<StudentForGetAll> findAll(int page, int size);
    StudentForGetSingle findById(int id);
    void save(Student student);
    void deleteById(int id);
    String assignStudentToCourse(int studentId,int courseId);
    List<StudentForGetAll>getStudentsByCourseId(int courseId);
}
