package com.travix.medusa.busyflights.domain.busyflights;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(force = true, access = AccessLevel.PRIVATE)
@AllArgsConstructor
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
