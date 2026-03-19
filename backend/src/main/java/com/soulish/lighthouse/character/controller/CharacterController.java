package com.soulish.lighthouse.character.controller;

import com.soulish.lighthouse.character.dto.CharacterCardDto;
import com.soulish.lighthouse.character.service.CharacterQueryService;
import com.soulish.lighthouse.common.ApiResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/characters")
public class CharacterController {

    private final CharacterQueryService characterQueryService;

    public CharacterController(CharacterQueryService characterQueryService) {
        this.characterQueryService = characterQueryService;
    }

    @GetMapping
    public ApiResponse<List<CharacterCardDto>> list(@RequestParam(defaultValue = "demo-project") String projectId) {
        return ApiResponse.ok(characterQueryService.list(projectId));
    }
}
