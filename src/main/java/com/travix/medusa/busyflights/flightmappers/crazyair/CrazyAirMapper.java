package com.travix.medusa.busyflights.flightmappers.crazyair;

import static java.time.format.DateTimeFormatter.ISO_DATE_TIME;
import static java.time.format.DateTimeFormatter.ISO_LOCAL_DATE_TIME;

import com.travix.medusa.busyflights.common.SupplierName;
import com.travix.medusa.busyflights.domain.busyflights.BusyFlightsRequest;
import com.travix.medusa.busyflights.domain.busyflights.BusyFlightsResponse;
import com.travix.medusa.busyflights.domain.crazyair.CrazyAirRequest;
import com.travix.medusa.busyflights.domain.crazyair.CrazyAirResponse;
import com.travix.medusa.busyflights.flightmappers.BusyFlightsMapper;
import com.travix.medusa.busyflights.utils.BusyFlightsDateFormater;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;

@Component
public class CrazyAirMapper implements BusyFlightsMapper<CrazyAirRequest, CrazyAirResponse> {

  @Override
  public CrazyAirRequest convertToRequests(BusyFlightsRequest busyFlightsRequest) {
    return CrazyAirRequest.builder()
        .origin(busyFlightsRequest.getOrigin())
        .destination(busyFlightsRequest.getDestination())
        .departureDate(busyFlightsRequest.getDepartureDate())
        .returnDate(busyFlightsRequest.getReturnDate())
        .passengerCount(busyFlightsRequest.getNumberOfPassengers())
        .build();
  }

  @Override
  public List<BusyFlightsResponse> convertToResponses(List<CrazyAirResponse> crazyAirResponses) {
    return crazyAirResponses.stream()
        .map(crazyAirResponse -> BusyFlightsResponse.builder()
            .supplier(SupplierName.CRAZY_AIR.getFlightSupplierName())
            .airline(crazyAirResponse.getAirline())
            .departureAirportCode(crazyAirResponse.getDepartureAirportCode())
            .destinationAirportCode(crazyAirResponse.getDestinationAirportCode())
            .departureDate(
                BusyFlightsDateFormater.convertFormat(crazyAirResponse.getDepartureDate(),
                    ISO_LOCAL_DATE_TIME,
                    ISO_DATE_TIME))
            .arrivalDate(BusyFlightsDateFormater.convertFormat(crazyAirResponse.getArrivalDate(),
                ISO_LOCAL_DATE_TIME,
                ISO_DATE_TIME))
            .fare(crazyAirResponse.getPrice())
            .build())
        .collect(Collectors.toList());
  }
}
