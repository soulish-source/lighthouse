package com.soulish.lighthouse.foreshadow.controller;

import com.soulish.lighthouse.common.ApiResponse;
import com.soulish.lighthouse.foreshadow.dto.ForeshadowCardDto;
import com.soulish.lighthouse.foreshadow.entity.Foreshadow;
import com.soulish.lighthouse.foreshadow.service.ForeshadowCommandService;
import com.soulish.lighthouse.foreshadow.service.ForeshadowQueryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/foreshadows")
public class ForeshadowController {

    private final ForeshadowQueryService foreshadowQueryService;
    private final ForeshadowCommandService foreshadowCommandService;

    public ForeshadowController(ForeshadowQueryService foreshadowQueryService, ForeshadowCommandService foreshadowCommandService) {
        this.foreshadowQueryService = foreshadowQueryService;
        this.foreshadowCommandService = foreshadowCommandService;
    }

    @GetMapping
    public ApiResponse<List<ForeshadowCardDto>> list(@RequestParam(defaultValue = "demo-project") String projectId) {
        return ApiResponse.ok(foreshadowQueryService.list(projectId));
    }

    @PostMapping
    public ApiResponse<Foreshadow> create(@RequestBody Foreshadow foreshadow) {
        return ApiResponse.ok(foreshadowCommandService.create(foreshadow));
    }

    @PutMapping("/{id}")
    public ApiResponse<Foreshadow> update(@PathVariable String id, @RequestBody Foreshadow foreshadow) {
        return ApiResponse.ok(foreshadowCommandService.update(id, foreshadow));
    }

    @DeleteMapping("/{id}")
    public ApiResponse<Void> delete(@PathVariable String id) {
        foreshadowCommandService.delete(id);
        return ApiResponse.ok(null);
    }
}
