package com.harsh.opssleuth.common.exception;

import java.time.Instant;

public record ErrorResponse(
        String message,
        Instant timestamp
) {
}
