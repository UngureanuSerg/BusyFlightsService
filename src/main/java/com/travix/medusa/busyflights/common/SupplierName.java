package com.travix.medusa.busyflights.common;

public enum SupplierName {
  CRAZY_AIR("CrazyAir"),
  TOUGH_JET("ToughJet");

  private final String flightSupplierName;

  SupplierName(String flightSupplierName) {
    this.flightSupplierName = flightSupplierName;
  }

  public String getFlightSupplierName() {
    return flightSupplierName;
  }
}
