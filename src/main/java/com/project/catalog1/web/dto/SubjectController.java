package com.project.catalog1.web.dto;

import com.project.catalog1.converter.SubjectConverter;
import com.project.catalog1.model.Subject;
import com.project.catalog1.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/subject")
public class SubjectController {

    private final SubjectService subjectService;
    private final SubjectConverter subjectConverter;
    
    @Autowired
    public SubjectController(SubjectService subjectService, SubjectConverter subjectConverter){
        this.subjectService = subjectService;
        this.subjectConverter = subjectConverter;
    }
    @GetMapping(value = "")
    public List<SubjectDto> getSubjects(){
        List<Subject> subjects = subjectService.getAllSubjects();
        
        return  subjectConverter.fromEntitiesToDtos(subjects);
    }
    
    @GetMapping(value = "/{id}")
    public SubjectDto getSubject(@PathVariable Long id){//in order to take variables from URL we can use @PathVariable
        Subject subject = subjectService.getSubject(id);

        return subjectConverter.fromEntityToDto(subject);
    }

    @PostMapping(value = "")
    public SubjectDto saveNewSubject(@RequestBody SubjectDto request){
        Subject subjectToBeSaved = subjectConverter.fromDtoToEntity(request);
        Subject savedSubject = subjectService.saveSubject(subjectToBeSaved);

        return subjectConverter.fromEntityToDto(savedSubject);
    }
}
