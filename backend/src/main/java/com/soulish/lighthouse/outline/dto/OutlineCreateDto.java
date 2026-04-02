package com.soulish.lighthouse.outline.dto;

import java.util.List;

public class OutlineCreateDto {
    private String projectId;
    private String arcId;
    private String type;
    private String title;
    private String description;
    private String goal;
    private String pov;
    private String status;
    private List<String> conflicts;
    private List<String> reveals;
    private List<String> prerequisites;

    public String getProjectId() { return projectId; }
    public void setProjectId(String projectId) { this.projectId = projectId; }
    public String getArcId() { return arcId; }
    public void setArcId(String arcId) { this.arcId = arcId; }
    public String getType() { return type; }
    public void setType(String type) { this.type = type; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public String getGoal() { return goal; }
    public void setGoal(String goal) { this.goal = goal; }
    public String getPov() { return pov; }
    public void setPov(String pov) { this.pov = pov; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    public List<String> getConflicts() { return conflicts; }
    public void setConflicts(List<String> conflicts) { this.conflicts = conflicts; }
    public List<String> getReveals() { return reveals; }
    public void setReveals(List<String> reveals) { this.reveals = reveals; }
    public List<String> getPrerequisites() { return prerequisites; }
    public void setPrerequisites(List<String> prerequisites) { this.prerequisites = prerequisites; }
}
