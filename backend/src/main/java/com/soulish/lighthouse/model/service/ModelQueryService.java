package com.soulish.lighthouse.model.service;

import com.soulish.lighthouse.model.dto.ModelConfigDto;
import com.soulish.lighthouse.project.service.ProjectQueryService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ModelQueryService {

    private final ProjectQueryService projectQueryService;

    public ModelQueryService(ProjectQueryService projectQueryService) {
        this.projectQueryService = projectQueryService;
    }

    public List<ModelConfigDto> list(String projectId) {
        return projectQueryService.sampleModelConfigs();
    }
}
