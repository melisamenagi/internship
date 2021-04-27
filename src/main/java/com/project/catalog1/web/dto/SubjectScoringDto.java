package com.project.catalog1.web.dto;

import org.springframework.lang.NonNull;

public class SubjectScoringDto {


    private Integer coursePercent;
    private Integer seminaryPercent;

    public SubjectScoringDto() {
    }

    public SubjectScoringDto(Integer coursePercent, Integer seminaryPercent) {
        this.coursePercent = coursePercent;
        this.seminaryPercent = seminaryPercent;
    }

    public Integer getCoursePercent() {
        return coursePercent;
    }

    public void setCoursePercent(Integer coursePercent) {
        this.coursePercent = coursePercent;
    }

    public Integer getSeminaryPercent() {
        return seminaryPercent;
    }

    public void setSeminaryPercent(Integer seminaryPercent) {
        this.seminaryPercent = seminaryPercent;
    }
}
