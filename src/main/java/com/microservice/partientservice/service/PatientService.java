package com.microservice.partientservice.service;

import com.microservice.partientservice.dto.PatientRequestDTO;
import com.microservice.partientservice.dto.PatientResponseDTO;
import com.microservice.partientservice.modal.Patient;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

public interface PatientService {

    List<PatientResponseDTO> getAllPatients();

    PatientResponseDTO getPatient(UUID id);

    PatientResponseDTO addPatient(PatientRequestDTO patient);

    PatientResponseDTO updatePatient(UUID id,PatientRequestDTO patient);

    void deletePatient(UUID id);
}
