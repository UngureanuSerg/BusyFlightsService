package com.travix.medusa.busyflights.adapter;

import com.travix.medusa.busyflights.domain.busyflights.BusyFlightsRequest;
import com.travix.medusa.busyflights.domain.busyflights.BusyFlightsResponse;
import java.util.List;

public interface BusyFlightsAdapter<IR,IO> {

  IR convertToRequest(BusyFlightsRequest request);

  List<BusyFlightsResponse> convertToResponse(List<IO> response);
}
