package com.harsh.opssleuth.investigation.service;

import com.harsh.opssleuth.investigation.dto.CreateInvestigationRequest;
import com.harsh.opssleuth.investigation.dto.CreateInvestigationResponse;
import com.harsh.opssleuth.investigation.dto.InvestigationResponse;

import java.util.List;
import java.util.UUID;

public interface InvestigationService {

    CreateInvestigationResponse createInvestigation(
            CreateInvestigationRequest request
    );

    InvestigationResponse getInvestigation(UUID id);

    List<InvestigationResponse> getInvestigations();
}