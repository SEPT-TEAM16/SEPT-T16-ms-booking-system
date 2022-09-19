package com.rmit.septt16msbookingsystem.repository;

import com.rmit.septt16msbookingsystem.model.Doctor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DoctorRepository extends CrudRepository<Doctor, Integer> {
}
