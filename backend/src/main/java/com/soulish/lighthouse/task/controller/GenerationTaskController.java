package com.soulish.lighthouse.task.controller;

import com.soulish.lighthouse.common.ApiResponse;
import com.soulish.lighthouse.task.dto.GenerationTaskDto;
import com.soulish.lighthouse.task.service.TaskQueryService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/generation-tasks")
public class GenerationTaskController {

    private final TaskQueryService taskQueryService;

    public GenerationTaskController(TaskQueryService taskQueryService) {
        this.taskQueryService = taskQueryService;
    }

    @GetMapping
    public ApiResponse<List<GenerationTaskDto>> list(@RequestParam(defaultValue = "demo-project") String projectId) {
        return ApiResponse.ok(taskQueryService.list(projectId));
    }
}
