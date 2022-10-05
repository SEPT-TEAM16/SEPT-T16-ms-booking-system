package com.rmit.septt16msbookingsystem.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
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

    //@ManyToOne
    //@JoinColumn(name = "doctor_id", nullable=false)
    @Column(name="doctor_id")
    private Integer doctorId;

    @Column(name="start_time")
    private Date doctorAvailabilityStartTime;

    @Column(name="end_time")
    private Date doctorAvailabilityEndTime;

}
