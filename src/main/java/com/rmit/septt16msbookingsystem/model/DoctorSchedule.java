package com.rmit.septt16msbookingsystem.model;

import lombok.Data;

import java.util.List;

@Data
public class DoctorSchedule {

    private Doctor doctor;

    private List<ScheduleStartEndPair> schedule;
}
