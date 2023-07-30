package com.learn.learnhibernate.service;

import com.learn.learnhibernate.entity.Address;
import com.learn.learnhibernate.entity.Student;
import com.learn.learnhibernate.entity.enums.Status;
import com.learn.learnhibernate.repository.StudentRepository;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Transactional
public class StudentServiceImpl {

   @Autowired
    StudentRepository repository;
    public Student addStudent() {
        Student student = Student.builder()
                .firstName("pradeep")
                .lastName("kumar")
                .email("kumarpradee@gmail.com")
                .images(Arrays.asList("image-4","image-1","image-43").stream().collect(Collectors.toMap(
                        str -> str,str -> "https://www.cdn.com/"+str)))
                .address(Address.builder()
                        .pinCode("834009")
                        .city("ranchi")
                        .street("bariatu")
                        .build())
                .billingAddress(Address.builder()
                        .pinCode("834008")
                        .city("patratu")
                        .street("highway")
                        .build())
                .status(Status.INACTIVE)
                .build();
     return repository.save(student);
    }

    @SneakyThrows
    public Student getStudentById(String id) {
       return repository.findAllById(UUID.fromString(id));
    }


}
