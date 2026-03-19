package com.soulish.lighthouse.chapter.service;

import com.soulish.lighthouse.chapter.dto.ChapterCardDto;
import com.soulish.lighthouse.project.service.ProjectQueryService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChapterQueryService {

    private final ProjectQueryService projectQueryService;

    public ChapterQueryService(ProjectQueryService projectQueryService) {
        this.projectQueryService = projectQueryService;
    }

    public List<ChapterCardDto> list(String projectId) {
        return projectQueryService.sampleChapters();
    }
}
