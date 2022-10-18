package com.rmit.septt16msbookingsystem.model;

import com.rmit.septt16msbookingsystem.constants.AppointmentStatus;
import lombok.*;

import javax.persistence.*;
import java.util.Date;

import static com.rmit.septt16msbookingsystem.constants.Constants.APPOINTMENT_TIME_MINS;
import static com.rmit.septt16msbookingsystem.constants.Constants.ONE_MIN_MILLIS;

@Entity
@Data
@Builder
@AllArgsConstructor
@Table(name = "appointments")
public class AppointmentInfo {
    public AppointmentInfo() {

    }

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "appt_id")
    private Integer appointmentId;

    @Column(name="appt_start_date")
    private Date appointmentStartDate;

    @Column(name="appt_end_date")
    private Date appointmentEndDate;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "patient_id", referencedColumnName = "user_id")
    private Patient patient;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "doctor_id", referencedColumnName = "user_id")
    private Doctor doctor;

    @Column(name = "appt_status")
    @Enumerated(EnumType.STRING)
    private AppointmentStatus appointmentStatus;



    public void setAppointmentEndDate(Date appointmentStartDate) {
        Date appointmentEndDate = new Date(appointmentStartDate.getTime()+(APPOINTMENT_TIME_MINS * ONE_MIN_MILLIS));
        this.appointmentEndDate = appointmentEndDate;
    }

}
