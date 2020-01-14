package com.travix.medusa.busyflights.flightmappers;

import com.travix.medusa.busyflights.domain.busyflights.BusyFlightsRequest;
import com.travix.medusa.busyflights.domain.busyflights.BusyFlightsResponse;
import java.util.List;

public interface FlightSupplierMapper<IR, OR> {

  IR convertToRequests(BusyFlightsRequest busyFlightsRequest);

  List<BusyFlightsResponse> convertToResponses(List<OR> responses);
}
