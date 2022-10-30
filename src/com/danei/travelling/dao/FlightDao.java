package com.danei.travelling.dao;

import com.danei.travelling.entity.Customer;
import com.danei.travelling.entity.Flight;

import java.util.List;

/**
 * @Describe:
 * @Author: wangdifu
 * @Date: 2022-1-11 , 0011 0:14
 * @Version: 1.0
 */
public interface FlightDao {

  boolean addFlight( Flight flight);
  boolean deleteFlight(String flightNum);
  boolean updateFlight(Flight flight);

  Flight queryFlightById(String flightNum);
  List<Flight> queryAllFlight();

  List<Flight> querFromArivCityWithTimeAllflight(String fromCitt,String arivCity,String fromDate,String arivDate);
  int getNumSeats(String flightNum);
  boolean editNumSeat(String flightNum , int numSeats);

}
