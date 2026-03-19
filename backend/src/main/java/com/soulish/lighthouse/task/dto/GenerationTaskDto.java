package com.soulish.lighthouse.task.dto;

import java.util.List;

public record GenerationTaskDto(
        String id,
        String taskType,
        String targetRef,
        String status,
        String owner,
        String modelProfile,
        Integer progress,
        List<String> blockers,
        List<String> checklist
) {
}
