package com.soulish.lighthouse.timeline.controller;

import com.soulish.lighthouse.common.ApiResponse;
import com.soulish.lighthouse.timeline.dto.TimelineEventDto;
import com.soulish.lighthouse.timeline.service.TimelineQueryService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/timeline-events")
public class TimelineController {

    private final TimelineQueryService timelineQueryService;

    public TimelineController(TimelineQueryService timelineQueryService) {
        this.timelineQueryService = timelineQueryService;
    }

    @GetMapping
    public ApiResponse<List<TimelineEventDto>> list(@RequestParam(defaultValue = "demo-project") String projectId) {
        return ApiResponse.ok(timelineQueryService.list(projectId));
    }
}
