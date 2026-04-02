package com.soulish.lighthouse.chapter.controller;

import com.soulish.lighthouse.chapter.dto.ChapterCardDto;
import com.soulish.lighthouse.chapter.dto.ChapterCreateDto;
import com.soulish.lighthouse.chapter.entity.Chapter;
import com.soulish.lighthouse.chapter.service.ChapterCommandService;
import com.soulish.lighthouse.chapter.service.ChapterQueryService;
import com.soulish.lighthouse.common.ApiResponse;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/chapters")
public class ChapterController {

    private final ChapterQueryService chapterQueryService;
    private final ChapterCommandService chapterCommandService;

    public ChapterController(ChapterQueryService chapterQueryService, ChapterCommandService chapterCommandService) {
        this.chapterQueryService = chapterQueryService;
        this.chapterCommandService = chapterCommandService;
    }

    @GetMapping
    public ApiResponse<List<ChapterCardDto>> list(@RequestParam(defaultValue = "demo-project") String projectId) {
        return ApiResponse.ok(chapterQueryService.list(projectId));
    }

    @PostMapping
    public ApiResponse<Chapter> create(@RequestBody ChapterCreateDto dto) {
        Chapter chapter = new Chapter();
        chapter.setProjectId(dto.getProjectId());
        chapter.setOutlineNodeId(dto.getOutlineNodeId());
        chapter.setVolumeTitle(dto.getVolumeTitle());
        chapter.setTitle(dto.getTitle());
        chapter.setStatus(Chapter.ChapterStatus.valueOf(dto.getStatus()));
        chapter.setPov(dto.getPov());
        chapter.setTargetWordCount(dto.getTargetWordCount());
        chapter.setCurrentWordCount(dto.getCurrentWordCount());
        chapter.setNote(dto.getNote());
        chapter.setCharacters(dto.getCharacters());
        chapter.setForeshadows(dto.getForeshadows());
        return ApiResponse.ok(chapterCommandService.create(chapter));
    }

    @PutMapping("/{id}")
    public ApiResponse<Chapter> update(@PathVariable String id, @RequestBody ChapterCreateDto dto) {
        Chapter updated = new Chapter();
        updated.setTitle(dto.getTitle());
        updated.setVolumeTitle(dto.getVolumeTitle());
        updated.setStatus(Chapter.ChapterStatus.valueOf(dto.getStatus()));
        updated.setPov(dto.getPov());
        updated.setTargetWordCount(dto.getTargetWordCount());
        updated.setCurrentWordCount(dto.getCurrentWordCount());
        updated.setNote(dto.getNote());
        updated.setCharacters(dto.getCharacters());
        updated.setForeshadows(dto.getForeshadows());
        return ApiResponse.ok(chapterCommandService.update(id, updated));
    }

    @DeleteMapping("/{id}")
    public ApiResponse<Void> delete(@PathVariable String id) {
        chapterCommandService.delete(id);
        return ApiResponse.ok(null);
    }
}
