package com.rmit.septt16msbookingsystem.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class AppointmentInfo {

    @Id
    private String apptId;
    private String appt_date;

    // foreign key
   private String patient_id;

    // foreign key
    private String doctor_id;

    private String appt_status;


}
