package com.example.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "RegistrationEntity")
public class RegistrationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private Long id;



    @Column(name="email",unique = true)
    @NotEmpty(message = "Email cannot be empty")
    @NotBlank(message = "Email can not be empty")
    private String email;



    @Column(name="password")
    @NotBlank(message = "Password is required.")
    @NotEmpty(message = "Password cannot be empty")
    private String Password;


    @Column(name="First_Name")
    @NotBlank(message = "Password is required.")
    @NotEmpty(message = "Password cannot be empty")
    private String First_Name;

    @Column(name="Blood_Group")
    @NotBlank(message = "This field is required.")
    @NotEmpty(message = "This field cannot be empty")
    private String Blood_Group;

    @OneToOne
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    private ProfileEntity profileEntity;

}
