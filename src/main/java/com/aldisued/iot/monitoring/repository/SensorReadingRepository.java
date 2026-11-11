package com.aldisued.iot.monitoring.repository;

import com.aldisued.iot.monitoring.entity.SensorReading;
import java.time.LocalDateTime;
import java.util.Optional;

import com.aldisued.iot.monitoring.entity.SensorType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface SensorReadingRepository extends JpaRepository<SensorReading, String> {

  @Query("SELECT AVG(sr.value) FROM SensorReading sr " +
      "JOIN sr.sensor s WHERE s.type = :sensorType AND sr.timestamp BETWEEN :from AND :to")
  Optional<Double> findAverageTemperatureBySensorType(@Param("sensorType") SensorType sensorType,
      @Param("from") LocalDateTime from, @Param("to") LocalDateTime to);

}
