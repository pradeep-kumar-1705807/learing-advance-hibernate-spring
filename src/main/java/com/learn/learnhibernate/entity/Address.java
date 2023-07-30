package com.learn.learnhibernate.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Table;


@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Embeddable
public class Address {

    @Column(name = "pin_code")
    private String pinCode;
    private String street;
    private String city;
}
