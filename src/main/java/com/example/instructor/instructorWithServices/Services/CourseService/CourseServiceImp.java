package com.example.instructor.instructorWithServices.Services.CourseService;

import com.example.instructor.instructorWithServices.DAO.CourseRepository;
import com.example.instructor.instructorWithServices.DAO.InstructorRepository;
import com.example.instructor.instructorWithServices.DTOs.CourseDTOs.CourseForGetAll;
import com.example.instructor.instructorWithServices.Entities.Course;
import com.example.instructor.instructorWithServices.Entities.Instructor;
import com.example.instructor.instructorWithServices.Entities.Review;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseServiceImp implements ICourseService{

    CourseRepository courseRepository;
    InstructorRepository instructorRepository;

    public CourseServiceImp(CourseRepository courseRepository, InstructorRepository instructorRepository) {
        this.courseRepository = courseRepository;
        this.instructorRepository = instructorRepository;
    }

    @Override
    public List<CourseForGetAll> findAll(int page, int size) {
        Pageable pageable= PageRequest.of(page,size);
        Page<Course> courses=courseRepository.findAll(pageable);
        List<CourseForGetAll>courses1= courses.stream().map(c->new CourseForGetAll(c.getId(),c.getName())).toList();
        return courses1;
    }

    @Override
    public CourseForGetAll findById(int id) {
        return null;
    }

    @Override
    public void save(Course course, int instructorId) {
        Optional<Instructor>instructorOptional=instructorRepository.findById(instructorId);
        if(instructorOptional.isPresent()){
            Instructor instructor=instructorOptional.get();
            instructor.addCourseToInstructor(course);
            courseRepository.save(course);
            return;
        }
        throw new RuntimeException("Instructor not found");
    }

    @Override
    public void deleteById(int id) {

    }

    @Override
    public Review addReviewToCourse(int courseId, Review review) {
        Course course=courseRepository.findById(courseId).orElseThrow(()->new RuntimeException("course not found"));
        course.addReviewToCourse(review);
        courseRepository.save(course);
        return review;
    }
}
