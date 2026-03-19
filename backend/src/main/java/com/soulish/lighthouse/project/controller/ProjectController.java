package com.soulish.lighthouse.project.controller;

import com.soulish.lighthouse.common.ApiResponse;
import com.soulish.lighthouse.project.dto.ProjectDashboardDto;
import com.soulish.lighthouse.project.service.ProjectQueryService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/projects")
public class ProjectController {

    private final ProjectQueryService projectQueryService;

    public ProjectController(ProjectQueryService projectQueryService) {
        this.projectQueryService = projectQueryService;
    }

    @GetMapping("/{projectId}")
    public ApiResponse<ProjectDashboardDto> getProjectDashboard(@PathVariable String projectId) {
        return ApiResponse.ok(projectQueryService.getDashboard(projectId));
    }
}
