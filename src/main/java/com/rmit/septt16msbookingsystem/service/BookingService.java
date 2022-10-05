package com.rmit.septt16msbookingsystem.service;

import com.rmit.septt16msbookingsystem.model.AppointmentInfo;
import com.rmit.septt16msbookingsystem.model.Doctor;
import com.rmit.septt16msbookingsystem.model.DoctorAvailability;
import com.rmit.septt16msbookingsystem.repository.AppointmentInfoRepository;
import com.rmit.septt16msbookingsystem.repository.DoctorAvailabilityRepository;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.rmit.septt16msbookingsystem.constants.Constants.APPOINTMENT_TIME_MINS;
import static com.rmit.septt16msbookingsystem.constants.Constants.ONE_MIN_MILLIS;

@Slf4j
@Service
public class BookingService {

    @Autowired
    DoctorAvailabilityRepository doctorAvailabilityRepository;

    @Autowired
    AppointmentInfoRepository appointmentInfoRepository;


    public AppointmentInfo saveNewAppointmentDetails(AppointmentInfo appointmentInfo) {
        log.info("Saving appointment details with userInfo={}", appointmentInfo.toString());
        setAppointmentEndDate(appointmentInfo);
        return appointmentInfoRepository.save(appointmentInfo);
    }

    public List<Doctor> getDoctorsListByTime(final Date date) {
        // Date can be between start and end doctor availabilities
        // but must also not be occupied by exisitng appointment... TODO

        return doctorAvailabilityRepository.findAll()
                .stream()
                .map(docAvailability -> // Between dates in doctorAvailability repository
                        doctorAvailabilityRepository.getAllBetweenDates(date)
                .map(da -> da.stream()
                        .map(availability -> // Between dates in appointmentInfo repository
                                appointmentInfoRepository.getAllNotBetweenDates(date))
                        .flatMap(List::stream)
                        .collect(Collectors.toList()))
                .flatMap(List::stream)
                .map(AppointmentInfo::getDoctor)
                .collect(Collectors.toList());
    }

    private void setAppointmentEndDate(AppointmentInfo appointmentInfo) {
        Date appointmentEndDate = new Date(appointmentInfo.getAppointmentStartDate().getTime()+(APPOINTMENT_TIME_MINS * ONE_MIN_MILLIS));
        appointmentInfo.setAppointmentEndDate(appointmentEndDate);
    }

    public DoctorAvailability saveDoctorAvailability(DoctorAvailability doctorAvailability) {
        log.info("Saving doctor availability details with doctorAvailabilities={}", doctorAvailability.toString());
        return doctorAvailabilityRepository.save(doctorAvailability);
    }

}
