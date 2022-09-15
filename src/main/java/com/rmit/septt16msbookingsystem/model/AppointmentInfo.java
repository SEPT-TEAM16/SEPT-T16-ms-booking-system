package com.rmit.septt16msbookingsystem.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Table(name = "appointments")
public class AppointmentInfo {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private String apptId;


    private Date appt_date;

    @ManyToOne
    @JoinColumn(name = "patient_id", nullable=false)
   private Patient patient;

    @ManyToOne
    @JoinColumn(name = "doctor_id", nullable=false)
    private Doctor doctor;

    //approved, cancelled
    private String appt_status;


}
