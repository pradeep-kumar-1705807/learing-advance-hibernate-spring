package com.learn.learnhibernate.entity;

import lombok.*;

import javax.annotation.processing.Generated;
import javax.persistence.*;
import java.util.UUID;

@Table(name = "user_profile")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Builder
public class UserProfile {
    @Id
    @GeneratedValue
    private UUID id;

    private String fullName;
    private String phoneNumber;
    private String email;

    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

}
