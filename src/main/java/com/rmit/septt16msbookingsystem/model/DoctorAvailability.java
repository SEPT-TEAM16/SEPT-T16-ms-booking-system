package com.rmit.septt16msbookingsystem.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Entity
@Data
public class DoctorAvailability {

    @Id
    private String doctorId;
    private String doctorName;
    private Date doctorAvailabilityStartTime;
    private Date doctorAvailabilityEndTime;

}
