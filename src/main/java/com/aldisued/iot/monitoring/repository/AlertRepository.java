package com.aldisued.iot.monitoring.repository;


import com.aldisued.iot.monitoring.entity.Alert;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.UUID;

public interface AlertRepository extends JpaRepository<Alert, String> {

  @Query(value = "SELECT * FROM alerts WHERE sensor_id = :sensorId ORDER BY timestamp DESC LIMIT 1", nativeQuery = true)
  Alert findFirstBySensorIdOrderByTimestampDesc(@Param("sensorId") UUID sensorId);

}
