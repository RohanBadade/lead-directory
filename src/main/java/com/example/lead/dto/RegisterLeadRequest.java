package com.example.lead.dto;

import com.example.lead.constants.ErrorMessages;
import com.example.lead.constants.Patterns;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class RegisterLeadRequest {

    @NotBlank(message = "LeadId" + ErrorMessages.MANDATORY_FIELD_ERROR)
    @Pattern(regexp = Patterns.SPACE, message = "LeadId" + ErrorMessages.SPACES_NOT_ALLOWED)
    @JsonProperty("LeadId")
    private String leadId;

    @NotBlank(message = "FirstName" + ErrorMessages.MANDATORY_FIELD_ERROR)
    @Pattern(regexp = Patterns.ALPHABETS, message = "FirstName" + ErrorMessages.ONLY_ALPHABETS_ALLOWED)
    @Pattern(regexp = Patterns.SPACE, message = "FirstName" + ErrorMessages.SPACES_NOT_ALLOWED)
    @JsonProperty("FirstName")
    private String firstName;

    @JsonProperty("MiddleName")
    @Pattern(regexp = Patterns.ALPHABETS, message = "MiddleName" + ErrorMessages.ONLY_ALPHABETS_ALLOWED)
    @Pattern(regexp = Patterns.SPACE, message = "MiddleName" + ErrorMessages.SPACES_NOT_ALLOWED)
    private String middleName;

    @NotBlank(message = "LastName" + ErrorMessages.MANDATORY_FIELD_ERROR)
    @Pattern(regexp = Patterns.ALPHABETS, message = "LastName" + ErrorMessages.ONLY_ALPHABETS_ALLOWED)
    @Pattern(regexp = Patterns.SPACE, message = "LastName" + ErrorMessages.SPACES_NOT_ALLOWED)
    @JsonProperty("LastName")
    private String lastName;

    @NotBlank(message = "MobileNumber" + ErrorMessages.MANDATORY_FIELD_ERROR)
    @Pattern(regexp = Patterns.NUMERIC, message = "MobileNumber" + ErrorMessages.ONLY_INTEGER_ALLOWED)
    @Pattern(regexp = Patterns.NUMERIC_START_WITH_SIX_OR_MORE, message = "MobileNumber" + ErrorMessages.FIRST_DIGIT_GREATER_THAN_FIVE)
    @Pattern(regexp = Patterns.SPACE, message = "MobileNumber" + ErrorMessages.SPACES_NOT_ALLOWED)
    @JsonProperty("MobileNumber")
    private String mobileNumber;

    @NotBlank(message = "Gender" + ErrorMessages.MANDATORY_FIELD_ERROR)
    @Pattern(regexp = Patterns.GENDER, message = "Gender" + ErrorMessages.INVALID_GENDER)
    @Pattern(regexp = Patterns.SPACE, message = "Gender" + ErrorMessages.SPACES_NOT_ALLOWED)
    @JsonProperty("Gender")
    private String gender;

    @JsonProperty("BirthDate")
    @Pattern(regexp = Patterns.SPACE, message = "Gender" + ErrorMessages.SPACES_NOT_ALLOWED)
    @Pattern(regexp = Patterns.DATE_FORMAT_FOR_DD_MM_YY, message = "BirthDate" + ErrorMessages.INVALID_DATE_FORMAT)
    private String birthDate;

    @Email
    @Pattern(regexp = Patterns.SPACE, message = "Email" + ErrorMessages.SPACES_NOT_ALLOWED)
    @JsonProperty("Email")
    private String email;
}
