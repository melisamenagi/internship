package com.project.catalog1.web.dto;

import java.time.LocalDate;
import java.util.List;

//used when we need to send all the Teacher related information (e.g.: if we need to display them from Teacher's user profile
public class TeacherDto extends TeacherBasicInfoDto{

    private String cnp;
    private LocalDate birthDate;
    private LocalDate employmentDate;
    private Long salary;

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public LocalDate getEmploymentDate() {
        return employmentDate;
    }

    public void setEmploymentDate(LocalDate employementDate) {
        this.employmentDate = employementDate;
    }

    public Long getSalary() {
        return salary;
    }

    public void setSalary(Long salary) {
        this.salary = salary;
    }

    public String getCnp() {
        return cnp;
    }

    public void setCnp(String cnp) {
        this.cnp = cnp;
    }

    @Override
    public String toString() {
        return "TeacherDto{" +
                "cnp='" + cnp + '\'' +
                ", birthDate=" + birthDate +
                ", employementDate=" + employmentDate +
                ", salary=" + salary +
                '}';
    }
}
