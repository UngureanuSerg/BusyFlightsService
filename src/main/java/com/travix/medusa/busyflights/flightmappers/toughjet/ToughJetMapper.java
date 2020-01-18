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
  public List<BusyFlightsResponse> convertToResponses(List<ToughJetResponse> toughJetResponses) {
    return toughJetResponses.stream()
        .map(toughJetResponse -> BusyFlightsResponse.builder()
            .departureAirportCode(toughJetResponse.getDepartureAirportName())
            .destinationAirportCode(toughJetResponse.getArrivalAirportName())
            .airline(toughJetResponse.getCarrier())
            .fare(BusyFlightsCommonUtils.getFare(toughJetResponse))
            .supplier(SupplierName.TOUGH_JET.getFlightSupplierName())
            .departureDate(
                BusyFlightsDateFormater
                    .convertFormat(toughJetResponse.getOutboundDateTime(), ISO_INSTANT.withZone(
                        ZoneId.systemDefault()), ISO_DATE_TIME))
            .arrivalDate(BusyFlightsDateFormater
                .convertFormat(toughJetResponse.getInboundDateTime(),
                    ISO_INSTANT.withZone(ZoneId.systemDefault()),
                    ISO_DATE_TIME))
            .build())
        .collect(Collectors.toList());

  }
}
