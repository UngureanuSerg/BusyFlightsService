package com.travix.medusa.busyflights.flightmappers;

import com.travix.medusa.busyflights.domain.busyflights.BusyFlightsRequest;
import com.travix.medusa.busyflights.domain.busyflights.BusyFlightsResponse;
import java.util.List;

/**
 * Base busy flights mapper, map given busy flight request to busy flights responses, based on the
 * external flight supplier.
 *
 * @param <Ir> incoming request
 * @param <Or> outgoing responses
 */
public interface BusyFlightsMapper<Ir, Or> {

  Ir convertToRequests(BusyFlightsRequest busyFlightsRequest);

  List<BusyFlightsResponse> convertToResponses(List<Or> responses);
}
