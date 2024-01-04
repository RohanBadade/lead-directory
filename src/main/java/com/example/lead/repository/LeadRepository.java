package com.example.lead.repository;

import com.example.lead.domain.Lead;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LeadRepository extends JpaRepository<Lead, Integer> {

    List<Lead> findByMobileNumber(String mobileNumber);
}
