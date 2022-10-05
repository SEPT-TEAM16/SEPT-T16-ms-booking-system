package com.rmit.septt16msbookingsystem.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "doctor_availability")
public class DoctorAvailability {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer doctorAvailabilityId;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "doctor_id", referencedColumnName = "user_id")
    private Doctor doctor;

    @Column(name="start_time")
    private Date doctorAvailabilityStartTime;

    @Column(name="end_time")
    private Date doctorAvailabilityEndTime;

}
