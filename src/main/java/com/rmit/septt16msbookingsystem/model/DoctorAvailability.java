package com.rmit.septt16msbookingsystem.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Entity
@Data
public class DoctorAvailability {

    @Id
    @Column(name="", nullable=false, unique=true)
    private String doctorId;

    @Column(name="", nullable=false, unique=true)
    private String doctorName;

    @Column(name="", nullable=false, unique=true)
    private Date doctorAvailabilityStartTime;

    @Column(name="", nullable=false, unique=true)
    private Date doctorAvailabilityEndTime;

}
