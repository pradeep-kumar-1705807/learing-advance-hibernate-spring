package com.learn.learnhibernate.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import java.time.LocalDateTime;
import java.util.UUID;

@Table(name = "user_table")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@MappedSuperclass
public abstract class User {
    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false)
    private UUID id;

    @Column(name = "first_name", length = 45)
    private String firstName;

    @Column(name = "last_name", length = 45)
    private String lastName;

    @Column(name = "email", length = 45)
    private String email;

    @CreationTimestamp
    private LocalDateTime createdAt;

}
