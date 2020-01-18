package com.travix.medusa.busyflights.services;

import com.travix.medusa.busyflights.domain.busyflights.BusyFlightsRequest;
import com.travix.medusa.busyflights.domain.busyflights.BusyFlightsResponse;
import com.travix.medusa.busyflights.flightmappers.BusyFlightsMapper;
import com.travix.medusa.busyflights.utils.BusyFlightsCommonUtils;
import java.util.List;
import java.util.stream.Collectors;

public interface BusyFlightsSupplierCommonService<Ir, Or> extends BusyFlightsSupplierService {

  BusyFlightsMapper<Ir, Or> getBusyFlightsSupplierMapper();

  FlightsSupplierPort<Ir, Or> getBusyFlightsSupplierPort();

  // default implementation for mapping search results from crazyair and toughjet api
  default List<BusyFlightsResponse> searchForFlights(BusyFlightsRequest busyFlightsRequest) {
    Ir request = getBusyFlightsSupplierMapper().convertToRequests(busyFlightsRequest);
    List<Or> response = getBusyFlightsSupplierPort().searchForFlights(request);
    return getBusyFlightsSupplierMapper().convertToResponses(response)
        .stream()
        .map(BusyFlightsCommonUtils::calculateFare)
        .collect(Collectors.toList());
  }
}
