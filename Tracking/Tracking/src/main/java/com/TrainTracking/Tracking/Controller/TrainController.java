package com.TrainTracking.Tracking.Controller;

import com.TrainTracking.Tracking.Entity.Train;
import com.TrainTracking.Tracking.Service.TrainService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/train")
public class TrainController {

    private TrainService trainService;
    public TrainController(TrainService trainService){
        this.trainService = trainService;
    }

    @GetMapping
    public List<Train> getAllTrains(){
        return trainService.getAllTrains();
    }

    @PostMapping
    public Train addTrain(@RequestBody Train train){
        return trainService.addTrains(train);
    }

}
