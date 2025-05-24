package com.microservice.partientservice.controller;

import com.microservice.partientservice.dto.PatientRequestDTO;
import com.microservice.partientservice.dto.PatientResponseDTO;
import com.microservice.partientservice.dto.Validators.CreatePatientValidationGroup;
import com.microservice.partientservice.service.PatientService;
import jakarta.validation.Valid;
import jakarta.validation.groups.Default;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

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
    public ResponseEntity<PatientResponseDTO> createPatient(@Validated({Default.class, CreatePatientValidationGroup.class}) @RequestBody PatientRequestDTO patientRequestDTO)
    {
        PatientResponseDTO res = patientService.addPatient(patientRequestDTO);

        return ResponseEntity.ok().body(res);
    }


    @PutMapping("/{id}")
    public  ResponseEntity<PatientResponseDTO> updatePatient(@PathVariable UUID id,@Validated({Default.class}) @RequestBody PatientRequestDTO patientRequestDTO)
    {
        System.out.println(patientRequestDTO.toString());
        PatientResponseDTO res = patientService.updatePatient(id,patientRequestDTO);
        return  ResponseEntity.ok().body(res);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePatientController(@PathVariable UUID id)
    {
        patientService.deletePatient(id);
        return ResponseEntity.noContent().build();
    }

}
