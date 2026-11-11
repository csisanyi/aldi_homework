package com.aldisued.iot.monitoring.repository;


import com.aldisued.iot.monitoring.entity.Alert;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.UUID;

public interface AlertRepository extends JpaRepository<Alert, String> {

  Alert findFirstBySensorIdOrderByTimestampDesc(UUID sensorId);

}
