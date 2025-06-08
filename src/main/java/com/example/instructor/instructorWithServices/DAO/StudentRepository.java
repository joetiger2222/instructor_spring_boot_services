package com.example.instructor.instructorWithServices.DAO;

import com.example.instructor.instructorWithServices.Entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student,Integer> {
}
