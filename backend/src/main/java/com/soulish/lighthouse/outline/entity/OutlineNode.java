package com.soulish.lighthouse.outline.entity;

import javax.persistence.*;
import org.hibernate.annotations.GenericGenerator;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "outline_nodes")
public class OutlineNode {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;

    private String projectId;
    private String arcId;

    @Enumerated(EnumType.STRING)
    private NodeType type;

    private String title;
    @Column(columnDefinition = "TEXT")
    private String description;
    private String goal;
    private String pov;

    @Enumerated(EnumType.STRING)
    private NodeStatus status = NodeStatus.PLANNED;

    @ElementCollection
    @CollectionTable(name = "outline_conflicts", joinColumns = @JoinColumn(name = "outline_node_id"))
    @Column(columnDefinition = "TEXT")
    private List<String> conflicts = new ArrayList<>();

    @ElementCollection
    @CollectionTable(name = "outline_reveals", joinColumns = @JoinColumn(name = "outline_node_id"))
    @Column(columnDefinition = "TEXT")
    private List<String> reveals = new ArrayList<>();

    @ElementCollection
    @CollectionTable(name = "outline_prereqs", joinColumns = @JoinColumn(name = "outline_node_id"))
    private List<String> prerequisites = new ArrayList<>();

    private Instant createdAt;
    private Instant updatedAt;

    public enum NodeType { VOLUME, CHAPTER }
    public enum NodeStatus { PLANNED, ACTIVE, COMPLETED }

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
    public String getArcId() { return arcId; }
    public void setArcId(String arcId) { this.arcId = arcId; }
    public NodeType getType() { return type; }
    public void setType(NodeType type) { this.type = type; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public String getGoal() { return goal; }
    public void setGoal(String goal) { this.goal = goal; }
    public String getPov() { return pov; }
    public void setPov(String pov) { this.pov = pov; }
    public NodeStatus getStatus() { return status; }
    public void setStatus(NodeStatus status) { this.status = status; }
    public List<String> getConflicts() { return conflicts; }
    public void setConflicts(List<String> conflicts) { this.conflicts = conflicts; }
    public List<String> getReveals() { return reveals; }
    public void setReveals(List<String> reveals) { this.reveals = reveals; }
    public List<String> getPrerequisites() { return prerequisites; }
    public void setPrerequisites(List<String> prerequisites) { this.prerequisites = prerequisites; }
    public Instant getCreatedAt() { return createdAt; }
    public Instant getUpdatedAt() { return updatedAt; }
}
