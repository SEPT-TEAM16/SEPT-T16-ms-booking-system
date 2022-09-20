package com.rmit.septt16msbookingsystem.repository;

import com.rmit.septt16msbookingsystem.model.DoctorAvailability;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface DoctorAvailabilityRepository extends CrudRepository<DoctorAvailability, Integer> {

    List<DoctorAvailability> findAllByDoctorAvailabilityStartTime(Date doctorAvailabilityStartTime);

}
