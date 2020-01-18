package com.travix.medusa.busyflights.domain.toughjet;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(force = true, access = AccessLevel.PRIVATE)
@AllArgsConstructor
@Builder
public class ToughJetRequest {

  private String from;
  private String to;
  private String outboundDate;
  private String inboundDate;
  private int numberOfAdults;

}
