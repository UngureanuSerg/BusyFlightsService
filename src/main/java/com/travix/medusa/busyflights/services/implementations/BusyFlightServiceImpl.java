package com.travix.medusa.busyflights.services.implementations;

import com.travix.medusa.busyflights.domain.busyflights.BusyFlightsRequest;
import com.travix.medusa.busyflights.domain.busyflights.BusyFlightsResponse;
import com.travix.medusa.busyflights.services.BusyFlightsService;
import java.util.Collections;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class BusyFlightServiceImpl implements BusyFlightsService {

  public BusyFlightServiceImpl() {
  }

  @Override
  public List<BusyFlightsResponse> searchForFlights(BusyFlightsRequest busyFlightsRequest) {
    return Collections.emptyList();
  }
}
