package com.soulish.lighthouse.outline.dto;

import java.util.List;

public class OutlineNodeDto {
    private String id;
    private String type;
    private String title;
    private String summary;
    private String goal;
    private String pov;
    private String status;
    private List<String> keyConflicts;
    private List<String> reveals;
    private List<String> dependencies;

    public OutlineNodeDto(String id, String type, String title, String summary, String goal, String pov, String status, List<String> keyConflicts, List<String> reveals, List<String> dependencies) {
        this.id = id;
        this.type = type;
        this.title = title;
        this.summary = summary;
        this.goal = goal;
        this.pov = pov;
        this.status = status;
        this.keyConflicts = keyConflicts;
        this.reveals = reveals;
        this.dependencies = dependencies;
    }

    public String getId() { return id; }
    public String getType() { return type; }
    public String getTitle() { return title; }
    public String getSummary() { return summary; }
    public String getGoal() { return goal; }
    public String getPov() { return pov; }
    public String getStatus() { return status; }
    public List<String> getKeyConflicts() { return keyConflicts; }
    public List<String> getReveals() { return reveals; }
    public List<String> getDependencies() { return dependencies; }
}
