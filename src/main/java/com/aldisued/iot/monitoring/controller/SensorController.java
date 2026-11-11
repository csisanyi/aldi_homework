package com.aldisued.iot.monitoring.controller;

import com.aldisued.iot.monitoring.dto.SensorDto;
import com.aldisued.iot.monitoring.entity.Sensor;
import com.aldisued.iot.monitoring.service.SensorService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/sensors")
public class SensorController {

  private final SensorService sensorService;

  public SensorController(SensorService sensorService) {
    this.sensorService = sensorService;
  }

  @PostMapping
  public Sensor saveSensor(@RequestBody SensorDto sensorDto) {
    if (sensorDto.name() == null || sensorDto.name().isBlank()) {
      throw new ResponseStatusException(
              org.springframework.http.HttpStatus.BAD_REQUEST,
              "Sensor name must not be null or blank");
    }
    return sensorService.saveSensor(sensorDto);
  }
}