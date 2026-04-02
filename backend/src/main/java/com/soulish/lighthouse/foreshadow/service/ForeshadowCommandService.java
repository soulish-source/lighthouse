package com.soulish.lighthouse.foreshadow.service;

import com.soulish.lighthouse.foreshadow.entity.Foreshadow;
import com.soulish.lighthouse.foreshadow.repository.ForeshadowRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ForeshadowCommandService {
    private final ForeshadowRepository foreshadowRepository;

    public ForeshadowCommandService(ForeshadowRepository foreshadowRepository) {
        this.foreshadowRepository = foreshadowRepository;
    }

    @Transactional
    public Foreshadow create(Foreshadow f) {
        return foreshadowRepository.save(f);
    }

    @Transactional
    public Foreshadow update(String id, Foreshadow updated) {
        Foreshadow existing = foreshadowRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Foreshadow not found: " + id));
        existing.setTitle(updated.getTitle());
        existing.setStatus(updated.getStatus());
        existing.setPlantedAt(updated.getPlantedAt());
        existing.setTargetPayoff(updated.getTargetPayoff());
        existing.setRiskLevel(updated.getRiskLevel());
        existing.setNotes(updated.getNotes());
        existing.setRelatedCharacters(updated.getRelatedCharacters());
        return foreshadowRepository.save(existing);
    }

    @Transactional
    public void delete(String id) {
        foreshadowRepository.deleteById(id);
    }
}
