package com.learn.learnhibernate.controller;

import com.learn.learnhibernate.entity.Student;
import com.learn.learnhibernate.service.StudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/v1/student")
public class StudentController {

    @Autowired private StudentServiceImpl service;

    @PostMapping("/")
    public ResponseEntity<Student> addStudent() {
        service.addStudent();
        return  ResponseEntity.ok( service.addStudent());
    }

    @PostMapping("/{id}")
    public ResponseEntity<Student> addStudent(@PathVariable("id") String id) {

        return  ResponseEntity.ok(service.getStudentById(id));
    }
}
