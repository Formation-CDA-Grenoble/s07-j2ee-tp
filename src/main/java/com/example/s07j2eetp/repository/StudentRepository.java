package com.example.s07j2eetp.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.s07j2eetp.entity.Student;

@Repository
public interface StudentRepository extends CrudRepository <Student, Long> { 
    List<Student> findByName(String name); 
}
