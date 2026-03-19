package com.soulish.lighthouse.task.service;

import com.soulish.lighthouse.project.service.ProjectQueryService;
import com.soulish.lighthouse.task.dto.GenerationTaskDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskQueryService {

    private final ProjectQueryService projectQueryService;

    public TaskQueryService(ProjectQueryService projectQueryService) {
        this.projectQueryService = projectQueryService;
    }

    public List<GenerationTaskDto> list(String projectId) {
        return projectQueryService.sampleTasks();
    }
}
