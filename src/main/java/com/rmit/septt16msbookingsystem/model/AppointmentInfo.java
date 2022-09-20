package com.rmit.septt16msbookingsystem.model;

import com.rmit.septt16msbookingsystem.constants.AppointmentStatus;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Table(name = "appointments")
public class AppointmentInfo {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "id")
    private String appointmentId;

    @Column(name="appt_date")
    private Date appointmentStartDate;

    @ManyToOne
    @JoinColumn(name = "patient_id", nullable=false)
    private Patient patient;

    @ManyToOne
    @JoinColumn(name = "doctor_id", nullable=false)
    private Doctor doctor;

    @Column(name = "appointment_status")
    private AppointmentStatus appointmentStatus;


}
