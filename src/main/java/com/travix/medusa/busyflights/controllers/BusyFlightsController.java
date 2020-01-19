package com.travix.medusa.busyflights.controllers;

import com.travix.medusa.busyflights.domain.busyflights.BusyFlightsRequest;
import com.travix.medusa.busyflights.domain.busyflights.BusyFlightsResponse;
import com.travix.medusa.busyflights.services.implementations.BusyFlightsService;
import java.util.List;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class BusyFlightsController {

  private final BusyFlightsService busyFlightsService;

  public BusyFlightsController(
      BusyFlightsService busyFlightsService) {
    this.busyFlightsService = busyFlightsService;
  }

  @RequestMapping(value = "/searchForFlights",
      method = RequestMethod.POST, produces = {"application/json"})
  public @ResponseBody
  List<BusyFlightsResponse> searchFlights(@RequestBody BusyFlightsRequest request) {
    return busyFlightsService.searchForFlights(request);
  }
}
