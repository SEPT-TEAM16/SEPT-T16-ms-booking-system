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

}
