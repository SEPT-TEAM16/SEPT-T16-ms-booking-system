package com.rmit.septt16msbookingsystem;

import com.rmit.septt16msbookingsystem.model.Doctor;
import com.rmit.septt16msbookingsystem.model.DoctorAvailability;
import com.rmit.septt16msbookingsystem.service.BookingService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.Instant;
import java.time.OffsetDateTime;
import java.util.Date;

@SpringBootApplication
public class SeptT16MsBookingSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(SeptT16MsBookingSystemApplication.class, args);
    }

    @Bean
    CommandLineRunner run(BookingService bookingService) {
        //DoctorAvailability.builder().
        return args -> {
            bookingService.saveDoctorAvailability(new DoctorAvailability(
                    1,
                    35,
                    Date.from(OffsetDateTime.parse (  "2022-09-28T08:30:00+10:00").toInstant()),
                    Date.from(OffsetDateTime.parse (  "2022-09-28T20:30:00+10:00").toInstant())));
        };
    }

}
