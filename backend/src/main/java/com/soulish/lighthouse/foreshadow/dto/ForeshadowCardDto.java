package com.soulish.lighthouse.foreshadow.dto;

import java.util.List;

public record ForeshadowCardDto(
        String id,
        String title,
        String status,
        String plantedAt,
        String targetPayoff,
        String riskLevel,
        List<String> relatedCharacters,
        List<String> notes
) {
}
