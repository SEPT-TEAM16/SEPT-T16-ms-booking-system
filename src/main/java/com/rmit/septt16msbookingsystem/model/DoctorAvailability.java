package com.rmit.septt16msbookingsystem.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
//@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "doctor_availability")
public class DoctorAvailability {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer doctorAvailabilityId;

    //@ManyToOne
    //@JoinColumn(name = "doctor_id", nullable=false)
    @Column(name="doctor_id")
    private Integer doctorId;

    @Column(name="start_time")
    private Date doctorAvailabilityStartTime;

    @Column(name="end_time")
    private Date doctorAvailabilityEndTime;

}
