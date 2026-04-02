package com.soulish.lighthouse.project.controller;

import com.soulish.lighthouse.common.ApiResponse;
import com.soulish.lighthouse.project.dto.ProjectCreateDto;
import com.soulish.lighthouse.project.dto.ProjectDashboardDto;
import com.soulish.lighthouse.project.entity.Project;
import com.soulish.lighthouse.project.service.ProjectCommandService;
import com.soulish.lighthouse.project.service.ProjectQueryService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/projects")
public class ProjectController {

    private final ProjectQueryService projectQueryService;
    private final ProjectCommandService projectCommandService;

    public ProjectController(ProjectQueryService projectQueryService, ProjectCommandService projectCommandService) {
        this.projectQueryService = projectQueryService;
        this.projectCommandService = projectCommandService;
    }

    @GetMapping("/{projectId}")
    public ApiResponse<ProjectDashboardDto> getProjectDashboard(@PathVariable String projectId) {
        return ApiResponse.ok(projectQueryService.getDashboard(projectId));
    }

    @PostMapping
    public ApiResponse<Project> createProject(@RequestBody ProjectCreateDto dto) {
        Project project = new Project();
        project.setName(dto.getName());
        project.setGenre(dto.getGenre());
        project.setDescription(dto.getDescription());
        project.setStage(dto.getStage());
        project.setTargetWordCount(dto.getTargetWordCount());
        project.setCompletedWordCount(dto.getCompletedWordCount());
        project.setGoals(dto.getGoals());
        project.setTags(dto.getTags());
        return ApiResponse.ok(projectCommandService.create(project));
    }

    @PutMapping("/{id}")
    public ApiResponse<Project> updateProject(@PathVariable String id, @RequestBody ProjectCreateDto dto) {
        Project updated = new Project();
        updated.setName(dto.getName());
        updated.setGenre(dto.getGenre());
        updated.setDescription(dto.getDescription());
        updated.setStage(dto.getStage());
        updated.setTargetWordCount(dto.getTargetWordCount());
        updated.setCompletedWordCount(dto.getCompletedWordCount());
        updated.setGoals(dto.getGoals());
        updated.setTags(dto.getTags());
        return ApiResponse.ok(projectCommandService.update(id, updated));
    }

    @DeleteMapping("/{id}")
    public ApiResponse<Void> deleteProject(@PathVariable String id) {
        projectCommandService.delete(id);
        return ApiResponse.ok(null);
    }
}
