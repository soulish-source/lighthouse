package com.soulish.lighthouse.timeline.dto;

import java.util.List;

public record TimelineEventDto(
        String id,
        String dayLabel,
        String eventTitle,
        String chapterRef,
        String location,
        List<String> participants,
        String consequence
) {
}
