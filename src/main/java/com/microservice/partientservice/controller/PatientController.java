package com.microservice.partientservice.controller;

import com.microservice.partientservice.dto.PatientRequestDTO;
import com.microservice.partientservice.dto.PatientResponseDTO;
import com.microservice.partientservice.dto.Validators.CreatePatientValidationGroup;
import com.microservice.partientservice.service.PatientService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
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
@Tag(name = "Patient",description = "API for managing Patients")
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
    @Operation(summary = "Get Details of All Patients")
    public ResponseEntity<List<PatientResponseDTO>> getAllPatients()
    {
        return ResponseEntity.ok().body(patientService.getAllPatients());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get Details for Single Patient Based on id")
    public ResponseEntity<PatientResponseDTO> getPatient(@PathVariable UUID id)
    {
        PatientResponseDTO res = patientService.getPatient(id);
        return ResponseEntity.ok().body(res);
    }

    @PostMapping
    @Operation(summary = "Create a New Patient")
    public ResponseEntity<PatientResponseDTO> createPatient(@Validated({Default.class, CreatePatientValidationGroup.class}) @RequestBody PatientRequestDTO patientRequestDTO)
    {
        PatientResponseDTO res = patientService.addPatient(patientRequestDTO);

        return ResponseEntity.ok().body(res);
    }


    @PutMapping("/{id}")
    @Operation(summary = "Update a Patient")
    public  ResponseEntity<PatientResponseDTO> updatePatient(@PathVariable UUID id,@Validated({Default.class}) @RequestBody PatientRequestDTO patientRequestDTO)
    {
        System.out.println(patientRequestDTO.toString());
        PatientResponseDTO res = patientService.updatePatient(id,patientRequestDTO);
        return  ResponseEntity.ok().body(res);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete a Patient")
    public ResponseEntity<Void> deletePatientController(@PathVariable UUID id)
    {
        patientService.deletePatient(id);
        return ResponseEntity.noContent().build();
    }

}
