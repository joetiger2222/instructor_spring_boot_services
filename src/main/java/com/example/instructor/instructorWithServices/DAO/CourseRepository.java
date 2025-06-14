package com.example.instructor.instructorWithServices.DAO;

import com.example.instructor.instructorWithServices.Entities.Course;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CourseRepository extends JpaRepository<Course,Integer> {
    @Query("select c from Course c where c.instructor.id=:instructorId")
    List<Course>getCoursesByInstructorId(@Param("instructorId")int instructorId);
}
