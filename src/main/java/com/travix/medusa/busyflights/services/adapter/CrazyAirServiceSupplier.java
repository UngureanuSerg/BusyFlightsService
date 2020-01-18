package com.travix.medusa.busyflights.services.adapter;

import com.travix.medusa.busyflights.domain.crazyair.CrazyAirRequest;
import com.travix.medusa.busyflights.domain.crazyair.CrazyAirResponse;
import com.travix.medusa.busyflights.flightmappers.BusyFlightsMapper;
import com.travix.medusa.busyflights.flightmappers.crazyair.CrazyAirMapper;
import com.travix.medusa.busyflights.services.BusyFlightsSupplierCommonService;
import com.travix.medusa.busyflights.services.FlightsSupplierPort;
import com.travix.medusa.busyflights.services.ports.CrazyAirServicePort;
import org.springframework.stereotype.Service;

@Service
public class CrazyAirServiceSupplier implements
    BusyFlightsSupplierCommonService<CrazyAirRequest, CrazyAirResponse> {

  private final CrazyAirServicePort crazyAirServicePort;
  private final CrazyAirMapper crazyAirMapper;

  public CrazyAirServiceSupplier(
      CrazyAirServicePort crazyAirServicePort,
      CrazyAirMapper crazyAirMapper) {
    this.crazyAirServicePort = crazyAirServicePort;
    this.crazyAirMapper = crazyAirMapper;
  }

  @Override
  public BusyFlightsMapper<CrazyAirRequest, CrazyAirResponse> getBusyFlightsSupplierMapper() {
    return crazyAirMapper;
  }

  @Override
  public FlightsSupplierPort<CrazyAirRequest, CrazyAirResponse> getBusyFlightsSupplierPort() {
    return crazyAirServicePort;
  }
}
