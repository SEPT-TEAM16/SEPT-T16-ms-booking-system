package com.rmit.septt16msbookingsystem.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Table(name = "doctor_availability")
public class DoctorAvailability {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private String doctorAvailabilityId;
/*
    @ManyToOne
    @JoinColumn(name = "doctor_id", nullable=false)
    private Doctor doctor;

    private Date doctorAvailabilityStartTime;

    //start time + 30 or 15
    private Date doctorAvailabilityEndTime;
*/
}
