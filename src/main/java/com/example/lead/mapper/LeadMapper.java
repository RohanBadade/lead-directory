package com.example.lead.mapper;

import com.example.lead.domain.Lead;
import com.example.lead.dto.LeadData;
import com.example.lead.dto.RegisterLeadRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Mapper(componentModel = "spring")
public interface LeadMapper {

    @Mapping(source = "birthDate", target = "birthDate", qualifiedByName = "convertStringToDate")
    Lead mapToLeadDomain(RegisterLeadRequest registerLeadRequest);

    List<LeadData> mapToLeadDataList(List<Lead> leadList);

    @Named("convertStringToDate")
    default LocalDate convertStringToDate(String birthdate) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");
        return LocalDate.parse(birthdate, formatter);
    }
}
