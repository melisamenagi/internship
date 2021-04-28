package com.project.catalog1.repository;

import com.project.catalog1.model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher,Long> { //extends JpaRepo e suficient sa scrii definitiile de la metode

    List<Teacher> findByFirstName(String firstName); //select * from teacher where first_name = "   "
    List<Teacher> findByFirstNameAndLastName(String firstName, String lastName); //select * from teacher where first_name = ".." and last_name = "..'
    Optional<Teacher> findByCnp(String cnp); //merge si count, delete


}
