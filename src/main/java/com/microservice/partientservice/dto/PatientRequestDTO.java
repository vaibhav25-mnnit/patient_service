package com.microservice.partientservice.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class PatientRequestDTO {

    @NotBlank
    @Size(max = 100,message = "Name cannot exceed 100 characters")
    private String name;

    @NotBlank(message = "Email is required")
    @Email(message = "Enter valid email")
    private String email;

    @NotBlank(message = "Address is required")
    private String address;


    @NotBlank(message = "DOB is required")
    private String dateofBirth;

    @NotBlank(message = "Registered Date is required")
    private String registeredDate;

    public @NotBlank @Size(max = 100, message = "Name cannot exceed 100 characters") String getName() {
        return name;
    }

    public void setName(@NotBlank @Size(max = 100, message = "Name cannot exceed 100 characters") String name) {
        this.name = name;
    }

    public @NotBlank(message = "Email is required") @Email(message = "Enter valid email") String getEmail() {
        return email;
    }

    public void setEmail(@NotBlank(message = "Email is required") @Email(message = "Enter valid email") String email) {
        this.email = email;
    }

    public @NotBlank(message = "Address is required") String getAddress() {
        return address;
    }

    public void setAddress(@NotBlank(message = "Address is required") String address) {
        this.address = address;
    }

    public @NotBlank(message = "DOB is required") String getDateofBirth() {
        return dateofBirth;
    }

    public void setDateofBirth(@NotBlank(message = "DOB is required") String dateofBirth) {
        this.dateofBirth = dateofBirth;
    }

    public @NotBlank(message = "Registered Date is required") String getRegisteredDate() {
        return registeredDate;
    }

    public void setRegisteredDate(@NotBlank(message = "Registered Date is required") String registeredDate) {
        this.registeredDate = registeredDate;
    }
}
