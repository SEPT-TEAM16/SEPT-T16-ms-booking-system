package com.rmit.septt16msbookingsystem.service;

import com.rmit.septt16msbookingsystem.model.AppointmentInfo;
import com.rmit.septt16msbookingsystem.model.Doctor;
import com.rmit.septt16msbookingsystem.model.DoctorAvailability;
import com.rmit.septt16msbookingsystem.repository.AppointmentInfoRepository;
import com.rmit.septt16msbookingsystem.repository.DoctorAvailabilityRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class BookingService {

    DoctorAvailabilityRepository doctorAvailabilityRepository;

    AppointmentInfoRepository appointmentInfoRepository;

    Logger log = LoggerFactory.getLogger(this.getClass().getName());

    public AppointmentInfo saveNewAppointmentDetails(AppointmentInfo appointmentInfo) {
        log.info("Saving appointment details with userInfo={}", appointmentInfo.toString());
        return appointmentInfoRepository.save(appointmentInfo);

    }

    public List<Doctor> getDoctorsListByTime(final Date date) {
        Optional<List<DoctorAvailability>> availableDoctors = Optional.ofNullable(doctorAvailabilityRepository.findAllByDoctorAvailabilityStartTime(date));

       return availableDoctors.map(docList -> docList.stream()
               .map(DoctorAvailability::getDoctor)
               .collect(Collectors.toList()))
               .orElse(Collections.EMPTY_LIST);
    }

}
