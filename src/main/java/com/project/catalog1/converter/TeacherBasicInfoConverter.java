package com.project.catalog1.converter;

import com.project.catalog1.model.Teacher;
import com.project.catalog1.web.dto.TeacherBasicInfoDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class TeacherBasicInfoConverter {

    private final SubjectConverter subjectConverter;

    @Autowired
    public TeacherBasicInfoConverter(SubjectConverter subjectConverter) {
        this.subjectConverter = subjectConverter;
    }

    public TeacherBasicInfoDto fromEntityToDto(Teacher teacher) {
        TeacherBasicInfoDto dto = new TeacherBasicInfoDto();
        dto.setId(teacher.getId());
        dto.setFirstName(teacher.getFirstName());
        dto.setLastName(teacher.getLastName());
        dto.setSubjects(subjectConverter.fromEntitiesToDtos(teacher.getSubjects()));

        return dto;
    }

    public List<TeacherBasicInfoDto> fromEntitiesToDtos(List<Teacher> entities) {
        return entities
                .stream()
                .map(this::fromEntityToDto)
                .collect(Collectors.toList());
    }
}