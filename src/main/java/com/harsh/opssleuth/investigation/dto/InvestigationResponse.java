package com.harsh.opssleuth.investigation.dto;

import com.harsh.opssleuth.investigation.entity.InvestigationStatus;

import java.time.Instant;
import java.util.UUID;

public record InvestigationResponse(
        UUID id,
        String issueDescription,
        InvestigationStatus status,
        Instant createdAt,
        Instant updatedAt
) {
}
