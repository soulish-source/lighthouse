package com.soulish.lighthouse.project.dto;

import java.util.List;

public record ProjectSummaryDto(
        String id,
        String name,
        String genre,
        String premise,
        String stage,
        Integer targetWords,
        Integer completedWords,
        List<String> narrativeGoals,
        List<String> labels
) {
}
