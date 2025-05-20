package com.TrainTracking.Tracking.Service;

import com.TrainTracking.Tracking.Entity.trainSchedule;
import com.TrainTracking.Tracking.Repository.TrainScheduleRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrainSearchService {

    private TrainScheduleRepository trainScheduleRepository;
    public List<trainSchedule> findTrainByStationCode(String sourceCode, String destinationCode) {
        return trainScheduleRepository.
                findBysource_StationCodeAndDestinationCode(sourceCode,destinationCode);
    }

    public List<trainSchedule> findTrainByStationName(String sourceName, String destinationName) {
        return trainScheduleRepository.
                findBysource_StationNameAndDestinationName(sourceName,destinationName);
    }
}
