package com.student.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.student.data.model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
	
	

}