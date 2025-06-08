package com.example.instructor.instructorWithServices.Controllers;

import com.example.instructor.instructorWithServices.DTOs.CourseDTOs.CourseForGetAll;
import com.example.instructor.instructorWithServices.Entities.Course;
import com.example.instructor.instructorWithServices.Entities.Review;
import com.example.instructor.instructorWithServices.Services.CourseService.CourseServiceImp;
import com.example.instructor.instructorWithServices.Services.CourseService.ICourseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/course")
public class CourseController {

    ICourseService courseService;

    public CourseController(ICourseService courseService) {
        this.courseService = courseService;
    }

    @PostMapping
    public void createCourse(@RequestParam int instructorId, @RequestBody Course course){
        courseService.save(course,instructorId);
    }

    @GetMapping
    public List<CourseForGetAll> getAll(@RequestParam int page, @RequestParam(defaultValue = "10") int size){
        return courseService.findAll(page,size);
    }

    @PostMapping("/review/{courseId}")
    public ResponseEntity<Review>addReviewToCourse(@PathVariable int courseId,@RequestBody Review review){
        return new ResponseEntity<>(courseService.addReviewToCourse(courseId,review), HttpStatus.ACCEPTED);
    }

}
