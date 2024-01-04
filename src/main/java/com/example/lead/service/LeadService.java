package com.example.lead.service;

import com.example.lead.dto.RegisterLeadRequest;
import com.example.lead.dto.RegisterLeadResponse;
import com.example.lead.dto.RetrieveLeadResponse;
import org.springframework.stereotype.Service;

@Service
public interface LeadService {
    RegisterLeadResponse registerLead(RegisterLeadRequest registerLeadRequest);

    RetrieveLeadResponse getLeadByMobileNumber(String mobileNumber);
}
