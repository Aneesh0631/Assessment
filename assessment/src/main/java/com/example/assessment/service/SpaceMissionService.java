package com.example.assessment.service;

import com.example.assessment.Repository.SpaceMissionRepo;
import com.example.assessment.entity.MissionStats;
import com.example.assessment.entity.SpaceMission;
import com.example.assessment.entity.SpacemissionDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SpaceMissionService {
    @Autowired
    private SpaceMissionRepo spaceMissionRepo;

    public SpaceMission logNewSpaceMission(SpacemissionDTO spaceMission){
        SpaceMission newSpaceMission = new SpaceMission();
        newSpaceMission.setMissionName(spaceMission.getMissionName());
        newSpaceMission.setLaunchDate(spaceMission.getLaunchDate());
        newSpaceMission.setMissionType(spaceMission.getMissionType());
        newSpaceMission.setStatus(spaceMission.getStatus());
        newSpaceMission.setCrewSize(spaceMission.getCrewSize());
        spaceMissionRepo.save(newSpaceMission);

        return newSpaceMission;
    }
//    public MissionStats getMissionStats(){
//        return spaceMissionRepo.getMissionStats();
//    }

    public Optional<SpaceMission> getLastMission(){
        return spaceMissionRepo.findLastEntry();
    }
}
