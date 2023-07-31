package com.learn.learnhibernate.entity.enums;

import com.learn.learnhibernate.entity.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Getter
@Entity
@Setter
@NoArgsConstructor
@DiscriminatorValue(value = "DRIVER")
public class BusDriver extends User {
    private int busNumber;
}
