package com.project.catalog1.service;

import com.project.catalog1.exception.NotFoundException;
import com.project.catalog1.model.Subject;
import com.project.catalog1.model.Teacher;
import com.project.catalog1.repository.TeacherRepository;
import com.project.catalog1.web.dto.SubjectDto;
import com.project.catalog1.web.dto.SubjectScoringDto;
import com.project.catalog1.web.dto.TeacherDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;

@Service
public class TeacherService {
    //service classes contain most of the business logic

    private TeacherRepository teacherRepository;
    private SubjectService subjectService;

    @Autowired
    public TeacherService(SubjectService subjectService,TeacherRepository teacherRepository){
        this.teacherRepository = teacherRepository;
        this.subjectService = subjectService;
    }
    public List<Teacher> getAllTeachers() {
        return teacherRepository.findAll();
    }

    public List<Teacher> getAllTeachersByCnp(String cnp){
        Optional<Teacher> byCnp = teacherRepository.findByCnp(cnp);
        return byCnp
                .map(Collections::singletonList)
                .orElse(Collections.emptyList());
    }

    public List<Teacher> getAllTeachersByName(String firstName, String lastName){
        return teacherRepository.findByFirstNameAndLastName(firstName,lastName);
    }

    public Teacher getTeacher(Long id){
        Optional<Teacher> byId = teacherRepository.findById(id);
        if(byId.isPresent()){
            return byId.get();
        } else {
            throw new NotFoundException("Teacher not found", "teacher.not.found");
        }
    }
    public Teacher assignSubjectToTeacher(Long teacherId, Long subjectId){
        Subject subject = subjectService.getSubject(subjectId);
        Teacher teacher = getTeacher(teacherId);

        teacher.setSubject(subject);
        return teacherRepository.save(teacher);
    }

    public Teacher saveTeacher(Teacher teacher) {
        return teacherRepository.save(teacher);
    }

    public Teacher updateTeacher(Long id, Teacher teacher) {
        Optional<Teacher> byId = teacherRepository.findById(id);
        if(byId.isPresent()){
            teacher.setId(id);
            teacher.setSubjects(byId.get().getSubjects());
            return teacherRepository.save(teacher);
        } else {
            throw new NotFoundException("Teacher not found", "teacher.not.found");
        }
    }

    public void deleteTeacher(Long id){
        Optional<Teacher> byId = teacherRepository.findById(id);
        if(byId.isPresent()){
            teacherRepository.deleteById(id);
        }else{
            throw new NotFoundException("Teacher not found", "teacher.not.found");
        }

    }

//    public TeacherDto getTeacher(){
//        TeacherDto dto = new TeacherDto();
//        dto.setFirstName("Ion");
//        dto.setLastName("Popescu");
//        dto.setBirthDate(LocalDate.now());
//        dto.setId(1l);
//        dto.setEmployementDate(LocalDate.now());
//        dto.setSubjects(getSubjects());
//        return dto;
//    }
//    private List<SubjectDto> getSubjects(){
//        SubjectDto subjectDto = new SubjectDto();
//        subjectDto.setId(1l);
//        subjectDto.setCreditPoints(2);
//        subjectDto.setOptional(false);
//        subjectDto.setName("Programare Orientata Obiect");
//        subjectDto.setSubjectScoringDto(new SubjectScoringDto(40,40));
//
//        List<SubjectDto> subjectDtos = new ArrayList<>();
//        subjectDtos.add(subjectDto);
//
//        return subjectDtos;
//    }
}
