package com.example.instructor.instructorWithServices.Mapper;

import com.example.instructor.instructorWithServices.DTOs.CourseDTOs.CourseForGetAll;
import com.example.instructor.instructorWithServices.Entities.Course;

public class CourseMapper {
    public static CourseForGetAll courseToCourseForGetAll(Course course){
        return new CourseForGetAll(
                course.getId(),
                course.getName()
        );
    }
}
