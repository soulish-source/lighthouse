package com.soulish.lighthouse.model.dto;

import java.util.List;

public record ModelConfigDto(
        String id,
        String profileName,
        String provider,
        String primaryModel,
        String fallbackModel,
        Double temperature,
        Integer maxContextTokens,
        List<String> capabilities,
        String promptPreset,
        String memoryPolicy
) {
}
