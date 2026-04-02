package com.soulish.lighthouse.project.entity;

import jakarta.persistence.*;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "projects")
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private String name;
    private String genre;
    @Column(columnDefinition = "TEXT")
    private String description;
    private String stage;
    private Long targetWordCount;
    private Long completedWordCount;

    @ElementCollection
    @CollectionTable(name = "project_goals", joinColumns = @JoinColumn(name = "project_id"))
    @Column(columnDefinition = "TEXT")
    private List<String> goals = new ArrayList<>();

    @ElementCollection
    @CollectionTable(name = "project_tags", joinColumns = @JoinColumn(name = "project_id"))
    private List<String> tags = new ArrayList<>();

    private Instant createdAt;
    private Instant updatedAt;

    @PrePersist
    protected void onCreate() {
        createdAt = Instant.now();
        updatedAt = Instant.now();
    }

    @PreUpdate
    protected void onUpdate() {
        updatedAt = Instant.now();
    }

    // Getters and Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getGenre() { return genre; }
    public void setGenre(String genre) { this.genre = genre; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public String getStage() { return stage; }
    public void setStage(String stage) { this.stage = stage; }
    public Long getTargetWordCount() { return targetWordCount; }
    public void setTargetWordCount(Long targetWordCount) { this.targetWordCount = targetWordCount; }
    public Long getCompletedWordCount() { return completedWordCount; }
    public void setCompletedWordCount(Long completedWordCount) { this.completedWordCount = completedWordCount; }
    public List<String> getGoals() { return goals; }
    public void setGoals(List<String> goals) { this.goals = goals; }
    public List<String> getTags() { return tags; }
    public void setTags(List<String> tags) { this.tags = tags; }
    public Instant getCreatedAt() { return createdAt; }
    public Instant getUpdatedAt() { return updatedAt; }
}
