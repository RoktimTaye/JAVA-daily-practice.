package com.TrainTracking.Tracking.Repository;

import com.TrainTracking.Tracking.Entity.Station;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StationReposiotry extends JpaRepository<Station,Long> {
}
