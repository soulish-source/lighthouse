package com.soulish.lighthouse.character.dto;

import java.util.List;

public class CharacterCardDto {
    private String id;
    private String name;
    private String role;
    private String faction;
    private String currentArc;
    private String status;
    private List<String> traits;
    private List<String> unresolvedThreads;

    public CharacterCardDto(String id, String name, String role, String faction, String currentArc, String status, List<String> traits, List<String> unresolvedThreads) {
        this.id = id;
        this.name = name;
        this.role = role;
        this.faction = faction;
        this.currentArc = currentArc;
        this.status = status;
        this.traits = traits;
        this.unresolvedThreads = unresolvedThreads;
    }

    public String getId() { return id; }
    public String getName() { return name; }
    public String getRole() { return role; }
    public String getFaction() { return faction; }
    public String getCurrentArc() { return currentArc; }
    public String getStatus() { return status; }
    public List<String> getTraits() { return traits; }
    public List<String> getUnresolvedThreads() { return unresolvedThreads; }
}
