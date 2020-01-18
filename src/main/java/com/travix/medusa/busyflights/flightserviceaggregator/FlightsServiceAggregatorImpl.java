package com.travix.medusa.busyflights.flightserviceaggregator;

import com.travix.medusa.busyflights.services.BusyFlightsSupplierService;
import com.travix.medusa.busyflights.services.adapter.CrazyAirServiceSupplier;
import com.travix.medusa.busyflights.services.adapter.ToughJetServiceSupplier;
import java.util.Arrays;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class FlightsServiceAggregatorImpl implements FlightsServiceAggregator {

  private final ToughJetServiceSupplier toughJetServiceSupplier;
  private final CrazyAirServiceSupplier crazyAirServiceSupplier;

  public FlightsServiceAggregatorImpl(
      ToughJetServiceSupplier toughJetServiceSupplier,
      CrazyAirServiceSupplier crazyAirServiceSupplier) {
    this.toughJetServiceSupplier = toughJetServiceSupplier;
    this.crazyAirServiceSupplier = crazyAirServiceSupplier;
  }

  @Override
  public List<BusyFlightsSupplierService> getFlightSuppliers() {
    return Arrays.asList(toughJetServiceSupplier, crazyAirServiceSupplier);
  }
}
