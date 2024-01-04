package com.example.lead.dto;

import lombok.Data;

@Data
public class RegisterLeadResponse {

    private String status;

    private String data;

    public RegisterLeadResponse() {
    }

    public RegisterLeadResponse(String status, String data) {
        this.status = status;
        this.data = data;
    }
}
