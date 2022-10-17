package com.rmit.septt16msbookingsystem.service;

import com.rmit.septt16msbookingsystem.model.AppointmentInfo;
import com.rmit.septt16msbookingsystem.model.Doctor;
import com.rmit.septt16msbookingsystem.model.DoctorAvailability;
import com.rmit.septt16msbookingsystem.model.DoctorSchedule;
import com.rmit.septt16msbookingsystem.repository.AppointmentInfoRepository;
import com.rmit.septt16msbookingsystem.repository.DoctorAvailabilityRepository;
import com.rmit.septt16msbookingsystem.repository.DoctorRepository;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.*;
import java.util.function.Predicate;
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

    @Autowired
    DoctorRepository doctorRepository;


    public AppointmentInfo saveNewAppointmentDetails(AppointmentInfo appointmentInfo) {
        log.info("Saving appointment details with userInfo={}", appointmentInfo.toString());
        setAppointmentEndDate(appointmentInfo);
        return appointmentInfoRepository.save(appointmentInfo);
    }

    public List<Doctor> getDoctorsListByTime(final Date date) {
        log.info("Retrieving list of doctors by date and time with datetime={}", date);
        List<AppointmentInfo> appointmentInfoList = new ArrayList<>();
        appointmentInfoRepository.findAll().forEach(appointmentInfoList::add);
        List<Doctor> docList = appointmentInfoList.stream()
                .filter(s -> (s.getAppointmentStartDate().before(date) || s.getAppointmentStartDate().equals(date))
                        && (s.getAppointmentEndDate().after(date) || s.getAppointmentEndDate().equals(date)))
                .map(apptInfo -> apptInfo.getDoctor())
                .distinct()
                .collect(Collectors.toList());

        return doctorAvailabilityRepository.findAll()
                .stream()
                .filter(docAvailability -> (docAvailability.getDoctorAvailabilityStartTime().before(date) || docAvailability.getDoctorAvailabilityStartTime().equals(date))
                        && (docAvailability.getDoctorAvailabilityEndTime().after(date) || docAvailability.getDoctorAvailabilityEndTime().equals(date)))
                .map(docAvailability -> docAvailability.getDoctor())
                .filter(doc -> !docList.contains(doc))
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

    public List<AppointmentInfo> getAppointmentsByUserId(final Integer userId) {
        List<AppointmentInfo> appointmentInfoList = new ArrayList<>();
        appointmentInfoRepository.findAll().forEach(appointmentInfoList::add);

        return appointmentInfoList.stream()
                .filter(appt -> appt.getDoctor()
                        .getUserId()
                        .equals(userId)
                || appt.getPatient()
                        .getUserId()
                        .equals(userId))
                .distinct()
                .collect(Collectors.toList());
    }

    public List<DoctorAvailability> createNewAvailability(DoctorSchedule doctorSchedule) {
        List<Doctor> doctorList = new ArrayList<>();
        doctorRepository.findAll().forEach(doctorList::add);
        return doctorSchedule.getSchedule()
                .stream()
                .map(scheduleStartEndPair -> saveDoctorAvailability(DoctorAvailability.builder()
                        .doctor(doctorList.stream()
                                .filter(user -> user.getUserId().equals(doctorSchedule.getDoctorId()))
                                .findAny()
                                .get())
                        .doctorAvailabilityStartTime(scheduleStartEndPair.getStart())
                        .doctorAvailabilityEndTime(scheduleStartEndPair.getEnd())
                        .build())).collect(Collectors.toList());
    }

}
