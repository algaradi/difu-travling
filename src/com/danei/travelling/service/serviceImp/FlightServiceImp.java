package com.danei.travelling.service.serviceImp;

import com.danei.travelling.dao.FlightDao;
import com.danei.travelling.dao.daoImp.FlightDaoImp;
import com.danei.travelling.entity.Flight;
import com.danei.travelling.service.FlightService;

import java.util.List;

/**
 * @Describe:
 * @Author: wangdifu
 * @Date: 2022-1-11 , 0011 14:50
 * @Version: 1.0
 */
public class FlightServiceImp implements FlightService {
  private FlightDao dao = new FlightDaoImp();
  @Override
  public boolean addFlight(Flight flight) {
    return dao.addFlight(flight) ;
  }

  @Override
  public boolean deleteFlight(String flightNum) {
    return dao.deleteFlight(flightNum);
  }

  @Override
  public boolean updateFlight(Flight flight) {
    return dao.updateFlight(flight);
  }

  @Override
  public Flight queryFlightById(String flightNum) {
    return dao.queryFlightById(flightNum);
  }

  @Override
  public List<Flight> queryAllFlight() {
    return dao.queryAllFlight();
  }

  @Override
  public List<Flight> querFromArivCityWithTimeAllflight(String fromCitt, String arivCity, String fromDate, String arivDate) {
    return dao.querFromArivCityWithTimeAllflight(fromCitt,arivCity,fromDate,arivDate);
  }

  @Override
  public int getNumSeats(String flightNum) {
    return dao.getNumSeats(flightNum);
  }

  @Override
  public boolean editNumSeat(String flightNum, int numSeats) {
    return dao.editNumSeat(flightNum,numSeats);
  }
}
