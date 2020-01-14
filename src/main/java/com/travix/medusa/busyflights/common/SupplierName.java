package com.travix.medusa.busyflights.common;

public enum SupplierName {
  CRAZY_AIR("CrazyAir"),
  TOUGH_JET("ToughJet");

  private final String supplierName;

  SupplierName(String supplierName) {
    this.supplierName = supplierName;
  }

  public String getSupplierName() {
    return supplierName;
  }
}
