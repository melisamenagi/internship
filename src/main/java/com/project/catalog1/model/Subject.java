package com.project.catalog1.model;

import javax.persistence.*;

@Entity
@Table(name = "subject")
public class Subject {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "credit_points")
    private Integer creditPoints;

    @Column(name = "is_optional")
    private Boolean isOptional;

    @Column(name = "course_percent")
    private Integer coursePercent;

    @Column(name = "seminary_percent")
    private Integer seminaryPercent;

    public Subject() {
    }

    public Subject(String name, Integer creditPoints, Boolean isOptional, Integer coursePercent, Integer seminaryPercent) {
        this.name = name;
        this.creditPoints = creditPoints;
        this.isOptional = isOptional;
        this.coursePercent = coursePercent;
        this.seminaryPercent = seminaryPercent;
    }

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

    @Override
    public String toString() {
        return "Subject{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", creditPoints=" + creditPoints +
                ", isOptional=" + isOptional +
                ", coursePercent=" + coursePercent +
                ", seminaryPercent=" + seminaryPercent +
                '}';
    }
}
