package com.travix.medusa.busyflights.flightmappers.toughjet;

import static java.time.format.DateTimeFormatter.ISO_DATE_TIME;
import static java.time.format.DateTimeFormatter.ISO_INSTANT;

import com.travix.medusa.busyflights.common.SupplierName;
import com.travix.medusa.busyflights.domain.busyflights.BusyFlightsRequest;
import com.travix.medusa.busyflights.domain.busyflights.BusyFlightsResponse;
import com.travix.medusa.busyflights.domain.toughjet.ToughJetRequest;
import com.travix.medusa.busyflights.domain.toughjet.ToughJetResponse;
import com.travix.medusa.busyflights.flightmappers.BusyFlightsMapper;
import com.travix.medusa.busyflights.utils.BusyFlightsCommonUtils;
import com.travix.medusa.busyflights.utils.BusyFlightsDateFormater;
import java.time.ZoneId;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;

@Component
public class ToughJetMapper implements BusyFlightsMapper<ToughJetRequest, ToughJetResponse> {

  @Override
  public ToughJetRequest convertToRequests(BusyFlightsRequest busyFlightsRequest) {
    return ToughJetRequest.builder()
        .from(busyFlightsRequest.getOrigin())
        .to(busyFlightsRequest.getDestination())
        .numberOfAdults(busyFlightsRequest.getNumberOfPassengers())
        .inboundDate(busyFlightsRequest.getDepartureDate())
        .outboundDate(busyFlightsRequest.getReturnDate())
        .build();
  }

  @Override
  public List<BusyFlightsResponse> convertToResponses(List<ToughJetResponse> responses) {
    return responses.stream()
        .map(r -> BusyFlightsResponse.builder()
            .departureAirportCode(r.getDepartureAirportName())
            .destinationAirportCode(r.getArrivalAirportName())
            .airline(r.getCarrier())
            .fare(BusyFlightsCommonUtils.getFare(r))
            .supplier(SupplierName.TOUGH_JET.getFlightSupplierName())
            .departureDate(
                BusyFlightsDateFormater.convertFormat(r.getOutboundDateTime(), ISO_INSTANT.withZone(
                    ZoneId.systemDefault()), ISO_DATE_TIME))
            .arrivalDate(BusyFlightsDateFormater
                .convertFormat(r.getInboundDateTime(), ISO_INSTANT.withZone(ZoneId.systemDefault()),
                    ISO_DATE_TIME))
            .build())
        .collect(Collectors.toList());

  }
}
