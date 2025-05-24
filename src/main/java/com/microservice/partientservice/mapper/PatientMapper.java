package com.microservice.partientservice.mapper;

import com.microservice.partientservice.dto.PatientRequestDTO;
import com.microservice.partientservice.dto.PatientResponseDTO;
import com.microservice.partientservice.modal.Patient;

import java.time.LocalDate;

public class PatientMapper {

    public static PatientResponseDTO toDTO(Patient patient)
    {
        PatientResponseDTO responseDTO = new PatientResponseDTO();

        responseDTO.setId(patient.getId().toString());
        responseDTO.setName(patient.getName().toString());
        responseDTO.setEmail(patient.getEmail().toString());
        responseDTO.setAddress(patient.getAddress().toString());
        responseDTO.setDateOfBirth(patient.getDateofBirth().toString());

        return responseDTO;
    }

    public static Patient toPatient(PatientRequestDTO patientRequestDTO)
    {
        Patient patient = new Patient();

        patient.setName(patientRequestDTO.getName());
        patient.setAddress(patientRequestDTO.getAddress());
        patient.setEmail(patientRequestDTO.getEmail());

        patient.setDateofBirth(LocalDate.parse(patientRequestDTO.getDateOfBirth()));

        patient.setRegisteredDate(LocalDate.parse(patientRequestDTO.getRegisteredDate()));

        return  patient;
    }
}
