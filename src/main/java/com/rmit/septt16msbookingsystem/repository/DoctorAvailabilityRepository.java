package com.rmit.septt16msbookingsystem.repository;

import com.rmit.septt16msbookingsystem.model.DoctorAvailability;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface DoctorAvailabilityRepository extends CrudRepository<DoctorAvailability, Integer> {

    List<DoctorAvailability> findAllByDoctorAvailabilityStartTime(Date doctorAvailabilityStartTime);

    List<DoctorAvailability> findAll();

    @Query(value = "select * from doctor_availability where start_time < :dateToCheck AND end_time > :dateToCheck",
            nativeQuery = true)
    public List<DoctorAvailability> getAllBetweenDates(@Param("dateToCheck")Date dateToCheck);

}
