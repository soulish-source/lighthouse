package com.soulish.lighthouse.outline.service;

import com.soulish.lighthouse.outline.dto.OutlineNodeDto;
import com.soulish.lighthouse.project.service.ProjectQueryService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OutlineQueryService {

    private final ProjectQueryService projectQueryService;

    public OutlineQueryService(ProjectQueryService projectQueryService) {
        this.projectQueryService = projectQueryService;
    }

    public List<OutlineNodeDto> list(String projectId) {
        return projectQueryService.sampleOutline();
    }
}
