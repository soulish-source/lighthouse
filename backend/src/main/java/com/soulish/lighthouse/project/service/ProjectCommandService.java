package com.soulish.lighthouse.project.service;

import com.soulish.lighthouse.project.entity.Project;
import com.soulish.lighthouse.project.repository.ProjectRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProjectCommandService {

    private final ProjectRepository projectRepository;

    public ProjectCommandService(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    @Transactional
    public Project create(Project project) {
        return projectRepository.save(project);
    }

    @Transactional
    public Project update(String id, Project updated) {
        Project existing = projectRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Project not found: " + id));
        existing.setName(updated.getName());
        existing.setGenre(updated.getGenre());
        existing.setDescription(updated.getDescription());
        existing.setStage(updated.getStage());
        existing.setTargetWordCount(updated.getTargetWordCount());
        existing.setCompletedWordCount(updated.getCompletedWordCount());
        existing.setGoals(updated.getGoals());
        existing.setTags(updated.getTags());
        return projectRepository.save(existing);
    }

    @Transactional
    public void delete(String id) {
        projectRepository.deleteById(id);
    }
}
