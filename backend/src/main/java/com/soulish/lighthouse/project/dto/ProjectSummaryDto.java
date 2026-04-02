package com.soulish.lighthouse.project.dto;

import java.util.List;

public class ProjectSummaryDto {
    private String id;
    private String name;
    private String genre;
    private String premise;
    private String stage;
    private Integer targetWords;
    private Integer completedWords;
    private List<String> narrativeGoals;
    private List<String> labels;

    public ProjectSummaryDto(String id, String name, String genre, String premise, String stage, Integer targetWords, Integer completedWords, List<String> narrativeGoals, List<String> labels) {
        this.id = id;
        this.name = name;
        this.genre = genre;
        this.premise = premise;
        this.stage = stage;
        this.targetWords = targetWords;
        this.completedWords = completedWords;
        this.narrativeGoals = narrativeGoals;
        this.labels = labels;
    }

    public String getId() { return id; }
    public String getName() { return name; }
    public String getGenre() { return genre; }
    public String getPremise() { return premise; }
    public String getStage() { return stage; }
    public Integer getTargetWords() { return targetWords; }
    public Integer getCompletedWords() { return completedWords; }
    public List<String> getNarrativeGoals() { return narrativeGoals; }
    public List<String> getLabels() { return labels; }
}
