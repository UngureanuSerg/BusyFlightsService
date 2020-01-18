package com.travix.medusa.busyflights.domain.crazyair;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(force = true, access = AccessLevel.PRIVATE)
@AllArgsConstructor
@Builder
public class CrazyAirResponse {

  private String airline;
  private double price;
  private String cabinclass;
  private String departureAirportCode;
  private String destinationAirportCode;
  private String departureDate;
  private String arrivalDate;
}
