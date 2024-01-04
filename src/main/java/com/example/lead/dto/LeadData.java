package com.example.lead.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class LeadData {

    private Integer leadId;

    private String firstName;

    private String middleName;

    private String lastName;

    private String mobileNumber;

    private String gender;

    private LocalDate birthDate;

    private String email;
}
