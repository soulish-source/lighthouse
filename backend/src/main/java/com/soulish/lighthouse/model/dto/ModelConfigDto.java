package com.soulish.lighthouse.model.dto;

import java.util.List;

public class ModelConfigDto {
    private String id;
    private String profileName;
    private String provider;
    private String primaryModel;
    private String fallbackModel;
    private Double temperature;
    private Integer maxContextTokens;
    private List<String> capabilities;
    private String promptPreset;
    private String memoryPolicy;

    public ModelConfigDto() {}

    public ModelConfigDto(String id, String profileName, String provider, String primaryModel, String fallbackModel, Double temperature, Integer maxContextTokens, List<String> capabilities, String promptPreset, String memoryPolicy) {
        this.id = id;
        this.profileName = profileName;
        this.provider = provider;
        this.primaryModel = primaryModel;
        this.fallbackModel = fallbackModel;
        this.temperature = temperature;
        this.maxContextTokens = maxContextTokens;
        this.capabilities = capabilities;
        this.promptPreset = promptPreset;
        this.memoryPolicy = memoryPolicy;
    }

    public String getId() { return id; }
    public String getProfileName() { return profileName; }
    public String getProvider() { return provider; }
    public String getPrimaryModel() { return primaryModel; }
    public String getFallbackModel() { return fallbackModel; }
    public Double getTemperature() { return temperature; }
    public Integer getMaxContextTokens() { return maxContextTokens; }
    public List<String> getCapabilities() { return capabilities; }
    public String getPromptPreset() { return promptPreset; }
    public String getMemoryPolicy() { return memoryPolicy; }

    public void setId(String id) { this.id = id; }
    public void setProfileName(String profileName) { this.profileName = profileName; }
    public void setProvider(String provider) { this.provider = provider; }
    public void setPrimaryModel(String primaryModel) { this.primaryModel = primaryModel; }
    public void setFallbackModel(String fallbackModel) { this.fallbackModel = fallbackModel; }
    public void setTemperature(Double temperature) { this.temperature = temperature; }
    public void setMaxContextTokens(Integer maxContextTokens) { this.maxContextTokens = maxContextTokens; }
    public void setCapabilities(List<String> capabilities) { this.capabilities = capabilities; }
    public void setPromptPreset(String promptPreset) { this.promptPreset = promptPreset; }
    public void setMemoryPolicy(String memoryPolicy) { this.memoryPolicy = memoryPolicy; }
}
