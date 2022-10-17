package com.rmit.septt16msbookingsystem.contoller;

import com.rmit.septt16msbookingsystem.model.AppointmentInfo;
import com.rmit.septt16msbookingsystem.model.Doctor;
import com.rmit.septt16msbookingsystem.model.DoctorAvailability;
import com.rmit.septt16msbookingsystem.model.DoctorSchedule;
import com.rmit.septt16msbookingsystem.repository.AppointmentInfoRepository;
import com.rmit.septt16msbookingsystem.repository.DoctorRepository;
import com.rmit.septt16msbookingsystem.service.BookingService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@Slf4j
@RequestMapping("/api/v1")
public class BookingSystemController {

    @Autowired
    BookingService bookingService;

    @Autowired
    DoctorRepository doctorRepository;

    @PostMapping(path="/create-appointment")
    public ResponseEntity<AppointmentInfo> createNewAppointment(@RequestBody AppointmentInfo appointmentInfo) {
        return new ResponseEntity<>(bookingService.saveNewAppointmentDetails(appointmentInfo), HttpStatus.OK);
    }

    @GetMapping(path="/get-timeslots/{date}")
    public List<Doctor> getAvailableDoctorsByDatetime(@PathVariable String date) throws ParseException {
        log.info("Date being passed to /get-timeslots/{date} endpoint={}", date);
        String newDate = date.toString().replace('T', ' ');
        newDate = newDate.substring(0, newDate.length() - 1);
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        Date parsedDate = formatter.parse(newDate);
        return bookingService.getDoctorsListByTime(parsedDate);
    }

    @GetMapping(path="/get-appointments/{user_id}")
    public ResponseEntity<List<AppointmentInfo>> getAppointmentsForUser(@PathVariable Integer user_id) {
        log.info("Retrieving all appointments for user with user_id={}", user_id);
        return new ResponseEntity<>(bookingService.getAppointmentsByUserId(user_id), HttpStatus.OK);
    }

    @PostMapping(path="/create-doc-availability")
        public ResponseEntity<List<DoctorAvailability>> createDoctorAvailability(@RequestBody DoctorSchedule doctorSchedule) {
        log.info("Creating and storing new schedule for doctor with id={}", doctorSchedule.getDoctorId());
        return new ResponseEntity<>(bookingService.createNewAvailability(doctorSchedule), HttpStatus.OK);
    }

}
