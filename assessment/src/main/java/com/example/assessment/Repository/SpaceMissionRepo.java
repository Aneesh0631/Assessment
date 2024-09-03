package com.example.assessment.Repository;

import com.example.assessment.entity.MissionStats;
import com.example.assessment.entity.SpaceMission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SpaceMissionRepo extends JpaRepository<SpaceMission,Long> {

//    @Query("SELECT m.name,Count(m) As missionCount, " + "SUM(CASE WHEN m.status = 'SUCCESS' THEN 1 ELSE 0 END as success_count, " + "COUNT(m) *100.0/SUM(CASE WHEN m.status = 'SUCCESS' THEN 1 ELSE 0 END) AS successRate, " + "AVG(m.crewSize " + "FROM SpaceMission m GROUP BY m.name")
//    MissionStats getMissionStats();

    @Query("SELECT m FROM SpaceMission m ORDER BY m.id DESC LIMIT 1")
    Optional<SpaceMission> findLastEntry();
}
