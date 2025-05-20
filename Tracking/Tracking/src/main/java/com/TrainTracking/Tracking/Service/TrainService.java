package com.TrainTracking.Tracking.Service;

import com.TrainTracking.Tracking.Entity.Train;
import com.TrainTracking.Tracking.Repository.TrainRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrainService {

    private TrainRepository trainRepository;

    public TrainService(TrainRepository trainRepository){
        this.trainRepository = trainRepository;
    }
    public List<Train> getAllTrains() {
        return trainRepository.findAll();
    }

    public Train addTrains(Train train) {
        return trainRepository.save(train);
    }
}
