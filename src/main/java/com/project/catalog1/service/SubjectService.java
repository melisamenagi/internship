package com.project.catalog1.service;

import com.project.catalog1.model.Subject;
import com.project.catalog1.repository.SubjectRepository;
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
            throw new RuntimeException("Subject not found");
        }
    }
}
