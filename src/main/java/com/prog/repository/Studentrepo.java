package com.prog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.prog.entity.Student;


@Repository
public interface Studentrepo extends JpaRepository<Student, Integer>{

}
