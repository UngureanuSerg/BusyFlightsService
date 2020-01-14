package com.travix.medusa.busyflights.services;

import com.travix.medusa.busyflights.domain.busyflights.BusyFlightsRequest;
import com.travix.medusa.busyflights.domain.busyflights.BusyFlightsResponse;
import java.util.List;

public interface BusyFlightsService {

  List<BusyFlightsResponse> searchForFlights(BusyFlightsRequest busyFlightsRequest);
}
