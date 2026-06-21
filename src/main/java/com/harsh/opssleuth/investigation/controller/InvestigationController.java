package com.harsh.opssleuth.investigation.controller;

import com.harsh.opssleuth.investigation.dto.CreateInvestigationRequest;
import com.harsh.opssleuth.investigation.dto.CreateInvestigationResponse;
import com.harsh.opssleuth.investigation.service.InvestigationService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/investigations")
@RequiredArgsConstructor
public class InvestigationController {

    private final InvestigationService investigationService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CreateInvestigationResponse createInvestigation(
            @Valid @RequestBody CreateInvestigationRequest request
    ) {

        return investigationService.createInvestigation(request);
    }
}