package com.soulish.lighthouse.timeline.service;

import com.soulish.lighthouse.timeline.entity.TimelineEvent;
import com.soulish.lighthouse.timeline.repository.TimelineEventRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TimelineCommandService {
    private final TimelineEventRepository timelineEventRepository;

    public TimelineCommandService(TimelineEventRepository timelineEventRepository) {
        this.timelineEventRepository = timelineEventRepository;
    }

    @Transactional
    public TimelineEvent create(TimelineEvent t) {
        return timelineEventRepository.save(t);
    }

    @Transactional
    public TimelineEvent update(String id, TimelineEvent updated) {
        TimelineEvent existing = timelineEventRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("TimelineEvent not found: " + id));
        existing.setDayLabel(updated.getDayLabel());
        existing.setEventTitle(updated.getEventTitle());
        existing.setChapterRef(updated.getChapterRef());
        existing.setLocation(updated.getLocation());
        existing.setConsequence(updated.getConsequence());
        existing.setParticipants(updated.getParticipants());
        return timelineEventRepository.save(existing);
    }

    @Transactional
    public void delete(String id) {
        timelineEventRepository.deleteById(id);
    }
}
