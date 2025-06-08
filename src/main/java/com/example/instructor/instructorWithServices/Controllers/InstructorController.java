package com.example.instructor.instructorWithServices.Controllers;

import com.example.instructor.instructorWithServices.DTOs.InstructorDTOs.InstructorForGetAll;
import com.example.instructor.instructorWithServices.DTOs.InstructorDTOs.InstructorForGetSingle;
import com.example.instructor.instructorWithServices.Entities.Instructor;
import com.example.instructor.instructorWithServices.Services.InstructorService.IInstructorService;
import com.example.instructor.instructorWithServices.Services.InstructorService.InstructorServiceImp;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/instructor")
public class InstructorController {
    IInstructorService instructorServiceImp;

    public InstructorController(IInstructorService instructorServiceImp) {
        this.instructorServiceImp = instructorServiceImp;
    }

    @GetMapping
    public List<InstructorForGetAll>findAll(@RequestParam(defaultValue = "0") int page,@RequestParam(defaultValue = "10") int size){
        return instructorServiceImp.findAll(page,size);
    }
    @GetMapping("/paginated")
    public List<InstructorForGetAll>findAllPaginatedWithJpa(@RequestParam(defaultValue = "0") int page,@RequestParam(defaultValue = "10") int size){
        return instructorServiceImp.findAllPaginatedWithJpa(page,size);
    }

    @PostMapping
    public void addInstructor(@RequestBody Instructor instructor){
        instructorServiceImp.save(instructor);
    }

    @DeleteMapping
    public void deleteById(@RequestParam int id){
        instructorServiceImp.deleteById(id);
    }

    @GetMapping("/single")
    public InstructorForGetSingle findById(@RequestParam int id){
        return instructorServiceImp.findById(id);
    }
}
