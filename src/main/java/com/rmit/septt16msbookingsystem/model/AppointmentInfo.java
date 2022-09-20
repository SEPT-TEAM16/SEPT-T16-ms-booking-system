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
    @Column(name = "appt_id")
    private Integer appointmentId;

    @Column(name="appt_start_date")
    private Date appointmentStartDate;

    @Column(name="appt_end_date")
    private Date appointmentEndDate;

//    @ManyToOne
//    @JoinColumn(name = "patient_id", nullable=false)
    @Column(name="patient_id")
    private Integer patientId;

//    @ManyToOne
//    @JoinColumn(name = "doctor_id", nullable=false)
    @Column(name="doctor_id")
    private Integer doctorId;

    @Column(name = "appt_status")
    @Enumerated(EnumType.STRING)
    private AppointmentStatus appointmentStatus;


}
