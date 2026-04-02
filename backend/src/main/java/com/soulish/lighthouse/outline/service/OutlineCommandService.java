package com.soulish.lighthouse.outline.service;

import com.soulish.lighthouse.outline.entity.OutlineNode;
import com.soulish.lighthouse.outline.repository.OutlineNodeRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OutlineCommandService {

    private final OutlineNodeRepository outlineNodeRepository;

    public OutlineCommandService(OutlineNodeRepository outlineNodeRepository) {
        this.outlineNodeRepository = outlineNodeRepository;
    }

    @Transactional
    public OutlineNode create(OutlineNode node) {
        return outlineNodeRepository.save(node);
    }

    @Transactional
    public OutlineNode update(String id, OutlineNode updated) {
        OutlineNode existing = outlineNodeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("OutlineNode not found: " + id));
        existing.setTitle(updated.getTitle());
        existing.setDescription(updated.getDescription());
        existing.setGoal(updated.getGoal());
        existing.setPov(updated.getPov());
        existing.setStatus(updated.getStatus());
        existing.setConflicts(updated.getConflicts());
        existing.setReveals(updated.getReveals());
        existing.setPrerequisites(updated.getPrerequisites());
        return outlineNodeRepository.save(existing);
    }

    @Transactional
    public void delete(String id) {
        outlineNodeRepository.deleteById(id);
    }
}
