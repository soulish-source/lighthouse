package com.soulish.lighthouse.task.dto;

import java.util.List;

public class GenerationTaskDto {
    private String id;
    private String taskType;
    private String targetRef;
    private String status;
    private String owner;
    private String modelProfile;
    private Integer progress;
    private List<String> blockers;
    private List<String> checklist;

    public GenerationTaskDto(String id, String taskType, String targetRef, String status, String owner, String modelProfile, Integer progress, List<String> blockers, List<String> checklist) {
        this.id = id;
        this.taskType = taskType;
        this.targetRef = targetRef;
        this.status = status;
        this.owner = owner;
        this.modelProfile = modelProfile;
        this.progress = progress;
        this.blockers = blockers;
        this.checklist = checklist;
    }

    public String getId() { return id; }
    public String getTaskType() { return taskType; }
    public String getTargetRef() { return targetRef; }
    public String getStatus() { return status; }
    public String getOwner() { return owner; }
    public String getModelProfile() { return modelProfile; }
    public Integer getProgress() { return progress; }
    public List<String> getBlockers() { return blockers; }
    public List<String> getChecklist() { return checklist; }
}
