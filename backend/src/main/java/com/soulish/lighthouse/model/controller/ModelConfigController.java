package com.soulish.lighthouse.model.controller;

import com.soulish.lighthouse.common.ApiResponse;
import com.soulish.lighthouse.model.dto.ModelConfigDto;
import com.soulish.lighthouse.model.service.ModelQueryService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/model-configs")
public class ModelConfigController {

    private final ModelQueryService modelQueryService;

    public ModelConfigController(ModelQueryService modelQueryService) {
        this.modelQueryService = modelQueryService;
    }

    @GetMapping
    public ApiResponse<List<ModelConfigDto>> list(@RequestParam(defaultValue = "demo-project") String projectId) {
        return ApiResponse.ok(modelQueryService.list(projectId));
    }
}
