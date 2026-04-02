package com.soulish.lighthouse.timeline.repository;

import com.soulish.lighthouse.timeline.entity.TimelineEvent;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface TimelineEventRepository extends JpaRepository<TimelineEvent, String> {
    List<TimelineEvent> findByProjectIdOrderByCreatedAtAsc(String projectId);
}
