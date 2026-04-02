package com.soulish.lighthouse.timeline.controller;

import com.soulish.lighthouse.common.ApiResponse;
import com.soulish.lighthouse.timeline.dto.TimelineEventDto;
import com.soulish.lighthouse.timeline.entity.TimelineEvent;
import com.soulish.lighthouse.timeline.service.TimelineCommandService;
import com.soulish.lighthouse.timeline.service.TimelineQueryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/timeline-events")
public class TimelineController {

    private final TimelineQueryService timelineQueryService;
    private final TimelineCommandService timelineCommandService;

    public TimelineController(TimelineQueryService timelineQueryService, TimelineCommandService timelineCommandService) {
        this.timelineQueryService = timelineQueryService;
        this.timelineCommandService = timelineCommandService;
    }

    @GetMapping
    public ApiResponse<List<TimelineEventDto>> list(@RequestParam(defaultValue = "demo-project") String projectId) {
        return ApiResponse.ok(timelineQueryService.list(projectId));
    }

    @PostMapping
    public ApiResponse<TimelineEvent> create(@RequestBody TimelineEvent event) {
        return ApiResponse.ok(timelineCommandService.create(event));
    }

    @PutMapping("/{id}")
    public ApiResponse<TimelineEvent> update(@PathVariable String id, @RequestBody TimelineEvent event) {
        return ApiResponse.ok(timelineCommandService.update(id, event));
    }

    @DeleteMapping("/{id}")
    public ApiResponse<Void> delete(@PathVariable String id) {
        timelineCommandService.delete(id);
        return ApiResponse.ok(null);
    }
}
