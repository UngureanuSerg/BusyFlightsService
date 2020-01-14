package flightmappers;

import static org.junit.Assert.assertEquals;

import com.travix.medusa.busyflights.domain.busyflights.BusyFlightsRequest;
import com.travix.medusa.busyflights.domain.toughjet.ToughJetRequest;
import com.travix.medusa.busyflights.flightmappers.toughjet.ToughJetMapper;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
public class ToughJetMapperTest {

  private final Logger log = LoggerFactory.getLogger(ToughJetMapperTest.class);

  ToughJetMapper toughJetMapper = new ToughJetMapper();

  @Test
  public void convertToRequests() {
    BusyFlightsRequest check = BusyFlightsRequest
        .builder()
        .departureDate(LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE))
        .returnDate(LocalDateTime.now().plusDays(10).format(DateTimeFormatter.ISO_LOCAL_DATE))
        .numberOfPassengers(4)
        .origin("ATH")
        .destination("LON")
        .build();
    ToughJetRequest toughJetRequest = toughJetMapper.convertToRequests(check);
    assertEquals(toughJetRequest.getFrom(), check.getOrigin());
  }

  @Test
  public void convertToResponses() {
  }
}
