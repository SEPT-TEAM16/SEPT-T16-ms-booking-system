package com.rmit.septt16msbookingsystem.repository;

import com.rmit.septt16msbookingsystem.model.AppointmentInfo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppointmentInfoRepository extends CrudRepository<AppointmentInfo, Integer> {

}
