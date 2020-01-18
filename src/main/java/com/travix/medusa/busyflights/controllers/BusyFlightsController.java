package com.travix.medusa.busyflights.controllers;

import com.travix.medusa.busyflights.services.implementations.BusyFlightsService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class BusyFlightsController {

  private final BusyFlightsService busyFlightsService;

  public BusyFlightsController(
      BusyFlightsService busyFlightsService) {
    this.busyFlightsService = busyFlightsService;
  }

}
