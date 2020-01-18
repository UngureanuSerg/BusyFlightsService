package com.travix.medusa.busyflights.services;

import java.util.List;

/**
 * General interface that each api port should implement.
 *
 * @param <Is> incoming service request generic
 * @param <Or> outgoing service response generic
 */
public interface FlightsSupplierPort<Is, Or> {

  List<Or> searchForFlights(Is incomingServiceRequest);
}
