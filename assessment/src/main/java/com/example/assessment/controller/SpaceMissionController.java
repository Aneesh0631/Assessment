package com.example.assessment.controller;

import com.example.assessment.entity.MissionStats;
import com.example.assessment.entity.SpaceMission;
import com.example.assessment.entity.SpacemissionDTO;
import com.example.assessment.service.SpaceMissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api")
public class SpaceMissionController {
    @Autowired
    private SpaceMissionService spaceMissionService;

    @PostMapping("/createSpaceMission")
    public ResponseEntity<SpacemissionDTO> logSpaceMission(@RequestBody SpacemissionDTO spaceMission){
        SpaceMission newSpace =  spaceMissionService.logNewSpaceMission(spaceMission);
        return new ResponseEntity<>(spaceMission, HttpStatus.CREATED);
    }

//    @GetMapping("/missions/stats")
//    public MissionStats getMissionStats(){
//        return spaceMissionService.getMissionStats();
//    }

    @GetMapping("/mission/latest")
    public ResponseEntity<SpaceMission> getLastMission(){
        Optional<SpaceMission> lastMission= spaceMissionService.getLastMission();
        return lastMission.map(ResponseEntity::ok).orElseGet(()->ResponseEntity.notFound().build());
    }
}
