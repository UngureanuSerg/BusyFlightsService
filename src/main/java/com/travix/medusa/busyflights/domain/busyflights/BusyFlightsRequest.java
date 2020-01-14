package com.travix.medusa.busyflights.domain.busyflights;

import javax.validation.constraints.Size;
import lombok.Builder;
import lombok.Getter;
import org.hibernate.validator.constraints.Range;

/**
 * Changed all domain level classes to use
 * project lombok for maintainability reasons as it becomes more readable.
 * Provide only getters so the object to become less mutable.
 */
@Getter
@Builder
public class BusyFlightsRequest {

  @Size(min = 3, max = 3)
  private String origin;
  @Size(min = 3, max = 3)
  private String destination;

  private String departureDate;
  private String returnDate;

  @Range(min = 1, max = 4)
  private int numberOfPassengers;
}
