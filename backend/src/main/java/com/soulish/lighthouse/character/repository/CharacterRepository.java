package com.soulish.lighthouse.character.repository;

import com.soulish.lighthouse.character.entity.Character;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface CharacterRepository extends JpaRepository<Character, String> {
    List<Character> findByProjectIdOrderByCreatedAtAsc(String projectId);
}
