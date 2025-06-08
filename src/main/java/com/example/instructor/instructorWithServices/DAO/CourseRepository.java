package com.example.instructor.instructorWithServices.DAO;

import com.example.instructor.instructorWithServices.Entities.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course,Integer> {
}
