package com.example.instructor.instructorWithServices.Services.StudentService;

import com.example.instructor.instructorWithServices.DAO.CourseRepository;
import com.example.instructor.instructorWithServices.DAO.StudentRepository;
import com.example.instructor.instructorWithServices.DTOs.CourseDTOs.CourseForGetAll;
import com.example.instructor.instructorWithServices.DTOs.StudentDTOs.StudentForGetAll;
import com.example.instructor.instructorWithServices.DTOs.StudentDTOs.StudentForGetSingle;
import com.example.instructor.instructorWithServices.Entities.Course;
import com.example.instructor.instructorWithServices.Entities.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImp implements IStudentService{
    StudentRepository studentRepository;
    CourseRepository courseRepository;

    public StudentServiceImp(StudentRepository studentRepository, CourseRepository courseRepository) {
        this.studentRepository = studentRepository;
        this.courseRepository = courseRepository;
    }

    @Override
    public List<StudentForGetAll> findAll(int page, int size) {
        Pageable pageable= PageRequest.of(page,size);
        Page<Student> students =studentRepository.findAll(pageable);
        List<StudentForGetAll> students1= students.stream().map(s->new StudentForGetAll(s.getId(),s.getName())).toList();
        return students1;

    }

    @Override
    public StudentForGetSingle findById(int id) {
        Optional<Student> studentOptional=studentRepository.findById(id);
        if(studentOptional.isPresent()){
            Student student=studentOptional.get();
            return new StudentForGetSingle(student.getId(),student.getName(),student.getCourses().stream().map(c->new CourseForGetAll(c.getId(),c.getName())).toList());
        }
        throw new RuntimeException("student not found");
    }

    @Override
    public void save(Student student) {
        studentRepository.save(student);
    }

    @Override
    public void deleteById(int id) {

    }

    @Override
    public String assignStudentToCourse(int studentId, int courseId) {
        Optional<Student>studentOptional=studentRepository.findById(studentId);
        Optional<Course>courseOptional=courseRepository.findById(courseId);
        if(studentOptional.isPresent()&&courseOptional.isPresent()){
            Student student=studentOptional.get();
            Course course=courseOptional.get();
            course.addStudentToCourse(student);
            courseRepository.save(course);
            return "student assigned successfully";
        }
        throw new RuntimeException("course or student not found");
    }

    @Override
    public List<StudentForGetAll> getStudentsByCourseId(int courseId) {
        Optional<Course>courseOptional=courseRepository.findById(courseId);
        if(courseOptional.isPresent()){
            Course course=courseOptional.get();
            List<Student>students=course.getStudents();
            return students.stream().map(s->new StudentForGetAll(s.getId(),s.getName())).toList();
        }
        throw new RuntimeException("Course not found");
    }
}
