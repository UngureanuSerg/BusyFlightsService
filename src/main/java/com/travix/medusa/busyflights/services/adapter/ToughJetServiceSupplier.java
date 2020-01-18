package com.travix.medusa.busyflights.services.adapter;

import com.travix.medusa.busyflights.domain.toughjet.ToughJetRequest;
import com.travix.medusa.busyflights.domain.toughjet.ToughJetResponse;
import com.travix.medusa.busyflights.flightmappers.BusyFlightsMapper;
import com.travix.medusa.busyflights.flightmappers.toughjet.ToughJetMapper;
import com.travix.medusa.busyflights.services.BusyFlightsSupplierCommonService;
import com.travix.medusa.busyflights.services.FlightsSupplierPort;
import com.travix.medusa.busyflights.services.ports.ToughJetServicePort;
import org.springframework.stereotype.Service;

@Service
public class ToughJetServiceSupplier implements
    BusyFlightsSupplierCommonService<ToughJetRequest, ToughJetResponse> {

  private final ToughJetServicePort toughJetServicePort;
  private final ToughJetMapper toughJetMapper;

  public ToughJetServiceSupplier(
      ToughJetServicePort toughJetServicePort,
      ToughJetMapper toughJetMapper) {
    this.toughJetServicePort = toughJetServicePort;
    this.toughJetMapper = toughJetMapper;
  }

  @Override
  public BusyFlightsMapper<ToughJetRequest, ToughJetResponse> getBusyFlightsSupplierMapper() {
    return toughJetMapper;
  }

  @Override
  public FlightsSupplierPort<ToughJetRequest, ToughJetResponse> getBusyFlightsSupplierPort() {
    return toughJetServicePort;
  }
}
