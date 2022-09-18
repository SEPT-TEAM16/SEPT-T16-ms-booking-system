package com.rmit.septt16msbookingsystem.service;

import com.rmit.septt16msbookingsystem.model.Doctor;
import com.rmit.septt16msbookingsystem.model.DoctorAvailability;
import com.rmit.septt16msbookingsystem.repository.DoctorAvailabilityRepository;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class BookingService {

    DoctorAvailabilityRepository doctorAvailabilityRepository;

    public List<Doctor> getDoctorsListByTime(final Date date) {
        Optional<List<DoctorAvailability>> availableDoctors = Optional.ofNullable(doctorAvailabilityRepository.findAllByDoctorAvailabilityStartTime(date));

       return availableDoctors.map(docList -> docList.stream()
               .map(DoctorAvailability::getDoctor)
               .collect(Collectors.toList()))
               .orElse(Collections.EMPTY_LIST);
    }

}
