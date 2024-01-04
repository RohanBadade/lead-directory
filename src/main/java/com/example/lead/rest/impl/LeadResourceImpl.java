package com.example.lead.rest.impl;

import com.example.lead.dto.RegisterLeadRequest;
import com.example.lead.dto.RegisterLeadResponse;
import com.example.lead.dto.RetrieveLeadResponse;
import com.example.lead.service.LeadService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/LeadDirectory/V1/")
public class LeadResourceImpl {

    @Autowired
    LeadService leadService;

    @PostMapping("/Lead/Register")
    public RegisterLeadResponse registerLead(@Valid @RequestBody RegisterLeadRequest registerLeadRequest) {
        return leadService.registerLead(registerLeadRequest);
    }

    @GetMapping("/Lead/{mobileNumber}/Retrieve")
    public ResponseEntity<RetrieveLeadResponse> getLeadByMobileNumber(@PathVariable String mobileNumber) {
        return ResponseEntity.ok(leadService.getLeadByMobileNumber(mobileNumber));
    }
}
