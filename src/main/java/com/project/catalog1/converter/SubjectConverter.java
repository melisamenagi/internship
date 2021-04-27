package com.project.catalog1.converter;

import com.project.catalog1.model.Subject;
import com.project.catalog1.web.dto.SubjectDto;
import com.project.catalog1.web.dto.SubjectScoringDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class SubjectConverter {

    public List<SubjectDto> fromEntitiesToDtos(List<Subject> entities){
        return entities
                .stream()
                .map(this::fromEntityToDto)
                .collect(Collectors.toList());
    }

    public SubjectDto fromEntityToDto(Subject entity){
        SubjectDto subjectDto = new SubjectDto();
        subjectDto.setId(entity.getId());
        subjectDto.setName(entity.getName());
        subjectDto.setOptional(entity.getOptional());
        subjectDto.setCreditPoints(entity.getCreditPoints());
        subjectDto.setSubjectScoringDto(new SubjectScoringDto(entity.getCoursePercent(), entity.getSeminaryPercent()));

        return subjectDto;
    }

    public Subject fromDtoToEntity(SubjectDto dto){
        Subject entity = new Subject();
        entity.setName(dto.getName());
        entity.setCreditPoints(dto.getCreditPoints());
        entity.setOptional(dto.getOptional());
        entity.setCoursePercent(dto.getSubjectScoringDto().getCoursePercent());
        entity.setSeminaryPercent(dto.getSubjectScoringDto().getSeminaryPercent());

        return entity;
    }
}
