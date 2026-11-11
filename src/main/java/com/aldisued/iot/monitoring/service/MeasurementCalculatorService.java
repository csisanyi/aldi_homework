package com.aldisued.iot.monitoring.service;


import java.util.List;
import java.util.stream.IntStream;

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
    if (windowSize <= 0) {
      throw new IllegalArgumentException("Window size must be a positive integer");
    }
    if (windowSize > data.size()) {
      throw new IllegalArgumentException("Window size must not be greater than the number of values");
    }
    return IntStream.range(0, data.size() - windowSize + 1)
            .mapToObj(i -> data.subList(i, i + windowSize))
            .map(v -> v.stream().mapToDouble(Double::doubleValue).average().orElse(0.0))
            .toList();
  }

}
