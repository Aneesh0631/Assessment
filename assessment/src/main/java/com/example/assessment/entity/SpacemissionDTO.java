package com.example.assessment.entity;

import lombok.Data;

@Data
public class SpacemissionDTO {
    private String missionName;

    private String launchDate;

    private MissionType missionType;

    private Status status;

    private int crewSize;
}
