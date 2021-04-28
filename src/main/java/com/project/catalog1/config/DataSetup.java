package com.project.catalog1.config;

import com.project.catalog1.model.Subject;
import com.project.catalog1.model.Teacher;
import com.project.catalog1.repository.SubjectRepository;
import com.project.catalog1.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Component
@ConditionalOnExpression("${insert.test.data}")
public class DataSetup implements ApplicationRunner {

    private final SubjectRepository subjectRepository;
    private final TeacherRepository teacherRepository;

//    @Value("${insert.test.data")
//    private Boolean insertTestData;

    @Autowired
    public DataSetup(SubjectRepository subjectRepository, TeacherRepository teacherRepository) {
        this.subjectRepository = subjectRepository;
        this.teacherRepository = teacherRepository;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
  //      if(insertTestData) {
            saveSubject("Matematica", 5, true, 80, 20);
            saveSubject("Fizica", 5, true, 80, 20);
            saveSubject("Chimie", 5, true, 80, 20);

            saveTeacher("First1", "Last1", "CNP1", 110L);
            saveTeacher("First2", "Last2", "CNP2", 110L);
            saveTeacher("First3", "Last3", "CNP3", 110L);
        }
        //  }

    private void saveSubject(String subjectName, Integer creditPoints, Boolean isOptional, Integer coursePercent, Integer seminaryPercent){
        Subject subject = new Subject(subjectName,creditPoints,isOptional,coursePercent,seminaryPercent);
        subjectRepository.save(subject);
    }

    private void saveTeacher(String firstName, String lastName, String cnp,Long salary){
        Teacher teacher = new Teacher(firstName,lastName,cnp,salary);
        teacherRepository.save(teacher);
    }
}
