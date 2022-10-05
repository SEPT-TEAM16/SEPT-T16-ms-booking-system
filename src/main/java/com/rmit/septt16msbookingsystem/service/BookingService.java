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
        Optional<List<DoctorAvailability>> availableDoctors = Optional.ofNullable(doctorAvailabilityRepository.findAllByDoctorAvailabilityStartTime(date));

       return availableDoctors.map(docList -> docList.stream()
               .map(DoctorAvailability::getDoctorId)
               .collect(Collectors.toList()))
               .orElse(Collections.EMPTY_LIST);
    }

    private void setAppointmentEndDate(AppointmentInfo appointmentInfo) {
        final Integer APPOINTMENT_TIME_MINS = 30;
        final Integer ONE_MIN_MILLIS = 60000;
        Date appointmentEndDate = new Date(appointmentInfo.getAppointmentStartDate().getTime()+(APPOINTMENT_TIME_MINS*ONE_MIN_MILLIS));
        appointmentInfo.setAppointmentEndDate(appointmentEndDate);
    }

    public DoctorAvailability saveDoctorAvailability(DoctorAvailability doctorAvailability) {
        log.info("Saving doctor availability details with userInfo={}", doctorAvailability.toString());
        return doctorAvailabilityRepository.save(doctorAvailability);
    }

}
