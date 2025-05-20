package com.TrainTracking.Tracking.Controller;

import com.TrainTracking.Tracking.Entity.Station;
import com.TrainTracking.Tracking.Entity.Train;
import com.TrainTracking.Tracking.Entity.trainSchedule;
import com.TrainTracking.Tracking.Repository.StationReposiotry;
import com.TrainTracking.Tracking.Repository.TrainRepository;
import com.TrainTracking.Tracking.Repository.TrainScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/test")
public class Test {

    @Autowired
    StationReposiotry stationRepository;

    @Autowired
    TrainRepository trainRepository;

    @Autowired
    TrainScheduleRepository trainScheduleRepository;

    @GetMapping
    public void test(){

        Station delhi = new Station(null,"new delhi","NDLS");
        Station mumbai = new Station(null,"mumbai centrral","CST");
        Station kolkatta = new Station(null,"kolkatta","KOAA");
        Station chennai = new Station(null,"chennai central","MSA");

        stationRepository.saveAll(List.of(delhi, mumbai, kolkatta, chennai));

        Train rajdhani = new Train(null,"rajdhani express","12345",null);
        Train durunto = new Train(null,"durunto express","10355",null);
        Train satabdi = new Train(null,"satabdi express","19648",null);

        trainRepository.saveAll(List.of(rajdhani, durunto, satabdi));

        trainSchedule sc1 =
                new trainSchedule(null,rajdhani,delhi,mumbai,"06:00","14:00");
        trainSchedule sc2 =
                new trainSchedule(null,durunto,mumbai,kolkatta,"08:00","21:00");
        trainSchedule sc3 =
                new trainSchedule(null,satabdi,kolkatta,chennai,"11:30","19:00");

        trainScheduleRepository.saveAll(List.of(sc1,sc2,sc3));

        System.out.printf("Data Inserted in database");

    }
}
