package com.soulish.lighthouse.character.dto;

import java.util.List;

public record CharacterCardDto(
        String id,
        String name,
        String role,
        String faction,
        String currentArc,
        String status,
        List<String> traits,
        List<String> unresolvedThreads
) {
}
