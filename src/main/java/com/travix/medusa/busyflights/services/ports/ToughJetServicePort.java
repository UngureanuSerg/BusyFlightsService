package com.travix.medusa.busyflights.services.ports;

import com.travix.medusa.busyflights.domain.toughjet.ToughJetRequest;
import com.travix.medusa.busyflights.services.FlightsSupplierPort;
import java.util.Collections;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class ToughJetServicePort implements FlightsSupplierPort<ToughJetRequest, ToughJetRequest> {

  @Override
  public List<ToughJetRequest> searchForFlights(ToughJetRequest incomingServiceRequest) {
    return Collections.emptyList();
  }
}
