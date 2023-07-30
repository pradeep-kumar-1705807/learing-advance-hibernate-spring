package com.learn.learnhibernate.repository;

import com.learn.learnhibernate.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface StudentRepository extends JpaRepository<Student, UUID> {
    Student findAllById(UUID id);
}