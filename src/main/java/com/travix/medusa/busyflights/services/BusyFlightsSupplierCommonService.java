package com.travix.medusa.busyflights.services;

import com.travix.medusa.busyflights.domain.busyflights.BusyFlightsRequest;
import com.travix.medusa.busyflights.domain.busyflights.BusyFlightsResponse;
import java.util.Collections;
import java.util.List;

public interface BusyFlightsSupplierCommonService<IR, OR> extends BusyFlightsSupplierService {

  default List<BusyFlightsResponse> searchForFlights(BusyFlightsRequest busyFlightsRequest) {

    return Collections.emptyList();
  }
}
