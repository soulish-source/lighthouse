package com.soulish.lighthouse.character.service;

import com.soulish.lighthouse.character.entity.Character;
import com.soulish.lighthouse.character.repository.CharacterRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CharacterCommandService {
    private final CharacterRepository characterRepository;

    public CharacterCommandService(CharacterRepository characterRepository) {
        this.characterRepository = characterRepository;
    }

    @Transactional
    public Character create(Character c) {
        return characterRepository.save(c);
    }

    @Transactional
    public Character update(String id, Character updated) {
        Character existing = characterRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Character not found: " + id));
        existing.setName(updated.getName());
        existing.setRole(updated.getRole());
        existing.setFaction(updated.getFaction());
        existing.setCurrentArc(updated.getCurrentArc());
        existing.setStatus(updated.getStatus());
        existing.setTraitsList(updated.getTraitsList());
        existing.setUnresolvedThreadsList(updated.getUnresolvedThreadsList());
        return characterRepository.save(existing);
    }

    @Transactional
    public void delete(String id) {
        characterRepository.deleteById(id);
    }
}
