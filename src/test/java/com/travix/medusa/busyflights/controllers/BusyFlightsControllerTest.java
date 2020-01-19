package com.travix.medusa.busyflights.controllers;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.travix.medusa.busyflights.common.SupplierName;
import com.travix.medusa.busyflights.domain.busyflights.BusyFlightsRequest;
import com.travix.medusa.busyflights.domain.busyflights.BusyFlightsResponse;
import com.travix.medusa.busyflights.services.implementations.BusyFlightsService;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@WebMvcTest(BusyFlightsController.class)
public class BusyFlightsControllerTest {

  @Autowired
  MockMvc mockMvc;

  @MockBean
  private BusyFlightsService busyFlightsService;

  @Test
  public void testSearchForFlights() throws Exception {
    BusyFlightsRequest busyFlightsRequest = getBusyFlightsRequest();
    List<BusyFlightsResponse> busyFlightsResponses = getBusyFlightsResponseList(busyFlightsRequest);

    given(busyFlightsService.searchForFlights(busyFlightsRequest)).willReturn(busyFlightsResponses);

    Gson gson = new GsonBuilder().create();

    mockMvc.perform(post("/searchForFlights")
        .contentType(MediaType.APPLICATION_JSON)
        .content(gson.toJson(busyFlightsRequest)))
        .andDo(print())
        .andExpect(status().is2xxSuccessful())
        .andExpect(content().string(gson.toJson(busyFlightsResponses)));

  }

  private static List<BusyFlightsResponse> getBusyFlightsResponseList(
      BusyFlightsRequest busyFlightsRequest) {
    int resultSize = 4;
    List<BusyFlightsResponse> result = new ArrayList<>();
    for (int i = 0; i < resultSize; i++) {
      result.add(getBusyFlightsResponse(busyFlightsRequest));
    }
    return result;
  }

  private static BusyFlightsRequest getBusyFlightsRequest() {
    return BusyFlightsRequest
        .builder()
        .departureDate(LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE))
        .returnDate(LocalDateTime.now().plusDays(5).format(DateTimeFormatter.ISO_LOCAL_DATE))
        .numberOfPassengers(1)
        .origin("ATH")
        .destination("LON")
        .build();
  }

  public static BusyFlightsResponse getBusyFlightsResponse(BusyFlightsRequest request) {
    return BusyFlightsResponse.builder()
        .supplier(SupplierName.TOUGH_JET.getFlightSupplierName())
        .fare(new Random().nextDouble())
        .airline("RYR")
        .departureAirportCode(request.getOrigin())
        .destinationAirportCode(request.getDestination())
        .arrivalDate(LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME))
        .departureDate(LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME))
        .build();
  }

}
