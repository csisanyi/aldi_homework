package com.aldisued.iot.monitoring.service;


import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class MeasurementCalculatorService {

  public List<Double> filterByAverageDeviation(List<Double> values, Double deviation) {
    if (deviation < 0.0 || deviation > 1.0) {
      throw new IllegalArgumentException("Deviation must be between 0.0 and 1.0");
    }
    if (values.isEmpty()) {
      return List.of();
    }
    double average = values.stream().mapToDouble(Double::doubleValue).average().orElse(0.0);
    double lowerBound = average * (1.0 - deviation);
    double upperBound = average * (1.0 + deviation);
    return values.stream()
            .filter(v -> v >= lowerBound && v <= upperBound)
            .toList();
  }

  public List<Double> getMovingAverage(List<Double> data, int windowSize) {
    // TODO: Task 10
    return List.of();
  }

}
