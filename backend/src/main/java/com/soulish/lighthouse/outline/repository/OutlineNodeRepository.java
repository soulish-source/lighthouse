package com.soulish.lighthouse.outline.repository;

import com.soulish.lighthouse.outline.entity.OutlineNode;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface OutlineNodeRepository extends JpaRepository<OutlineNode, String> {
    List<OutlineNode> findByProjectIdOrderByCreatedAtAsc(String projectId);
}
