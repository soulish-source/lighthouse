package com.soulish.lighthouse.outline.controller;

import com.soulish.lighthouse.common.ApiResponse;
import com.soulish.lighthouse.outline.dto.OutlineCreateDto;
import com.soulish.lighthouse.outline.dto.OutlineNodeDto;
import com.soulish.lighthouse.outline.entity.OutlineNode;
import com.soulish.lighthouse.outline.service.OutlineCommandService;
import com.soulish.lighthouse.outline.service.OutlineQueryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/outlines")
public class OutlineController {

    private final OutlineQueryService outlineQueryService;
    private final OutlineCommandService outlineCommandService;

    public OutlineController(OutlineQueryService outlineQueryService, OutlineCommandService outlineCommandService) {
        this.outlineQueryService = outlineQueryService;
        this.outlineCommandService = outlineCommandService;
    }

    @GetMapping
    public ApiResponse<List<OutlineNodeDto>> list(@RequestParam(defaultValue = "demo-project") String projectId) {
        return ApiResponse.ok(outlineQueryService.list(projectId));
    }

    @PostMapping
    public ApiResponse<OutlineNode> create(@RequestBody OutlineCreateDto dto) {
        OutlineNode node = new OutlineNode();
        node.setProjectId(dto.getProjectId());
        node.setArcId(dto.getArcId());
        node.setType(OutlineNode.NodeType.valueOf(dto.getType()));
        node.setTitle(dto.getTitle());
        node.setDescription(dto.getDescription());
        node.setGoal(dto.getGoal());
        node.setPov(dto.getPov());
        node.setStatus(OutlineNode.NodeStatus.valueOf(dto.getStatus()));
        node.setConflicts(dto.getConflicts());
        node.setReveals(dto.getReveals());
        node.setPrerequisites(dto.getPrerequisites());
        return ApiResponse.ok(outlineCommandService.create(node));
    }

    @PutMapping("/{id}")
    public ApiResponse<OutlineNode> update(@PathVariable String id, @RequestBody OutlineCreateDto dto) {
        OutlineNode updated = new OutlineNode();
        updated.setTitle(dto.getTitle());
        updated.setDescription(dto.getDescription());
        updated.setGoal(dto.getGoal());
        updated.setPov(dto.getPov());
        updated.setStatus(OutlineNode.NodeStatus.valueOf(dto.getStatus()));
        updated.setConflicts(dto.getConflicts());
        updated.setReveals(dto.getReveals());
        updated.setPrerequisites(dto.getPrerequisites());
        return ApiResponse.ok(outlineCommandService.update(id, updated));
    }

    @DeleteMapping("/{id}")
    public ApiResponse<Void> delete(@PathVariable String id) {
        outlineCommandService.delete(id);
        return ApiResponse.ok(null);
    }
}
