package com.rmit.septt16msbookingsystem.contoller;

import com.rmit.septt16msbookingsystem.model.Doctor;
import com.rmit.septt16msbookingsystem.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class BookingSystemController {

    @Autowired
    BookingService bookingService;

    @GetMapping(path="/get-user/{date}")
    public List<Doctor> getAvailableDoctorsByDatetime(@PathVariable Date date) {
        return bookingService.getDoctorsListByTime(date);
    }

}
