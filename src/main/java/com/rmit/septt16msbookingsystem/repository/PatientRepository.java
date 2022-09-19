package com.rmit.septt16msbookingsystem.repository;

import com.rmit.septt16msbookingsystem.model.Patient;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepository extends CrudRepository<Patient, Integer> {

}
