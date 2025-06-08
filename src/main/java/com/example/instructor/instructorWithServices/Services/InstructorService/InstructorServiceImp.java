package com.example.instructor.instructorWithServices.Services.InstructorService;

import com.example.instructor.instructorWithServices.DAO.InstructorRepository;
import com.example.instructor.instructorWithServices.DTOs.CourseDTOs.CourseForGetAll;
import com.example.instructor.instructorWithServices.DTOs.InstructorDTOs.InstructorDetailsForGetDto;
import com.example.instructor.instructorWithServices.DTOs.InstructorDTOs.InstructorForGetAll;
import com.example.instructor.instructorWithServices.DTOs.InstructorDTOs.InstructorForGetSingle;
import com.example.instructor.instructorWithServices.Entities.Instructor;
import jakarta.persistence.EntityManager;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InstructorServiceImp implements IInstructorService{

    private InstructorRepository instructorRepository;
    private EntityManager entityManager;

    public InstructorServiceImp(InstructorRepository instructorRepository, EntityManager entityManager) {
        this.instructorRepository = instructorRepository;
        this.entityManager = entityManager;
    }

    @Override
    public List<InstructorForGetAll> findAll(int page,int size) {
//        List<Instructor> instructors= instructorRepository.findAll(); this make a call to the data base with each instructor because i lazy load the instructor details
        List<Instructor> instructors=entityManager.createQuery("Select i from Instructor i Join fetch i.instructorDetails").setFirstResult(page*size).setMaxResults(size).getResultList(); // this get the instructor details with instructor at one transaction
        List<InstructorForGetAll> instructorForGetAlls= instructors.stream().map(i->new InstructorForGetAll(i.getId(),i.getFirstName(),i.getLastName(),i.getEmail(),new InstructorDetailsForGetDto(i.getInstructorDetails().getId(),i.getInstructorDetails().getHobby(),i.getInstructorDetails().getYoutubeChannel()))).toList();
        return instructorForGetAlls;
    }

    @Override
    public List<InstructorForGetAll> findAllPaginatedWithJpa(int page, int size) {
        Pageable pageable= PageRequest.of(page,size);
        Page<Instructor>instructors= instructorRepository.findAll(pageable);
        List<InstructorForGetAll> instructorForGetAlls= instructors.stream().map(i->new InstructorForGetAll(i.getId(),i.getFirstName(),i.getLastName(),i.getEmail(),new InstructorDetailsForGetDto(i.getInstructorDetails().getId(),i.getInstructorDetails().getHobby(),i.getInstructorDetails().getYoutubeChannel()))).toList();
        return instructorForGetAlls;
    }

    @Override
    public InstructorForGetSingle findById(int id) {
        Optional<Instructor> instructorOpt= instructorRepository.findById(id);
        if(instructorOpt.isPresent()){
            Instructor instructor=instructorOpt.get();
            InstructorForGetSingle instructor1=new InstructorForGetSingle(instructor.getId(),instructor.getFirstName(),instructor.getLastName(),instructor.getEmail(),new InstructorDetailsForGetDto(instructor.getInstructorDetails().getId(),instructor.getInstructorDetails().getHobby(),instructor.getInstructorDetails().getYoutubeChannel()),instructor.getCourse().stream().map(c->new CourseForGetAll(c.getId(),c.getName())).toList());
            return instructor1;
        }
        throw new RuntimeException("instructor not found");
    }

    @Override
    public void save(Instructor instructor) {
        instructorRepository.save(instructor);
    }

    @Override
    public void deleteById(int id) {
        instructorRepository.deleteById(id);
    }




}
