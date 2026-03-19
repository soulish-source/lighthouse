package com.soulish.lighthouse.chapter.dto;

import java.util.List;

public record ChapterCardDto(
        String id,
        String title,
        String volumeTitle,
        String status,
        String pov,
        Integer targetWords,
        Integer currentWords,
        String updatedAt,
        List<String> focusCharacters,
        List<String> relatedForeshadows
) {
}
