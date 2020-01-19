package com.travix.medusa.busyflights.domain.crazyair;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.Value;

@Value
@NoArgsConstructor(force = true, access = AccessLevel.PRIVATE)
@AllArgsConstructor
@Builder
public class CrazyAirRequest {

  private String origin;
  private String destination;
  private String departureDate;
  private String returnDate;
  private int passengerCount;
}
