package com.example.lead.dto;

import lombok.Data;

@Data
public class ExceptionHandlerResponse {

    private String status;

    private ErrorResponse errorResponse;


    public ExceptionHandlerResponse() {
    }

    public ExceptionHandlerResponse(String status, ErrorResponse errorResponse) {
        this.status = status;
        this.errorResponse = errorResponse;
    }
}
