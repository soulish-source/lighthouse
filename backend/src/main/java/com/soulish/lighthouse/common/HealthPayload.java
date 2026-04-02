package com.soulish.lighthouse.common;

public class HealthPayload {
    private String service;
    private String status;
    private String stage;

    public HealthPayload(String service, String status, String stage) {
        this.service = service;
        this.status = status;
        this.stage = stage;
    }

    public String getService() { return service; }
    public String getStatus() { return status; }
    public String getStage() { return stage; }
}
