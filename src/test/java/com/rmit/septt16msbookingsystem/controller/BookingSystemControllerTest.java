package com.rmit.septt16msbookingsystem.controller;

import com.rmit.septt16msbookingsystem.constants.AppointmentStatus;
import com.rmit.septt16msbookingsystem.contoller.BookingSystemController;
import com.rmit.septt16msbookingsystem.model.AppointmentInfo;
import com.rmit.septt16msbookingsystem.service.BookingService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import org.springframework.http.HttpHeaders;

import java.time.OffsetDateTime;
import java.util.Date;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
public class BookingSystemControllerTest {

    @InjectMocks
    private BookingSystemController bookingSystemController;

    @Mock
    private BookingService bookingService;

    private HttpHeaders httpHeaders;

    @BeforeEach
    public void setUp() {
        httpHeaders = new HttpHeaders();
        httpHeaders.add(HttpHeaders.CONTENT_TYPE, "application/json");
    }

    @Test
    public void createAppointment_validAppointmentInfo_returnSuccess() throws Exception {

        AppointmentInfo appointmentInfo = AppointmentInfo.builder()
                .appointmentStartDate(Date.from(OffsetDateTime.parse("2022-10-10T09:00:00+10:00").toInstant()))
                .appointmentStatus(AppointmentStatus.ACTIVE)
                .build();

        appointmentInfo.setAppointmentEndDate(Date.from(OffsetDateTime.parse("2022-10-10T09:00:00+10:00").toInstant()));
        bookingSystemController.createNewAppointment(appointmentInfo);

        verify(bookingService, times(1)).saveNewAppointmentDetails(any());
    }


}
