package com.example.lead.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class RetrieveLeadResponse {

    @JsonProperty("Status")
    private String status;

    @JsonProperty("Data")
    private List<LeadData> leadData;

    public RetrieveLeadResponse(){
    }

    public RetrieveLeadResponse(String status, List<LeadData> leadDataList) {
        this.status = status;
        this.leadData = leadDataList;
    }
}
