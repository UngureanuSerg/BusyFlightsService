package com.travix.medusa.busyflights.services.ports;

import com.travix.medusa.busyflights.domain.crazyair.CrazyAirRequest;
import com.travix.medusa.busyflights.domain.crazyair.CrazyAirResponse;
import com.travix.medusa.busyflights.services.FlightsSupplierPort;
import java.util.Collections;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class CrazyAirServicePort implements FlightsSupplierPort<CrazyAirRequest, CrazyAirResponse> {

  @Override
  public List<CrazyAirResponse> searchForFlights(CrazyAirRequest incomingServiceRequest) {
    return Collections.emptyList();
  }
}
