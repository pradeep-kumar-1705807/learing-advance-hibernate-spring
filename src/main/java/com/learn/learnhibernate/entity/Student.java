package com.learn.learnhibernate.entity;

import com.learn.learnhibernate.entity.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Generated;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapKeyColumn;
import javax.persistence.OrderBy;
import javax.persistence.OrderColumn;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import java.util.UUID;

import static java.lang.annotation.ElementType.METHOD;

@Table(name = "student")
@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Student {

    @Id
    @GeneratedValue()
    @Column(name = "id", nullable = false)
    private UUID id;

    @Column(name = "first_name", length = 45)
    private String firstName;

    @Column(name = "last_name", length = 45)
    private String lastName;

    @Column(name = "email", length = 45)
    private String email;


    @ElementCollection
    @CollectionTable(name = "image")
    @MapKeyColumn(name = "image_name")
    @OrderBy(value = "image_name DESC")
    @Column(name = "image_url")
    private Map<String, String> images = new LinkedHashMap<>();

    @Embedded
    private Address address;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name="pinCode",
                    column=@Column(name="billing_pinCode")),
            @AttributeOverride(name="street",
                    column=@Column(name="billing_street")),
            @AttributeOverride(name="city",
                    column=@Column(name="billing_city"))
    })
    private  Address billingAddress;


    @Enumerated(EnumType.STRING)
    private Status status;
}
