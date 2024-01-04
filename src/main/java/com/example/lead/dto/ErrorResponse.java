package com.example.lead.dto;

import lombok.Data;

import java.util.List;

@Data
public class ErrorResponse {

    private String errorCode;

    private List<String> errorMessage;


    public ErrorResponse() {
    }

    public ErrorResponse(String errorCode, List<String> errorMessage) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }
}
