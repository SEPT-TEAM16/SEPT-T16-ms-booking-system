package com.rmit.septt16msbookingsystem.contoller;

import com.rmit.septt16msbookingsystem.model.AppointmentInfo;
import com.rmit.septt16msbookingsystem.model.Doctor;
import com.rmit.septt16msbookingsystem.model.DoctorAvailability;
import com.rmit.septt16msbookingsystem.repository.AppointmentInfoRepository;
import com.rmit.septt16msbookingsystem.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

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
        public ResponseEntity<DoctorAvailability> createDoctorAvailability(@RequestBody DoctorAvailability[] doctorAvailabilities) {
        return null;
    }

}
