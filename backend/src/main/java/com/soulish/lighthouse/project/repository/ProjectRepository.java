package com.soulish.lighthouse.project.repository;

import com.soulish.lighthouse.project.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface ProjectRepository extends JpaRepository<Project, String> {
    Optional<Project> findByName(String name);
}
