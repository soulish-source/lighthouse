package com.soulish.lighthouse.timeline.service;

import com.soulish.lighthouse.project.service.ProjectQueryService;
import com.soulish.lighthouse.timeline.dto.TimelineEventDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TimelineQueryService {

    private final ProjectQueryService projectQueryService;

    public TimelineQueryService(ProjectQueryService projectQueryService) {
        this.projectQueryService = projectQueryService;
    }

    public List<TimelineEventDto> list(String projectId) {
        return projectQueryService.sampleTimeline();
    }
}
