package com.TrainTracking.Tracking.Repository;

import com.TrainTracking.Tracking.Entity.Train;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrainRepository extends JpaRepository<Train,Long> {
}
