package com.soulish.lighthouse.chapter.controller;

import com.soulish.lighthouse.chapter.dto.ChapterCardDto;
import com.soulish.lighthouse.chapter.service.ChapterQueryService;
import com.soulish.lighthouse.common.ApiResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/chapters")
public class ChapterController {

    private final ChapterQueryService chapterQueryService;

    public ChapterController(ChapterQueryService chapterQueryService) {
        this.chapterQueryService = chapterQueryService;
    }

    @GetMapping
    public ApiResponse<List<ChapterCardDto>> list(@RequestParam(defaultValue = "demo-project") String projectId) {
        return ApiResponse.ok(chapterQueryService.list(projectId));
    }
}
