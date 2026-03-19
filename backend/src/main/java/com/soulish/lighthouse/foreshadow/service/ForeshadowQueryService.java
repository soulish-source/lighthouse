package com.soulish.lighthouse.foreshadow.service;

import com.soulish.lighthouse.foreshadow.dto.ForeshadowCardDto;
import com.soulish.lighthouse.project.service.ProjectQueryService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ForeshadowQueryService {

    private final ProjectQueryService projectQueryService;

    public ForeshadowQueryService(ProjectQueryService projectQueryService) {
        this.projectQueryService = projectQueryService;
    }

    public List<ForeshadowCardDto> list(String projectId) {
        return projectQueryService.sampleForeshadows();
    }
}
