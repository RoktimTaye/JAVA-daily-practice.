package com.TrainTracking.Tracking.Repository;

import com.TrainTracking.Tracking.Entity.trainSchedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TrainScheduleRepository extends JpaRepository<trainSchedule,Long> {

    List<trainSchedule> findBysource_StationCodeAndDestinationCode(String sourceCode, String destinationCode);

    List<trainSchedule> findBysource_StationNameAndDestinationName(String sourceName, String destinationName);

}
