package com.soulish.lighthouse.chapter.dto;

import java.util.List;

public class ChapterCardDto {
    private String id;
    private String title;
    private String volumeTitle;
    private String status;
    private String pov;
    private Integer targetWords;
    private Integer currentWords;
    private String updatedAt;
    private List<String> focusCharacters;
    private List<String> relatedForeshadows;

    public ChapterCardDto(String id, String title, String volumeTitle, String status, String pov, Integer targetWords, Integer currentWords, String updatedAt, List<String> focusCharacters, List<String> relatedForeshadows) {
        this.id = id;
        this.title = title;
        this.volumeTitle = volumeTitle;
        this.status = status;
        this.pov = pov;
        this.targetWords = targetWords;
        this.currentWords = currentWords;
        this.updatedAt = updatedAt;
        this.focusCharacters = focusCharacters;
        this.relatedForeshadows = relatedForeshadows;
    }

    public String getId() { return id; }
    public String getTitle() { return title; }
    public String getVolumeTitle() { return volumeTitle; }
    public String getStatus() { return status; }
    public String getPov() { return pov; }
    public Integer getTargetWords() { return targetWords; }
    public Integer getCurrentWords() { return currentWords; }
    public String getUpdatedAt() { return updatedAt; }
    public List<String> getFocusCharacters() { return focusCharacters; }
    public List<String> getRelatedForeshadows() { return relatedForeshadows; }
}
