package com.soulish.lighthouse.foreshadow.repository;

import com.soulish.lighthouse.foreshadow.entity.Foreshadow;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ForeshadowRepository extends JpaRepository<Foreshadow, String> {
    List<Foreshadow> findByProjectIdOrderByCreatedAtAsc(String projectId);
}
