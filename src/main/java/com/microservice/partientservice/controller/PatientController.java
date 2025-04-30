package com.microservice.partientservice.controller;

import com.microservice.partientservice.dto.PatientRequestDTO;
import com.microservice.partientservice.dto.PatientResponseDTO;
import com.microservice.partientservice.modal.Patient;
import com.microservice.partientservice.service.PatientService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/patients")
public class PatientController {

    PatientService patientService;

    @Autowired
    public PatientController(PatientService patientService)
    {
        this.patientService = patientService;
    }

    @GetMapping("/hello")
    public String hello()
    {
        return "Hello from patient end point";
    }

    @GetMapping
    public ResponseEntity<List<PatientResponseDTO>> getAllPatients()
    {
        return ResponseEntity.ok().body(patientService.getAllPatients());
    }

    @PostMapping
    public ResponseEntity<PatientResponseDTO> createPatient(@Valid @RequestBody PatientRequestDTO patientRequestDTO)
    {
        PatientResponseDTO res = patientService.addPatient(patientRequestDTO);

        return ResponseEntity.ok().body(res);
    }
}
