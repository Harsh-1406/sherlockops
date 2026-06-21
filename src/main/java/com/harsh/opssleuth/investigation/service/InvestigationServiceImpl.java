package com.harsh.opssleuth.investigation.service;

import com.harsh.opssleuth.common.exception.InvestigationNotFoundException;
import com.harsh.opssleuth.investigation.dto.CreateInvestigationRequest;
import com.harsh.opssleuth.investigation.dto.CreateInvestigationResponse;
import com.harsh.opssleuth.investigation.dto.InvestigationResponse;
import com.harsh.opssleuth.investigation.entity.Investigation;
import com.harsh.opssleuth.investigation.entity.InvestigationStatus;
import com.harsh.opssleuth.investigation.repository.InvestigationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.List;
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

    @Override
    @Transactional(readOnly = true)
    public InvestigationResponse getInvestigation(UUID id) {

        Investigation investigation =
                investigationRepository.findById(id)
                        .orElseThrow(() -> new InvestigationNotFoundException(id));

        return toResponse(investigation);
    }

    @Override
    @Transactional(readOnly = true)
    public List<InvestigationResponse> getInvestigations() {

        return investigationRepository.findAll()
                .stream()
                .map(this::toResponse)
                .toList();
    }

    private InvestigationResponse toResponse(
            Investigation investigation
    ) {
        return new InvestigationResponse(
                investigation.getId(),
                investigation.getIssueDescription(),
                investigation.getStatus(),
                investigation.getCreatedAt(),
                investigation.getUpdatedAt()
        );
    }
}
