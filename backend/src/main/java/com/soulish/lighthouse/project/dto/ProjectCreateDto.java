package com.soulish.lighthouse.project.dto;

import java.util.List;

public class ProjectCreateDto {
    private String name;
    private String genre;
    private String description;
    private String stage;
    private Long targetWordCount;
    private Long completedWordCount;
    private List<String> goals;
    private List<String> tags;

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
}
