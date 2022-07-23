package com.example.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "ProfileEntity")
public class ProfileEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private Long id;

    @Column(name="First_Name")
    private String First_Name;

    @Column(name="Last_Name")
    private String Last_Name;

    @Column(name="age")
    private Long age;


    @Column(name="Blood_Group")
    private String Blood_Group;

    @Column(name="City")
    private String City;

    @Column(name="PhoneNumber")
    private Integer PhoneNumber;



}
