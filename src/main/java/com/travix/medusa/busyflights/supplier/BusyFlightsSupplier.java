package com.travix.medusa.busyflights.supplier;

import com.travix.medusa.busyflights.domain.busyflights.BusyFlightsRequest;
import com.travix.medusa.busyflights.domain.busyflights.BusyFlightsResponse;
import java.util.List;

/**
 * Basic interface for given suppliers
 */
public interface BusyFlightsSupplier {
  List<BusyFlightsResponse> searchFlightsByRequest(BusyFlightsRequest request);
}
