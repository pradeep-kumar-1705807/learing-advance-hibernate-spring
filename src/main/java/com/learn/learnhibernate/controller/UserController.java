package com.learn.learnhibernate.controller;

import com.learn.learnhibernate.entity.User;
import com.learn.learnhibernate.entity.UserProfile;
import com.learn.learnhibernate.repository.UserProfileRepository;
import com.learn.learnhibernate.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/v1/user")
public class UserController {
    @Autowired private  UserRepository userRepository;
    @Autowired private UserProfileRepository userProfileRepository;

    @PostMapping("/create")
    ResponseEntity<UserProfile> createUser() {

        User user = userRepository.save(User.builder()
                .username(UUID.randomUUID().toString())
                .password(UUID.randomUUID().toString())
                .build());
        UserProfile userProfile = userProfileRepository.save(UserProfile.builder()
                .user(user)
                .fullName("Pradeep Kumar " + UUID.randomUUID())
                .email("PK" + UUID.randomUUID() + "@gmail.com")
                .phoneNumber(UUID.randomUUID().toString())
                .build());
        return  ResponseEntity.ok(userProfile);
    }

    @DeleteMapping("/delete/{id}")
    ResponseEntity<UserProfile> deleteUserProfile(@PathVariable("id") String id) {

        Optional<UserProfile> userProfileOpt = userProfileRepository.findById(UUID.fromString(id));
        userProfileRepository.deleteById(UUID.fromString(id));
        return  ResponseEntity.ok(userProfileOpt.get());
    }

    @DeleteMapping("/delete")
    ResponseEntity<List<UserProfile>> deleteUserProfile() {

        List<UserProfile> userProfiles = userProfileRepository.findAll();
        userProfileRepository.deleteAll();
        return  ResponseEntity.ok(userProfiles);
    }

    @PostMapping("/{userId}")
    ResponseEntity<UserProfile> findByUserId(@PathVariable("userId") String userId) {

        UserProfile userProfile = userProfileRepository.findByUser_Id(UUID.fromString(userId));
        return  ResponseEntity.ok(userProfile);
    }

    @PostMapping("/profile/{userProfileId}")
    ResponseEntity<User> findByUserProfilerByUserId(@PathVariable("userProfileId") String userProfileId) {
        User user= userRepository.findByUserProfile_Id(UUID.fromString(userProfileId));
        return  ResponseEntity.ok(user);
    }
}
