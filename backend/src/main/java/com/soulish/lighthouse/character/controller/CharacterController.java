package com.soulish.lighthouse.character.controller;

import com.soulish.lighthouse.character.dto.CharacterCardDto;
import com.soulish.lighthouse.character.entity.Character;
import com.soulish.lighthouse.character.service.CharacterCommandService;
import com.soulish.lighthouse.character.service.CharacterQueryService;
import com.soulish.lighthouse.common.ApiResponse;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/characters")
public class CharacterController {

    private final CharacterQueryService characterQueryService;
    private final CharacterCommandService characterCommandService;

    public CharacterController(CharacterQueryService characterQueryService, CharacterCommandService characterCommandService) {
        this.characterQueryService = characterQueryService;
        this.characterCommandService = characterCommandService;
    }

    @GetMapping
    public ApiResponse<List<CharacterCardDto>> list(@RequestParam(defaultValue = "demo-project") String projectId) {
        return ApiResponse.ok(characterQueryService.list(projectId));
    }

    @PostMapping
    public ApiResponse<Character> create(@RequestBody Character character) {
        return ApiResponse.ok(characterCommandService.create(character));
    }

    @PutMapping("/{id}")
    public ApiResponse<Character> update(@PathVariable String id, @RequestBody Character character) {
        return ApiResponse.ok(characterCommandService.update(id, character));
    }

    @DeleteMapping("/{id}")
    public ApiResponse<Void> delete(@PathVariable String id) {
        characterCommandService.delete(id);
        return ApiResponse.ok(null);
    }
}
