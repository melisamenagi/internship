package com.project.catalog1.web.dto;  //objects that are used as response body; what the FE application receives

import org.springframework.lang.NonNull;

import javax.validation.constraints.NotNull;


public class SubjectDto {
//Other validation annotations @Min, @Max, @Pattern

    private Long id;
    @NotNull(message = "name.cannot.be.empty")
    private String name;
    @NotNull(message = "credit.point.cannot.be.empty")
    private Integer creditPoints;
    @NotNull(message = "optional.cannot.be.empty")
    private Boolean isOptional;
    @NotNull(message = "subject.scoring.cannot.be.empty")
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
