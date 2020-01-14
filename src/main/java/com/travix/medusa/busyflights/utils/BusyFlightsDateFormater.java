package com.travix.medusa.busyflights.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class BusyFlightsDateFormater {

  public static String convertFormat(String date, DateTimeFormatter from, DateTimeFormatter to) {
    return LocalDateTime.parse(date, from).format(to);
  }


}
