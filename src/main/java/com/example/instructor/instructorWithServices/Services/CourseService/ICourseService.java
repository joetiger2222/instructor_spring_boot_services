package com.example.instructor.instructorWithServices.Services.CourseService;

import com.example.instructor.instructorWithServices.DTOs.CourseDTOs.CourseForGetAll;
import com.example.instructor.instructorWithServices.DTOs.InstructorDTOs.InstructorForGetAll;
import com.example.instructor.instructorWithServices.DTOs.InstructorDTOs.InstructorForGetSingle;
import com.example.instructor.instructorWithServices.Entities.Course;
import com.example.instructor.instructorWithServices.Entities.Instructor;
import com.example.instructor.instructorWithServices.Entities.Review;

import java.util.List;

public interface ICourseService {
    List<CourseForGetAll> findAll(int page, int size);
    CourseForGetAll findById(int id);
    void save(Course course,int instructorId);
    void deleteById(int id);
    Review addReviewToCourse(int courseId,Review review);
    List<CourseForGetAll> getCoursesByInstructorId(int instructorId);
}
