package com.soulish.lighthouse.project.dto;

import com.soulish.lighthouse.chapter.dto.ChapterCardDto;
import com.soulish.lighthouse.character.dto.CharacterCardDto;
import com.soulish.lighthouse.foreshadow.dto.ForeshadowCardDto;
import com.soulish.lighthouse.model.dto.ModelConfigDto;
import com.soulish.lighthouse.outline.dto.OutlineNodeDto;
import com.soulish.lighthouse.task.dto.GenerationTaskDto;
import com.soulish.lighthouse.timeline.dto.TimelineEventDto;
import java.util.List;

public class ProjectDashboardDto {
    private ProjectSummaryDto project;
    private List<OutlineNodeDto> outline;
    private List<ChapterCardDto> chapters;
    private List<CharacterCardDto> characters;
    private List<ForeshadowCardDto> foreshadows;
    private List<TimelineEventDto> timeline;
    private List<GenerationTaskDto> tasks;
    private List<ModelConfigDto> modelConfigs;

    public ProjectDashboardDto(ProjectSummaryDto project, List<OutlineNodeDto> outline, List<ChapterCardDto> chapters, List<CharacterCardDto> characters, List<ForeshadowCardDto> foreshadows, List<TimelineEventDto> timeline, List<GenerationTaskDto> tasks, List<ModelConfigDto> modelConfigs) {
        this.project = project;
        this.outline = outline;
        this.chapters = chapters;
        this.characters = characters;
        this.foreshadows = foreshadows;
        this.timeline = timeline;
        this.tasks = tasks;
        this.modelConfigs = modelConfigs;
    }

    public ProjectSummaryDto getProject() { return project; }
    public List<OutlineNodeDto> getOutline() { return outline; }
    public List<ChapterCardDto> getChapters() { return chapters; }
    public List<CharacterCardDto> getCharacters() { return characters; }
    public List<ForeshadowCardDto> getForeshadows() { return foreshadows; }
    public List<TimelineEventDto> getTimeline() { return timeline; }
    public List<GenerationTaskDto> getTasks() { return tasks; }
    public List<ModelConfigDto> getModelConfigs() { return modelConfigs; }
}
