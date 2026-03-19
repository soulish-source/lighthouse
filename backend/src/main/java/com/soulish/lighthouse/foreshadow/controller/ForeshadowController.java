package com.soulish.lighthouse.foreshadow.controller;

import com.soulish.lighthouse.common.ApiResponse;
import com.soulish.lighthouse.foreshadow.dto.ForeshadowCardDto;
import com.soulish.lighthouse.foreshadow.service.ForeshadowQueryService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/foreshadows")
public class ForeshadowController {

    private final ForeshadowQueryService foreshadowQueryService;

    public ForeshadowController(ForeshadowQueryService foreshadowQueryService) {
        this.foreshadowQueryService = foreshadowQueryService;
    }

    @GetMapping
    public ApiResponse<List<ForeshadowCardDto>> list(@RequestParam(defaultValue = "demo-project") String projectId) {
        return ApiResponse.ok(foreshadowQueryService.list(projectId));
    }
}
