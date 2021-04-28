package com.project.catalog1.converter;

import com.project.catalog1.model.Subject;
import com.project.catalog1.model.Teacher;
import com.project.catalog1.web.dto.SubjectDto;
import com.project.catalog1.web.dto.TeacherDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.stream.Collectors;
@Component
public class TeacherConverter {
    private final SubjectConverter subjectConverter;
    @Autowired
    public TeacherConverter(SubjectConverter subjectConverter) {
        this.subjectConverter = subjectConverter;
    }
    public TeacherDto fromEntityToDto(Teacher teacher) {
        TeacherDto teacherDto = new TeacherDto();
        teacherDto.setId(teacher.getId());
        teacherDto.setEmploymentDate(teacher.getEmploymentDate());
        teacherDto.setBirthDate(teacher.getBirthDate());
        teacherDto.setCnp(teacher.getCnp());
        teacherDto.setSalary(teacher.getSalary());
        teacherDto.setFirstName(teacher.getFirstName());
        teacherDto.setLastName(teacher.getLastName());
        teacherDto.setSubjects(subjectConverter.fromEntitiesToDtos(teacher.getSubjects()));
        return teacherDto;
    }
    public Teacher fromDtoToEntity(TeacherDto dto) {
        Teacher teacher = new Teacher();
        teacher.setFirstName(dto.getFirstName());
        teacher.setLastName(dto.getLastName());
        teacher.setBirthDate(dto.getBirthDate());
        teacher.setEmploymentDate(dto.getEmploymentDate());
        teacher.setCnp(dto.getCnp());
        teacher.setSalary(dto.getSalary());
        return teacher;
    }
    public List<TeacherDto> fromEntitiesToDtos(List<Teacher> entities) {
        return entities
                .stream()
                .map(this::fromEntityToDto)
                .collect(Collectors.toList());
    }
    public List<Teacher> fromDtosToEntities(List<TeacherDto> dtos) {
        return dtos
                .stream()
                .map(this::fromDtoToEntity)
                .collect(Collectors.toList());
    }
}

