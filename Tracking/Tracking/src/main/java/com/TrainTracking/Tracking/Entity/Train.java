package com.TrainTracking.Tracking.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Train {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long Id;
    private String trainName;
    private String trainNumber;

    @OneToMany(mappedBy = "train", cascade = CascadeType.ALL)
    @JsonBackReference
    List<trainSchedule> scheduleList;

    public Train(){

    }

    public Train(Long id, String trainName, String trainNumber, List<trainSchedule> scheduleList) {
        Id = id;
        this.trainName = trainName;
        this.trainNumber = trainNumber;
        this.scheduleList = scheduleList;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getTrainName() {
        return trainName;
    }

    public void setTrainName(String trainName) {
        this.trainName = trainName;
    }

    public String getTrainNumber() {
        return trainNumber;
    }

    public void setTrainNumber(String trainNumber) {
        this.trainNumber = trainNumber;
    }

    public List<trainSchedule> getScheduleList() {
        return scheduleList;
    }

    public void setScheduleList(List<trainSchedule> scheduleList) {
        this.scheduleList = scheduleList;
    }
}
