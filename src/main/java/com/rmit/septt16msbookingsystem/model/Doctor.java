package com.rmit.septt16msbookingsystem.model;



import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.annotations.Immutable;
import org.hibernate.annotations.Subselect;

import javax.persistence.*;
import java.util.Date;

@Entity
@Immutable
@Table(name = "doctors")
@Subselect("SELECT * from users WHERE role LIKE 'DOCTOR'")
public class Doctor {

    @Id
    @Column(name = "doctor_id")
    private Integer doctorId;

    @Column(name="email")
    private String email;

    @Column(name="first_name")
    private String firstName;

    @Column(name="last_name")
    private String lastName;

    @Column(name = "password")
    private String password;

    @Column(name="dob")
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date DoB;

    @Column(name="account_active")
    private boolean accountActive;

    @Column(name="address")
    private String address;

    @Column(name="mobile_number")
    private String mobileNumber;

}
