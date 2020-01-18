package com.travix.medusa.busyflights.services;

import com.travix.medusa.busyflights.domain.busyflights.BusyFlightsRequest;
import com.travix.medusa.busyflights.domain.busyflights.BusyFlightsResponse;
import java.util.List;

/**
 * All flights supplier interface for extendability reasons.
 */
public interface BusyFlightsSupplierService {
  List<BusyFlightsResponse> searchForFlights(BusyFlightsRequest busyFlightsRequest);
}
