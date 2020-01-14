package com.travix.medusa.busyflights.flightmappers.toughjet;

import com.travix.medusa.busyflights.domain.busyflights.BusyFlightsRequest;
import com.travix.medusa.busyflights.domain.busyflights.BusyFlightsResponse;
import com.travix.medusa.busyflights.domain.toughjet.ToughJetRequest;
import com.travix.medusa.busyflights.domain.toughjet.ToughJetResponse;
import com.travix.medusa.busyflights.flightmappers.BusyFlightsMapper;
import java.util.Collections;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class ToughJetMapper implements BusyFlightsMapper<ToughJetRequest, ToughJetResponse> {

  @Override
  public ToughJetRequest convertToRequests(BusyFlightsRequest busyFlightsRequest) {
    return ToughJetRequest.builder()
        .from(busyFlightsRequest.getOrigin())
        .to(busyFlightsRequest.getDestination())
        .numberOfAdults(busyFlightsRequest.getNumberOfPassengers())
        .inboundDate(busyFlightsRequest.getDepartureDate())
        .outboundDate(busyFlightsRequest.getReturnDate())
        .build();
  }

  @Override
  public List<BusyFlightsResponse> convertToResponses(List<ToughJetResponse> responses) {
    return Collections.emptyList();
  }
}
