package com.TrainTracking.Tracking.Controller;

import com.TrainTracking.Tracking.Entity.trainSchedule;
import com.TrainTracking.Tracking.Service.TrainSearchService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/search")
public class TrainSearchController {

    private TrainSearchService trainSearchService;

    public TrainSearchController(TrainSearchService trainSearchService){
        this.trainSearchService = trainSearchService;
    }

    @GetMapping("/by-code")
    public List<trainSchedule> findTrainByStationCode(@RequestParam String sourcecode,@RequestParam String destinationCode){
        return trainSearchService.findTrainByStationCode(sourcecode.toString(),destinationCode.toString());
    }

    @GetMapping("/by-name")
    public List<trainSchedule> findTrainByStationName(@RequestParam String sourcename,@RequestParam String destinationName){
        return trainSearchService.findTrainByStationName(sourcename.toString(),destinationName.toString());
    }
}
