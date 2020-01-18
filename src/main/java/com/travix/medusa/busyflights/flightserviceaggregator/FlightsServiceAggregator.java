package com.travix.medusa.busyflights.flightserviceaggregator;

import com.travix.medusa.busyflights.services.BusyFlightsSupplierService;
import java.util.List;

public interface FlightsServiceAggregator {

  List<BusyFlightsSupplierService> getFlightSuppliers();
}
