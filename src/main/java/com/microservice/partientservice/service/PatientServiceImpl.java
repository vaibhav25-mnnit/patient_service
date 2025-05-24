package com.microservice.partientservice.service;

import com.microservice.partientservice.dto.PatientRequestDTO;
import com.microservice.partientservice.dto.PatientResponseDTO;
import com.microservice.partientservice.exception.EmailAlreadyExistException;
import com.microservice.partientservice.exception.PatientNotFoundException;
import com.microservice.partientservice.mapper.PatientMapper;
import com.microservice.partientservice.modal.Patient;
import com.microservice.partientservice.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Service
public class PatientServiceImpl implements PatientService{
    PatientRepository patientRepository;

    @Autowired
    PatientServiceImpl(PatientRepository patientRepository)
    {
        this.patientRepository = patientRepository;
    }

    @Override
    public List<PatientResponseDTO> getAllPatients() {
        List<Patient> patients =  patientRepository.findAll();
        return patients.stream().map(PatientMapper::toDTO).toList();
    }

    @Override
    public PatientResponseDTO getPatient(UUID id)
    {
        Patient foundPatient = patientRepository.findById(id).orElseThrow(()-> new PatientNotFoundException("Patient not found with ID: "+id));

        return PatientMapper.toDTO(foundPatient);
    }
    @Override
    public PatientResponseDTO addPatient(PatientRequestDTO patient) {
        if(patientRepository.existsByEmail(patient.getEmail())){
            throw  new EmailAlreadyExistException("A patient with "+patient.getEmail()+"email already exists.");
        }
        Patient newPatient = patientRepository.save(PatientMapper.toPatient(patient));
        System.out.println(newPatient);
        return PatientMapper.toDTO(newPatient);
    }

    @Override
    public PatientResponseDTO updatePatient(UUID id, PatientRequestDTO patient) {
        Patient foundPatient = patientRepository.findById(id).orElseThrow(()-> new PatientNotFoundException("Patient not found with ID: "+id));

        if(patientRepository.existsByEmailAndIdNot(patient.getEmail(),id)){
            throw  new EmailAlreadyExistException("A patient with "+patient.getEmail()+"email already exists.");
        }

        foundPatient.setName(patient.getName());
        foundPatient.setEmail(patient.getEmail());
        foundPatient.setAddress(patient.getAddress());
        foundPatient.setDateofBirth(LocalDate.parse(patient.getDateOfBirth()));

        Patient updatedPatient = patientRepository.save(foundPatient);

        return PatientMapper.toDTO(updatedPatient);

    }

    @Override
    public void deletePatient(UUID id)
    {
        patientRepository.deleteById(id);
        return;
    }
}
