package com.soulish.lighthouse.outline.controller;

import com.soulish.lighthouse.common.ApiResponse;
import com.soulish.lighthouse.outline.dto.OutlineNodeDto;
import com.soulish.lighthouse.outline.service.OutlineQueryService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/outlines")
public class OutlineController {

    private final OutlineQueryService outlineQueryService;

    public OutlineController(OutlineQueryService outlineQueryService) {
        this.outlineQueryService = outlineQueryService;
    }

    @GetMapping
    public ApiResponse<List<OutlineNodeDto>> list(@RequestParam(defaultValue = "demo-project") String projectId) {
        return ApiResponse.ok(outlineQueryService.list(projectId));
    }
}
