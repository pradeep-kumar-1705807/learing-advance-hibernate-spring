package com.learn.learnhibernate.service;

import com.learn.learnhibernate.entity.Address;
import com.learn.learnhibernate.entity.Student;
import com.learn.learnhibernate.entity.Teacher;
import com.learn.learnhibernate.entity.User;
import com.learn.learnhibernate.entity.BusDriver;
import com.learn.learnhibernate.entity.enums.Status;
import com.learn.learnhibernate.repository.StudentRepository;
import com.learn.learnhibernate.repository.UserRepository;
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
   @Autowired
    UserRepository userRepository;
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

    public User addUser() {
        Teacher teacher = new Teacher();
        teacher.setSalary("5000");
        teacher.setFirstName("Pradeep");
        teacher.setLastName("Kumar");
        teacher.setEmail("kumarpradeep@bukuWarung.com");

        User user = new BusDriver();
        user.setEmail("userObject.gmail.com");
        user.setFirstName("UserHavingNBusdriver");
        user.setLastName("UserHavingBusdriver");

        BusDriver busDriver = new BusDriver();
        busDriver.setBusNumber(5);
        user.setEmail("busdriuver.gmail.com");
        busDriver.setFirstName("BusDriverInBusDriver");
        busDriver.setLastName("BusDriverInBusDriver");
        userRepository.save(busDriver);
        userRepository.save(teacher);
        return userRepository.save(user);
    }
}
