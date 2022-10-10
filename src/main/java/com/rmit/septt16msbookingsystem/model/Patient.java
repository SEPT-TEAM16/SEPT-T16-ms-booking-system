package com.rmit.septt16msbookingsystem.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.rmit.septt16msbookingsystem.constants.AppRole;
import lombok.Data;
import lombok.Getter;
import org.hibernate.annotations.Immutable;
import org.hibernate.annotations.Subselect;

import javax.persistence.*;
import java.util.Date;


@Entity
@Getter
@Immutable
@Table(name = "patients")
public class Patient {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "user_id")
    private Integer userId;

    @Column(name="email", nullable=false, unique=true)
    private String email;

    @Column(name="first_name", nullable=false)
    private String firstName;


    @Column(name="last_name", nullable=false)
    private String lastName;

    @Column(name = "password", nullable=false)
    private String password;

    @Column(name="dob", nullable=false)
    @JsonFormat(pattern="dd-MM-yyyy")
    private Date DoB;

    @Column(name="account_active", nullable=false)
    private boolean accountActive;

    @Column(name="address")
    private String address;

    @Column(name="mobile_number")
    private String mobileNumber;

    @Column(name="role", nullable=false)
    @Enumerated(EnumType.STRING)
    private AppRole role = AppRole.ADMIN;
}
