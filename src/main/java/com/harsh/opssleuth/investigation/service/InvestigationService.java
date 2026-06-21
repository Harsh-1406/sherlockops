package com.harsh.opssleuth.investigation.service;

import com.harsh.opssleuth.investigation.dto.CreateInvestigationRequest;
import com.harsh.opssleuth.investigation.dto.CreateInvestigationResponse;

public interface InvestigationService {

    CreateInvestigationResponse createInvestigation(
            CreateInvestigationRequest request
    );
}