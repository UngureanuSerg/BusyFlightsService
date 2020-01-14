package com.travix.medusa.busyflights.domain.busyflights;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class BusyFlightsResponse {

  private String airline;
  private String supplier;
  private Double fare;
  private String departureAirportCode;
  private String destinationAirportCode;
  private String departureDate;
  private String arrivalDate;
}
