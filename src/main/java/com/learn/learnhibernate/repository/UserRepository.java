package com.learn.learnhibernate.repository;

import com.learn.learnhibernate.entity.Student;
import com.learn.learnhibernate.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserRepository  extends JpaRepository<User, UUID> {
}
