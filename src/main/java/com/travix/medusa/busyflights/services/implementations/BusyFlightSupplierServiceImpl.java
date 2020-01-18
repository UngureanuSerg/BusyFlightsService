package com.travix.medusa.busyflights.services.implementations;

import com.travix.medusa.busyflights.domain.busyflights.BusyFlightsRequest;
import com.travix.medusa.busyflights.domain.busyflights.BusyFlightsResponse;
import com.travix.medusa.busyflights.services.BusyFlightsSupplierService;
import java.util.Collections;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class BusyFlightSupplierServiceImpl implements BusyFlightsSupplierService {

  public BusyFlightSupplierServiceImpl() {
  }

  @Override
  public List<BusyFlightsResponse> searchForFlights(BusyFlightsRequest busyFlightsRequest) {
    return Collections.emptyList();
  }
}
