package com.project.catalog1.service;

import com.project.catalog1.exception.NotFoundException;
import com.project.catalog1.model.Subject;
import com.project.catalog1.repository.SubjectRepository;
import com.project.catalog1.web.dto.SubjectDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SubjectService {
    private final SubjectRepository subjectRepository;

    @Autowired
    public SubjectService(SubjectRepository subjectRepository){
        this.subjectRepository = subjectRepository;
    }
    public List<Subject> getAllSubjects(){
      return  subjectRepository.findAll();
    }

    public  Subject getSubject(Long id){
        Optional<Subject> optionalSubject = subjectRepository.findById(id);
        if(optionalSubject.isPresent()){
            return  optionalSubject.get();
        }
        else {
            throw new NotFoundException("Subject not found","subject.not.found");
        }
    }


    public Subject saveSubject(Subject subjectToBeSaved) {
        Subject savedSubject = subjectRepository.save(subjectToBeSaved);

        return savedSubject;
    }

    public  Subject updateSubject(Subject subjectToBeUpdated, Long id){
        Optional<Subject> subjectOptional = subjectRepository.findById(id);
        if(subjectOptional.isPresent()){
            subjectToBeUpdated.setId(id);
            return subjectRepository.save(subjectToBeUpdated);
        } else{
            throw new NotFoundException("Subject not found","subject.not.found");
        }
    }

    public void deleteSubject(Long id){
        Optional<Subject> subjectOptional = subjectRepository.findById(id);
        if(subjectOptional.isPresent()){
            subjectRepository.deleteById(id);
        } else{
            throw new NotFoundException("Subject not found","subject.not.found");
        }
    }
}
