package com.travix.medusa.busyflights.flightmappers.crazyair;

import com.travix.medusa.busyflights.domain.busyflights.BusyFlightsRequest;
import com.travix.medusa.busyflights.domain.busyflights.BusyFlightsResponse;
import com.travix.medusa.busyflights.domain.crazyair.CrazyAirRequest;
import com.travix.medusa.busyflights.domain.crazyair.CrazyAirResponse;
import com.travix.medusa.busyflights.flightmappers.BusyFlightsMapper;
import java.util.Collections;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class CrazyAirMapper implements BusyFlightsMapper<CrazyAirRequest, CrazyAirResponse> {

  @Override
  public CrazyAirRequest convertToRequests(BusyFlightsRequest busyFlightsRequest) {
    return CrazyAirRequest.builder()
        .origin(busyFlightsRequest.getOrigin())
        .destination(busyFlightsRequest.getDestination())
        .departureDate(busyFlightsRequest.getDepartureDate())
        .returnDate(busyFlightsRequest.getReturnDate())
        .passengerCount(busyFlightsRequest.getNumberOfPassengers())
        .build();
  }

  @Override
  public List<BusyFlightsResponse> convertToResponses(List<CrazyAirResponse> responses) {
    return Collections.emptyList();
  }
}
