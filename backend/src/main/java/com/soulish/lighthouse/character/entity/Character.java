package com.soulish.lighthouse.character.entity;

import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "characters")
public class Character {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;

    private String projectId;
    private String name;
    private String role;
    private String faction;
    private String currentArc;
    @Column(columnDefinition = "TEXT")
    private String status;
    private String traits;
    private String unresolvedThreads;

    @ElementCollection
    @CollectionTable(name = "character_traits", joinColumns = @JoinColumn(name = "character_id"))
    private List<String> traitsList = new ArrayList<>();

    @ElementCollection
    @CollectionTable(name = "character_unresolved", joinColumns = @JoinColumn(name = "character_id"))
    private List<String> unresolvedThreadsList = new ArrayList<>();

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
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getRole() { return role; }
    public void setRole(String role) { this.role = role; }
    public String getFaction() { return faction; }
    public void setFaction(String faction) { this.faction = faction; }
    public String getCurrentArc() { return currentArc; }
    public void setCurrentArc(String currentArc) { this.currentArc = currentArc; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    public String getTraits() { return traits; }
    public void setTraits(String traits) { this.traits = traits; }
    public String getUnresolvedThreads() { return unresolvedThreads; }
    public void setUnresolvedThreads(String unresolvedThreads) { this.unresolvedThreads = unresolvedThreads; }
    public List<String> getTraitsList() { return traitsList; }
    public void setTraitsList(List<String> traitsList) { this.traitsList = traitsList; }
    public List<String> getUnresolvedThreadsList() { return unresolvedThreadsList; }
    public void setUnresolvedThreadsList(List<String> unresolvedThreadsList) { this.unresolvedThreadsList = unresolvedThreadsList; }
    public Instant getCreatedAt() { return createdAt; }
    public Instant getUpdatedAt() { return updatedAt; }
}
