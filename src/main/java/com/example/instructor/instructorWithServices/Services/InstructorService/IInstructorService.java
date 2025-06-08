package com.example.instructor.instructorWithServices.Services.InstructorService;

import com.example.instructor.instructorWithServices.DTOs.InstructorDTOs.InstructorForGetAll;
import com.example.instructor.instructorWithServices.DTOs.InstructorDTOs.InstructorForGetSingle;
import com.example.instructor.instructorWithServices.Entities.Instructor;

import java.util.List;

public interface IInstructorService {
    List<InstructorForGetAll> findAll(int page,int size);
    List<InstructorForGetAll> findAllPaginatedWithJpa(int page,int size);
    InstructorForGetSingle findById(int id);
    void save(Instructor instructor);
    void deleteById(int id);

}
