package com.soulish.lighthouse.timeline.dto;

import java.util.List;

public class TimelineEventDto {
    private String id;
    private String dayLabel;
    private String eventTitle;
    private String chapterRef;
    private String location;
    private List<String> participants;
    private String consequence;

    public TimelineEventDto(String id, String dayLabel, String eventTitle, String chapterRef, String location, List<String> participants, String consequence) {
        this.id = id;
        this.dayLabel = dayLabel;
        this.eventTitle = eventTitle;
        this.chapterRef = chapterRef;
        this.location = location;
        this.participants = participants;
        this.consequence = consequence;
    }

    public String getId() { return id; }
    public String getDayLabel() { return dayLabel; }
    public String getEventTitle() { return eventTitle; }
    public String getChapterRef() { return chapterRef; }
    public String getLocation() { return location; }
    public List<String> getParticipants() { return participants; }
    public String getConsequence() { return consequence; }
}
