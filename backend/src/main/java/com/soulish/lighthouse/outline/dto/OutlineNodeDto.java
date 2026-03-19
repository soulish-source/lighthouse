package com.soulish.lighthouse.outline.dto;

import java.util.List;

public record OutlineNodeDto(
        String id,
        String type,
        String title,
        String summary,
        String goal,
        String pov,
        String status,
        List<String> keyConflicts,
        List<String> reveals,
        List<String> dependencies
) {
}
