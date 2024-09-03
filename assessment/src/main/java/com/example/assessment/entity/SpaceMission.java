package com.example.assessment.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class SpaceMission {
//"missionName": "string",
//        "launchDate": "ISO8601 date",
//        "missionType": "SATELLITE_DEPLOYMENT | EXPLORATION | RESUPPLY",
//        "status": "SUCCESS | FAILURE | IN_PROGRESS",
//        "crewSize": "integer"

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String missionName;

    private String launchDate;

    private MissionType missionType;

    private Status status;

    private int crewSize;

}
