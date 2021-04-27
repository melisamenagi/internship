package com.project.catalog1.service;

import com.project.catalog1.web.dto.SubjectDto;
import com.project.catalog1.web.dto.SubjectScoringDto;
import com.project.catalog1.web.dto.TeacherDto;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class TeacherService {

    public TeacherDto getTeacher(){
        TeacherDto dto = new TeacherDto();
        dto.setFirstName("Ion");
        dto.setLastName("Popescu");
        dto.setBirthDate(LocalDate.now());
        dto.setId(1l);
        dto.setEmployementDate(LocalDate.now());
        dto.setSubjects(getSubjects());
        return dto;
    }
    private List<SubjectDto> getSubjects(){
        SubjectDto subjectDto = new SubjectDto();
        subjectDto.setId(1l);
        subjectDto.setCreditPoints(2);
        subjectDto.setOptional(false);
        subjectDto.setName("Programare Orientata Obiect");
        subjectDto.setSubjectScoringDto(new SubjectScoringDto(40,40));

        List<SubjectDto> subjectDtos = new ArrayList<>();
        subjectDtos.add(subjectDto);

        return subjectDtos;
    }
}
