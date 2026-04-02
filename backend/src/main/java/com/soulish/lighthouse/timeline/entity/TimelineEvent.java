package com.soulish.lighthouse.timeline.entity;

import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "timeline_events")
public class TimelineEvent {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;

    private String projectId;
    private String dayLabel;
    private String eventTitle;
    private String chapterRef;
    private String location;
    @Column(columnDefinition = "TEXT")
    private String consequence;

    @ElementCollection
    @CollectionTable(name = "timeline_participants", joinColumns = @JoinColumn(name = "timeline_event_id"))
    private List<String> participants = new ArrayList<>();

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
    public String getDayLabel() { return dayLabel; }
    public void setDayLabel(String dayLabel) { this.dayLabel = dayLabel; }
    public String getEventTitle() { return eventTitle; }
    public void setEventTitle(String eventTitle) { this.eventTitle = eventTitle; }
    public String getChapterRef() { return chapterRef; }
    public void setChapterRef(String chapterRef) { this.chapterRef = chapterRef; }
    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }
    public String getConsequence() { return consequence; }
    public void setConsequence(String consequence) { this.consequence = consequence; }
    public List<String> getParticipants() { return participants; }
    public void setParticipants(List<String> participants) { this.participants = participants; }
    public Instant getCreatedAt() { return createdAt; }
    public Instant getUpdatedAt() { return updatedAt; }
}
