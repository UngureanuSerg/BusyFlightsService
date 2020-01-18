package com.travix.medusa.busyflights.services;

import static org.mockito.Matchers.any;

import com.travix.medusa.busyflights.common.SupplierName;
import com.travix.medusa.busyflights.domain.busyflights.BusyFlightsRequest;
import com.travix.medusa.busyflights.domain.busyflights.BusyFlightsResponse;
import com.travix.medusa.busyflights.domain.crazyair.CrazyAirRequest;
import com.travix.medusa.busyflights.domain.crazyair.CrazyAirResponse;
import com.travix.medusa.busyflights.domain.toughjet.ToughJetRequest;
import com.travix.medusa.busyflights.domain.toughjet.ToughJetResponse;
import com.travix.medusa.busyflights.flightmappers.crazyair.CrazyAirMapper;
import com.travix.medusa.busyflights.flightmappers.toughjet.ToughJetMapper;
import com.travix.medusa.busyflights.flightserviceaggregator.FlightsServiceAggregator;
import com.travix.medusa.busyflights.services.adapter.CrazyAirServiceSupplier;
import com.travix.medusa.busyflights.services.adapter.ToughJetServiceSupplier;
import com.travix.medusa.busyflights.services.implementations.BusyFlightsService;
import com.travix.medusa.busyflights.services.ports.CrazyAirServicePort;
import com.travix.medusa.busyflights.services.ports.ToughJetServicePort;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(
    classes = {BusyFlightsService.class,
        CrazyAirServiceSupplier.class,
        CrazyAirMapper.class,
        ToughJetMapper.class,
        ToughJetServiceSupplier.class
    })

@RunWith(SpringJUnit4ClassRunner.class)
public class BusyFlightsServiceTest {

  @Autowired
  BusyFlightsService busyFlightsService;
  @Autowired
  CrazyAirServiceSupplier crazyAirServiceSupplier;
  @Autowired
  ToughJetServiceSupplier toughJetServiceSupplier;
  @Autowired
  CrazyAirMapper crazyAirMapper;
  @Autowired
  ToughJetMapper toughJetMapper;

  @MockBean
  private FlightsServiceAggregator mockFlightsServiceAggregator;
  @MockBean
  private CrazyAirServicePort mockCrazyAirServicePort;
  @MockBean
  private ToughJetServicePort mockToughJetServicePort;

  @Test
  public void testCrazyAirSupplier() {
    Mockito.when(mockFlightsServiceAggregator.getFlightSuppliers()).thenReturn(
        Collections.singletonList(crazyAirServiceSupplier));

    BusyFlightsRequest busyFlightsRequest = getRandomBusyFlightsRequest();
    final List<CrazyAirResponse> crazyAirResponses = mockCrazyAirFlightSupplier(busyFlightsRequest);

    final List<BusyFlightsResponse> busyFlightsResponse = busyFlightsService
        .searchForFlights(busyFlightsRequest);

    Assert.assertEquals(crazyAirResponses.size(), busyFlightsResponse.size());
    //check prices are sorted
    final List<Double> fares = busyFlightsResponse.stream().map(BusyFlightsResponse::getFare)
        .collect(Collectors.toList());
    Assert.assertEquals(fares.stream().sorted().collect(Collectors.toList()), fares);

  }

  @Test
  public void testToughJetSupplier() {

    Mockito.when(mockFlightsServiceAggregator.getFlightSuppliers()).thenReturn(
        Collections.singletonList(toughJetServiceSupplier));

    BusyFlightsRequest busyFlightsRequest = getRandomBusyFlightsRequest();
    final List<ToughJetResponse> toughJetResponses = mockToughJetFlightSupplier(busyFlightsRequest);

    final List<BusyFlightsResponse> busyFlightsResponse = busyFlightsService
        .searchForFlights(busyFlightsRequest);

    Assert.assertEquals(toughJetResponses.size(), busyFlightsResponse.size());
    //check prices are sorted
    final List<Double> fares = busyFlightsResponse.stream().map(BusyFlightsResponse::getFare)
        .collect(Collectors.toList());
    Assert.assertEquals(fares.stream().sorted().collect(Collectors.toList()), fares);

  }

  private List<CrazyAirResponse> mockCrazyAirFlightSupplier(BusyFlightsRequest busyFlightsRequest) {
    final List<CrazyAirResponse> crazyAirResponses = getRandomCrazyAirResponseList(
        crazyAirMapper.convertToRequests(busyFlightsRequest));

    Mockito.when(mockCrazyAirServicePort.searchForFlights(any(CrazyAirRequest.class)))
        .thenReturn(crazyAirResponses);
    return crazyAirResponses;

  }

  private List<ToughJetResponse> mockToughJetFlightSupplier(BusyFlightsRequest busyFlightsRequest) {
    final List<ToughJetResponse> toughJetResponses = getRandomToughJetResponseList(
        toughJetMapper.convertToRequests(busyFlightsRequest));

    Mockito.when(mockToughJetServicePort.searchForFlights(any(ToughJetRequest.class)))
        .thenReturn(toughJetResponses);
    return toughJetResponses;

  }


  static BusyFlightsRequest getRandomBusyFlightsRequest() {
    return BusyFlightsRequest
        .builder()
        .departureDate(LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE))
        .returnDate(LocalDateTime.now().plusDays(19).format(DateTimeFormatter.ISO_LOCAL_DATE))
        .numberOfPassengers(3)
        .origin("ATH")
        .destination("LON")
        .build();
  }

  private static CrazyAirResponse getTestCrazyAirResponse(CrazyAirRequest request) {
    return CrazyAirResponse.builder()
        .cabinclass(getCabin())
        .departureDate(LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME))
        .arrivalDate(LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME))
        .destinationAirportCode(request.getDestination())
        .departureAirportCode(request.getOrigin())
        .airline(SupplierName.CRAZY_AIR.getFlightSupplierName())
        .price(new Random().nextDouble())
        .build();
  }

  private static String getCabin() {
    Supplier<String> cabinClass = () -> new String("E");
    return cabinClass.get();
  }

  private static List<CrazyAirResponse> getRandomCrazyAirResponseList(CrazyAirRequest request) {
    int resultSize = 6;
    List<CrazyAirResponse> result = new ArrayList<>();
    for (int i = 0; i < resultSize; i++) {
      result.add(getTestCrazyAirResponse(request));
    }
    return result;
  }

  private static List<ToughJetResponse> getRandomToughJetResponseList(ToughJetRequest request) {
    int resultSize = 5;
    List<ToughJetResponse> result = new ArrayList<>();
    for (int i = 0; i < resultSize; i++) {
      result.add(getTestToughJetResponse(request));
    }
    return result;
  }

  private static ToughJetResponse getTestToughJetResponse(ToughJetRequest request) {
    return ToughJetResponse.builder()
        .outboundDateTime(Instant.now().toString())

        .inboundDateTime(Instant.now().toString())
        .arrivalAirportName(request.getTo())
        .departureAirportName(request.getFrom())
        .carrier("RYR")
        .basePrice(new Random().nextDouble())
        .discount(17)
        .tax(3.7)
        .build();
  }

}