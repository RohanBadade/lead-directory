package com.example.lead.service.impl;

import com.example.lead.domain.Lead;
import com.example.lead.dto.*;
import com.example.lead.exception.BusinessValidationException;
import com.example.lead.exception.DatabaseException;
import com.example.lead.exception.ResourceNotFoundException;
import com.example.lead.mapper.LeadMapper;
import com.example.lead.repository.LeadRepository;
import com.example.lead.service.LeadService;
import jakarta.persistence.PersistenceException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.NoHandlerFoundException;

import java.util.Collections;
import java.util.List;

@Service
public class LeadServiceImpl implements LeadService {

    @Autowired
    LeadRepository leadRepository;

    @Autowired
    LeadMapper leadMapper;

    @Override
    @Transactional
    public RegisterLeadResponse registerLead(RegisterLeadRequest registerLeadRequest) {
        requireValidLead(registerLeadRequest.getLeadId());
        Lead lead = leadMapper.mapToLeadDomain(registerLeadRequest);
        try {
            leadRepository.save(lead);
        } catch (PersistenceException pe) {
            throw new DatabaseException("Error while persisting lead details.");
        }
        return new RegisterLeadResponse("success", "Created Leads Successfully.");
    }

    private void requireValidLead(String leadId) {
        if (isLeadPresent(leadId)) {
            throw new BusinessValidationException("Lead Identifier already exist.");
        }
    }

    private boolean isLeadPresent(String leadId) {
        return leadRepository.findById(Integer.valueOf(leadId)).isPresent();
    }

    @Override
    public RetrieveLeadResponse getLeadByMobileNumber(String mobileNumber) {
        try {
            List<Lead> leadList = leadRepository.findByMobileNumber(mobileNumber);

            List<LeadData> leadDataList;

            if (!leadList.isEmpty()) {
                leadDataList = leadMapper.mapToLeadDataList(leadList);
            } else {
                throw new ResourceNotFoundException("Lead details does not exist for provided mobile number.");
            }
            return new RetrieveLeadResponse("success", leadDataList);
        } catch (PersistenceException pe) {
            throw new PersistenceException("Error while fetching list of lead using mobile number.");
        }
    }
}
