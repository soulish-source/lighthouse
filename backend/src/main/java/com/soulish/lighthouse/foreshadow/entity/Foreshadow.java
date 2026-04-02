package com.soulish.lighthouse.foreshadow.entity;

import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "foreshadows")
public class Foreshadow {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;

    private String projectId;
    private String title;
    private String status;
    private String plantedAt;
    private String targetPayoff;
    private String riskLevel;
    @Column(columnDefinition = "TEXT")
    private String notes;

    @ElementCollection
    @CollectionTable(name = "foreshadow_characters", joinColumns = @JoinColumn(name = "foreshadow_id"))
    private List<String> relatedCharacters = new ArrayList<>();

    private Instant createdAt;
    private Instant updatedAt;

    @PrePersist
    protected void onCreate() { createdAt = Instant.now(); updatedAt = Instant.now(); }
    @PreUpdate
    protected void onUpdate() { updatedAt = Instant.now(); }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getProjectId() { return projectId; }
    public void setProjectId(String projectId) { this.projectId = projectId; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    public String getPlantedAt() { return plantedAt; }
    public void setPlantedAt(String plantedAt) { this.plantedAt = plantedAt; }
    public String getTargetPayoff() { return targetPayoff; }
    public void setTargetPayoff(String targetPayoff) { this.targetPayoff = targetPayoff; }
    public String getRiskLevel() { return riskLevel; }
    public void setRiskLevel(String riskLevel) { this.riskLevel = riskLevel; }
    public String getNotes() { return notes; }
    public void setNotes(String notes) { this.notes = notes; }
    public List<String> getRelatedCharacters() { return relatedCharacters; }
    public void setRelatedCharacters(List<String> relatedCharacters) { this.relatedCharacters = relatedCharacters; }
    public Instant getCreatedAt() { return createdAt; }
    public Instant getUpdatedAt() { return updatedAt; }
}
