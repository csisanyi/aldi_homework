package com.aldisued.iot.monitoring.service;

import com.aldisued.iot.monitoring.dto.SensorDto;
import com.aldisued.iot.monitoring.entity.Sensor;
import com.aldisued.iot.monitoring.repository.SensorRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class SensorService {

  private final SensorRepository sensorRepository;

  public SensorService(SensorRepository sensorRepository) {
    this.sensorRepository = sensorRepository;
  }

  public Sensor saveSensor(SensorDto sensor) {
    if (sensorRepository.existsByName(sensor.name())) {
      throw new ResponseStatusException(
              org.springframework.http.HttpStatus.CONFLICT,
              "A sensor with this name already exists");
    }
    return sensorRepository.save(new Sensor(
            sensor.name(),
            sensor.type()
    ));
  }
}
