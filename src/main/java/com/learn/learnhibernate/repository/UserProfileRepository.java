package com.learn.learnhibernate.repository;

import com.learn.learnhibernate.entity.User;
import com.learn.learnhibernate.entity.UserProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserProfileRepository extends JpaRepository<UserProfile, UUID> {
    UserProfile findByUser_Id(UUID id);

}
