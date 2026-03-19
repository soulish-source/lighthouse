package com.soulish.lighthouse.character.service;

import com.soulish.lighthouse.character.dto.CharacterCardDto;
import com.soulish.lighthouse.project.service.ProjectQueryService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CharacterQueryService {

    private final ProjectQueryService projectQueryService;

    public CharacterQueryService(ProjectQueryService projectQueryService) {
        this.projectQueryService = projectQueryService;
    }

    public List<CharacterCardDto> list(String projectId) {
        return projectQueryService.sampleCharacters();
    }
}
