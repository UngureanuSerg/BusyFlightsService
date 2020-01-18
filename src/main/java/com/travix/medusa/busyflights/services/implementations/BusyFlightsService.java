package com.travix.medusa.busyflights.services.implementations;

import com.travix.medusa.busyflights.domain.busyflights.BusyFlightsRequest;
import com.travix.medusa.busyflights.domain.busyflights.BusyFlightsResponse;
import com.travix.medusa.busyflights.flightserviceaggregator.FlightsServiceAggregator;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.springframework.stereotype.Service;

@Service
public class BusyFlightsService {

  private final FlightsServiceAggregator flightsServiceAggregator;

  public BusyFlightsService(
      FlightsServiceAggregator flightsServiceAggregator) {
    this.flightsServiceAggregator = flightsServiceAggregator;
  }

  public List<BusyFlightsResponse> searchForFlights(BusyFlightsRequest busyFlightsRequest) {
    return flightsServiceAggregator.getFlightSuppliers()
        .stream()
        .map(supplier -> supplier.searchForFlights(busyFlightsRequest))
        .flatMap(this::getFutureResult)
        .sorted(Comparator.comparingDouble(BusyFlightsResponse::getFare))
        .collect(Collectors.toList());
  }

  private Stream<BusyFlightsResponse> getFutureResult(List<BusyFlightsResponse> future) {
    return future.stream();
  }

}

