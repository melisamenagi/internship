package com.project.catalog1.repository;

import com.project.catalog1.model.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubjectRepository extends JpaRepository<Subject, Long>  { //tipul clasei si tipul cheii primare
}
