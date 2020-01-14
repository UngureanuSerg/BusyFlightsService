package com.travix.medusa.busyflights.utils;

import com.travix.medusa.busyflights.domain.busyflights.BusyFlightsResponse;
import com.travix.medusa.busyflights.domain.toughjet.ToughJetResponse;

public class BusyFlightsCommonUtils {

  public static double getFare(ToughJetResponse r) {
    return r.getBasePrice() * (1 - r.getDiscount() / 100) + r.getTax();
  }

  public static BusyFlightsResponse roundFare(BusyFlightsResponse response) {
    return BusyFlightsResponse.builder()
        .fare(Math.round(response.getFare() * 100.0) / 100.0).build();
  }

}
