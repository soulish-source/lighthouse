package com.soulish.lighthouse.chapter.dto;

import java.util.List;

public class ChapterCreateDto {
    private String projectId;
    private String outlineNodeId;
    private String volumeTitle;
    private String title;
    private String status;
    private String pov;
    private Integer targetWordCount;
    private Integer currentWordCount;
    private String note;
    private List<String> characters;
    private List<String> foreshadows;

    public String getProjectId() { return projectId; }
    public void setProjectId(String projectId) { this.projectId = projectId; }
    public String getOutlineNodeId() { return outlineNodeId; }
    public void setOutlineNodeId(String outlineNodeId) { this.outlineNodeId = outlineNodeId; }
    public String getVolumeTitle() { return volumeTitle; }
    public void setVolumeTitle(String volumeTitle) { this.volumeTitle = volumeTitle; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
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
}
