package com.project.catalog1.web.dto;

import org.springframework.lang.NonNull;

import javax.validation.constraints.NotNull;

public class SubjectDto {

    private Long id;
    @NotNull(message = "name.must.not.be.empty")
    private String name;
    private Integer creditPoints;
    private Boolean isOptional;
    private SubjectScoringDto subjectScoringDto;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCreditPoints() {
        return creditPoints;
    }

    public void setCreditPoints(Integer creditPoints) {
        this.creditPoints = creditPoints;
    }

    public Boolean getOptional() {
        return isOptional;
    }

    public void setOptional(Boolean optional) {
        isOptional = optional;
    }

    public SubjectScoringDto getSubjectScoringDto() {
        return subjectScoringDto;
    }

    public void setSubjectScoringDto(SubjectScoringDto subjectScoringDto) {
        this.subjectScoringDto = subjectScoringDto;
    }
}
