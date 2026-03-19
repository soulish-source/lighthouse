package com.soulish.lighthouse.project.dto;

import com.soulish.lighthouse.chapter.dto.ChapterCardDto;
import com.soulish.lighthouse.character.dto.CharacterCardDto;
import com.soulish.lighthouse.foreshadow.dto.ForeshadowCardDto;
import com.soulish.lighthouse.model.dto.ModelConfigDto;
import com.soulish.lighthouse.outline.dto.OutlineNodeDto;
import com.soulish.lighthouse.task.dto.GenerationTaskDto;
import com.soulish.lighthouse.timeline.dto.TimelineEventDto;

import java.util.List;

public record ProjectDashboardDto(
        ProjectSummaryDto project,
        List<OutlineNodeDto> outline,
        List<ChapterCardDto> chapters,
        List<CharacterCardDto> characters,
        List<ForeshadowCardDto> foreshadows,
        List<TimelineEventDto> timeline,
        List<GenerationTaskDto> tasks,
        List<ModelConfigDto> modelConfigs
) {
}
