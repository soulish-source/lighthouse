package com.soulish.lighthouse.common;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class HealthController {

    @GetMapping("/health")
    public ApiResponse<HealthPayload> health() {
        return ApiResponse.ok(new HealthPayload("lighthouse-backend", "ok", "phase-1-foundation"));
    }
}
