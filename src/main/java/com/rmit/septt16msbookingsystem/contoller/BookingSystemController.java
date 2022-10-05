package com.rmit.septt16msbookingsystem.contoller;

import com.rmit.septt16msbookingsystem.model.AppointmentInfo;
import com.rmit.septt16msbookingsystem.model.Doctor;
import com.rmit.septt16msbookingsystem.model.DoctorAvailability;
import com.rmit.septt16msbookingsystem.model.DoctorSchedule;
import com.rmit.septt16msbookingsystem.repository.AppointmentInfoRepository;
import com.rmit.septt16msbookingsystem.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1")
public class BookingSystemController {

    @Autowired
    BookingService bookingService;

    @PostMapping(path="/create-appointment")
    public ResponseEntity<AppointmentInfo> createNewAppointment(@RequestBody AppointmentInfo appointmentInfo) {
        return new ResponseEntity<>(bookingService.saveNewAppointmentDetails(appointmentInfo), HttpStatus.OK);
    }

    @GetMapping(path="/get-timeslots/{date}")
    public List<Doctor> getAvailableDoctorsByDatetime(@PathVariable Date date) {
        return bookingService.getDoctorsListByTime(date);
    }

    @PostMapping(path="/create-doc-availability")
        public ResponseEntity<List<DoctorAvailability>> createDoctorAvailability(@RequestBody DoctorSchedule doctorSchedule) {
        return new ResponseEntity<>(doctorSchedule.getSchedule()
                .stream()
                .map(scheduleStartEndPair -> {
                    return bookingService.saveDoctorAvailability(DoctorAvailability.builder()
                            .doctor(doctorSchedule.getDoctor())
                            .doctorAvailabilityStartTime(scheduleStartEndPair.getStart())
                            .doctorAvailabilityEndTime(scheduleStartEndPair.getEnd())
                            .build());
        }).collect(Collectors.toList()), HttpStatus.OK);
    }

}
