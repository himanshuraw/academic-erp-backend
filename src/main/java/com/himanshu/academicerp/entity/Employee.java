package com.himanshu.academicerp.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "firstName")
    private String firstName;

    @Column(name = "lastName")
    private String lastName;

    @Column(name ="email", unique = true, nullable = false)
    private String email;

    @Column(name = "photographPath")
    private String photographPath;

    @Column(name = "department")
    private String department;
}
