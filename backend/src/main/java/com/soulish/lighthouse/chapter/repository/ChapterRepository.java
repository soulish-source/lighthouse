package com.soulish.lighthouse.chapter.repository;

import com.soulish.lighthouse.chapter.entity.Chapter;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ChapterRepository extends JpaRepository<Chapter, String> {
    List<Chapter> findByProjectIdOrderByCreatedAtAsc(String projectId);
}
