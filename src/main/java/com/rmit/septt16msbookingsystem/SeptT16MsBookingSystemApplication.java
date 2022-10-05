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
        return args -> {
            bookingService.saveDoctorAvailability(DoctorAvailability.builder() // Monday
                    .doctorAvailabilityId(1)
                    .doctorId(35)
                    .doctorAvailabilityStartTime(Date.from(OffsetDateTime.parse ("2022-10-10T09:00:00+10:00").toInstant()))
                    .doctorAvailabilityEndTime(Date.from(OffsetDateTime.parse ("2022-10-10T17:00:00+10:00").toInstant()))
                    .build());
            bookingService.saveDoctorAvailability(DoctorAvailability.builder() // Tuesday
                    .doctorAvailabilityId(2)
                    .doctorId(35)
                    .doctorAvailabilityStartTime(Date.from(OffsetDateTime.parse ("2022-10-11T09:00:00+10:00").toInstant()))
                    .doctorAvailabilityEndTime(Date.from(OffsetDateTime.parse ("2022-10-11T17:00:00+10:00").toInstant()))
                    .build());
            bookingService.saveDoctorAvailability(DoctorAvailability.builder() // Wednesday
                    .doctorAvailabilityId(3)
                    .doctorId(35)
                    .doctorAvailabilityStartTime(Date.from(OffsetDateTime.parse ("2022-10-12T09:00:00+10:00").toInstant()))
                    .doctorAvailabilityEndTime(Date.from(OffsetDateTime.parse ("2022-10-12T17:00:00+10:00").toInstant()))
                    .build());
            bookingService.saveDoctorAvailability(DoctorAvailability.builder() // Thursday
                    .doctorAvailabilityId(4)
                    .doctorId(35)
                    .doctorAvailabilityStartTime(Date.from(OffsetDateTime.parse ("2022-10-13T09:00:00+10:00").toInstant()))
                    .doctorAvailabilityEndTime(Date.from(OffsetDateTime.parse ("2022-10-13T17:00:00+10:00").toInstant()))
                    .build());
            bookingService.saveDoctorAvailability(DoctorAvailability.builder() // Friday
                    .doctorAvailabilityId(5)
                    .doctorId(35)
                    .doctorAvailabilityStartTime(Date.from(OffsetDateTime.parse ("2022-10-14T09:00:00+10:00").toInstant()))
                    .doctorAvailabilityEndTime(Date.from(OffsetDateTime.parse ("2022-10-14T17:00:00+10:00").toInstant()))
                    .build());
        };
    }

}
