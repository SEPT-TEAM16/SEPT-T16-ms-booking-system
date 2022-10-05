package com.rmit.septt16msbookingsystem.model;

import lombok.Data;

import java.util.List;

@Data
public class DoctorSchedule {

    private Integer doctorId;

    private List<ScheduleStartEndPair> schedule;
}
