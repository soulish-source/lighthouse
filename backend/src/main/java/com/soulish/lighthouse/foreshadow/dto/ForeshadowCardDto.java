package com.soulish.lighthouse.foreshadow.dto;

import java.util.List;

public class ForeshadowCardDto {
    private String id;
    private String title;
    private String status;
    private String plantedAt;
    private String targetPayoff;
    private String riskLevel;
    private List<String> relatedCharacters;
    private List<String> notes;

    public ForeshadowCardDto(String id, String title, String status, String plantedAt, String targetPayoff, String riskLevel, List<String> relatedCharacters, List<String> notes) {
        this.id = id;
        this.title = title;
        this.status = status;
        this.plantedAt = plantedAt;
        this.targetPayoff = targetPayoff;
        this.riskLevel = riskLevel;
        this.relatedCharacters = relatedCharacters;
        this.notes = notes;
    }

    public String getId() { return id; }
    public String getTitle() { return title; }
    public String getStatus() { return status; }
    public String getPlantedAt() { return plantedAt; }
    public String getTargetPayoff() { return targetPayoff; }
    public String getRiskLevel() { return riskLevel; }
    public List<String> getRelatedCharacters() { return relatedCharacters; }
    public List<String> getNotes() { return notes; }
}
