package com.rmit.septt16msbookingsystem.model;



import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.hibernate.annotations.Immutable;
import org.hibernate.annotations.Subselect;
import org.hibernate.annotations.Synchronize;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Immutable
//@Subselect("SELECT * FROM doctors")
@Table(name = "doctors")
public class Doctor {

    @Id
    @Column(name = "user_id")
    private Integer userId;

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
