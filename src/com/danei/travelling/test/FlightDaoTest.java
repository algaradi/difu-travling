package com.danei.travelling.test;

import com.danei.travelling.dao.FlightDao;
import com.danei.travelling.dao.daoImp.FlightDaoImp;
import com.danei.travelling.entity.Flight;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @Describe:
 * @Author: wangdifu
 * @Date: 2022-1-11 , 0011 11:50
 * @Version: 1.0
 */
class FlightDaoTest {


private FlightDao  dao = new FlightDaoImp();
  @Test
  void addFlight() {
    Flight flight = new Flight("XA-SY10A3", 200.0,30,"西安","2022-01-15 03:04","沈阳","2022-01-15 04:24");
    System.out.println(dao.addFlight(flight));

  }

  @Test
  void deleteFlight() {
  }

  @Test
  void updateFlight() {
    Flight flight = new Flight("XA-SY10A3", 200.0,30,"西安","2022-01-15 03:04","沈阳","2022-01-15 04:24");
    System.out.println(dao.updateFlight(flight));
  }

  @Test
  void queryFlightById() {
    System.out.println(dao.queryFlightById("XA-SY10A3"));
  }

  @Test
  void queryAllFlight() {
    System.out.println(dao.queryAllFlight().toString());
  }

  @Test
  void querFromArivCityWithTimeAllflight() {
    List<Flight> flights = dao.querFromArivCityWithTimeAllflight("北京", "上海", "2022-01-16", "2022-01-16");
    System.out.println(flights.toString());
  }

  @Test
  void getNumSeats() {
    int numSeats = dao.getNumSeats("BJHZ10A2");
    System.out.println(numSeats);
  }

  @Test
  void editNumSeat() {
    dao.editNumSeat("SH-TJ10A1",2);
  }
}