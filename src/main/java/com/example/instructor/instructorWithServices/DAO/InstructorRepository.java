package com.example.instructor.instructorWithServices.DAO;

import com.example.instructor.instructorWithServices.Entities.Instructor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InstructorRepository extends JpaRepository<Instructor,Integer> {
}
