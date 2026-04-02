package com.soulish.lighthouse.chapter.entity;

import javax.persistence.*;
import org.hibernate.annotations.GenericGenerator;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "chapters")
public class Chapter {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;

    private String projectId;
    private String outlineNodeId;
    private String volumeTitle;
    private String title;

    @Enumerated(EnumType.STRING)
    private ChapterStatus status = ChapterStatus.PLANNED;

    private String pov;
    private Integer targetWordCount;
    private Integer currentWordCount;
    private String note;

    @ElementCollection
    @CollectionTable(name = "chapter_characters", joinColumns = @JoinColumn(name = "chapter_id"))
    private List<String> characters = new ArrayList<>();

    @ElementCollection
    @CollectionTable(name = "chapter_foreshadows", joinColumns = @JoinColumn(name = "chapter_id"))
    private List<String> foreshadows = new ArrayList<>();

    private Instant createdAt;
    private Instant updatedAt;

    public enum ChapterStatus {
        PLANNED, DRAFTING, REVIEW, PUBLISHED
    }

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
    public String getProjectId() { return projectId; }
    public void setProjectId(String projectId) { this.projectId = projectId; }
    public String getOutlineNodeId() { return outlineNodeId; }
    public void setOutlineNodeId(String outlineNodeId) { this.outlineNodeId = outlineNodeId; }
    public String getVolumeTitle() { return volumeTitle; }
    public void setVolumeTitle(String volumeTitle) { this.volumeTitle = volumeTitle; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public ChapterStatus getStatus() { return status; }
    public void setStatus(ChapterStatus status) { this.status = status; }
    public String getPov() { return pov; }
    public void setPov(String pov) { this.pov = pov; }
    public Integer getTargetWordCount() { return targetWordCount; }
    public void setTargetWordCount(Integer targetWordCount) { this.targetWordCount = targetWordCount; }
    public Integer getCurrentWordCount() { return currentWordCount; }
    public void setCurrentWordCount(Integer currentWordCount) { this.currentWordCount = currentWordCount; }
    public String getNote() { return note; }
    public void setNote(String note) { this.note = note; }
    public List<String> getCharacters() { return characters; }
    public void setCharacters(List<String> characters) { this.characters = characters; }
    public List<String> getForeshadows() { return foreshadows; }
    public void setForeshadows(List<String> foreshadows) { this.foreshadows = foreshadows; }
    public Instant getCreatedAt() { return createdAt; }
    public Instant getUpdatedAt() { return updatedAt; }
}
