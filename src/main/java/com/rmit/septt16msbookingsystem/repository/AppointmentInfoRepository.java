package com.rmit.septt16msbookingsystem.repository;

import com.rmit.septt16msbookingsystem.model.AppointmentInfo;
import com.rmit.septt16msbookingsystem.model.DoctorAvailability;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface AppointmentInfoRepository extends CrudRepository<AppointmentInfo, Integer> {

    @Query(value = "select * from appointments where NOT :dateToCheck BETWEEN :startDate AND :endDate",
            nativeQuery = true)
    public List<AppointmentInfo> getAllNotBetweenDates(@Param("dateToCheck") Date dateToCheck, @Param("startDate")Date startDate, @Param("endDate")Date endDate);

}
