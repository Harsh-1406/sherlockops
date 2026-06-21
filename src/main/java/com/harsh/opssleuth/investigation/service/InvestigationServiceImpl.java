package com.harsh.opssleuth.investigation.service;

import com.harsh.opssleuth.investigation.dto.CreateInvestigationRequest;
import com.harsh.opssleuth.investigation.dto.CreateInvestigationResponse;
import com.harsh.opssleuth.investigation.entity.Investigation;
import com.harsh.opssleuth.investigation.entity.InvestigationStatus;
import com.harsh.opssleuth.investigation.repository.InvestigationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Transactional
public class InvestigationServiceImpl implements InvestigationService {

    private final InvestigationRepository investigationRepository;

    @Override
    public CreateInvestigationResponse createInvestigation(
            CreateInvestigationRequest request
    ) {

        Investigation investigation = Investigation.builder()
                .id(UUID.randomUUID())
                .issueDescription(request.issueDescription())
                .status(InvestigationStatus.CREATED)
                .createdAt(Instant.now())
                .updatedAt(Instant.now())
                .build();

        Investigation savedInvestigation =
                investigationRepository.save(investigation);

        return new CreateInvestigationResponse(
                savedInvestigation.getId(),
                savedInvestigation.getStatus()
        );
    }
}
