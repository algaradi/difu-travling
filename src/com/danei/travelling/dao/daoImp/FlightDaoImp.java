package com.danei.travelling.dao.daoImp;

import com.danei.travelling.dao.BaseDao;
import com.danei.travelling.dao.FlightDao;
import com.danei.travelling.entity.Flight;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @Describe:
 * @Author: wangdifu
 * @Date: 2022-1-11 , 0011 11:37
 * @Version: 1.0
 */
public class FlightDaoImp implements FlightDao {
  @Override
  public boolean addFlight(Flight flight) {
    String sql = "insert into flight values(?, ?,?,?,?,?,?)";
    Object[] obj = new Object[7];
    obj[0] = flight.getFlightNum();
    obj[1] = flight.getPrice();
    obj[2]  = flight.getNumSeats();
    obj[3] = flight.getFromCity();
    obj[4] = flight.getFromDate();
    obj[5] = flight.getArivCity();
    obj[6] = flight.getArivDate();


    return BaseDao.update(sql,obj);
  }

  @Override
  public boolean deleteFlight(String flightNum) {
    String sql = "delete from flight where flightNum = ?";

    return BaseDao.update(sql,flightNum);
  }

  @Override
  public boolean updateFlight(Flight flight) {
    String sql = "update flight set price =? ,numSeats =? ,fromCity=? , fromDate=?, arivCity=?,arivDate=? where flightNum = ?";

    Object[] obj = new Object[7];

    obj[0] = flight.getPrice();
    obj[1]  = flight.getNumSeats();
    obj[2] = flight.getFromCity();
    obj[3] = flight.getFromDate();
    obj[4] = flight.getArivCity();
    obj[5] = flight.getArivDate();
    obj[6] = flight.getFlightNum();
    return BaseDao.update(sql,obj);
  }

  @Override
  public Flight queryFlightById(String flightNum) {
    String sql = "select * from flight where flightNum = '"+flightNum+"'";
    Flight flight = new Flight();
    ResultSet rs = BaseDao.select(sql);

    if (rs != null) {
      try {
        while (rs.next()) {

          flight.setFlightNum(rs.getString(1));
          flight.setPrice(rs.getDouble(2));
          flight.setNumSeats(rs.getInt(3));
          flight.setFromCity(rs.getString(4));
          flight.setFromDate(rs.getString(5));
          flight.setArivCity(rs.getString(6));
          flight.setArivDate(rs.getString(7));

        }
      } catch (SQLException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }

    }

    return flight;
  }

  @Override
  public List<Flight> queryAllFlight() {

    String sql = "select * from flight";
    List<Flight> list = new ArrayList<Flight>();
    ResultSet rs = BaseDao.select(sql);

    if (rs != null) {
      try {
        while (rs.next()) {
          Flight flight=  new Flight();
          flight.setFlightNum(rs.getString(1));
          flight.setPrice(rs.getDouble(2));
          flight.setNumSeats(rs.getInt(3));
          flight.setFromCity(rs.getString(4));
          flight.setFromDate(rs.getString(5));
          flight.setArivCity(rs.getString(6));
          flight.setArivDate(rs.getString(7));
list.add(flight);
        }
      } catch (SQLException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }

    }
    return list;
  }

  @Override
  public List<Flight> querFromArivCityWithTimeAllflight(String fromCitt, String arivCity, String fromDate, String arivDate) {

    String sql = "select * from flight where fromCity='"+fromCitt+"' and arivCity='"+arivCity+"' and fromDate like'%"+fromDate+"%' and arivDate like '%"+arivDate+"%'";
    List<Flight> list = new ArrayList<Flight>();
    ResultSet rs = BaseDao.select(sql);

    if (rs != null) {
      try {
        while (rs.next()) {
          Flight flight=  new Flight();
          flight.setFlightNum(rs.getString(1));
          flight.setPrice(rs.getDouble(2));
          flight.setNumSeats(rs.getInt(3));
          flight.setFromCity(rs.getString(4));
          flight.setFromDate(rs.getString(5));
          flight.setArivCity(rs.getString(6));
          flight.setArivDate(rs.getString(7));
          list.add(flight);
        }
      } catch (SQLException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }

    }
    return list;
  }

  @Override
  public int getNumSeats(String flightNum) {
    String sql = "select numSeats from flight where flightNum= '" + flightNum+"'";
    ResultSet rs = BaseDao.select(sql);

    int numSeats = 0;
    if (rs != null) {
      try {
        while (rs.next()) {
          numSeats = rs.getInt(1);
        }
      } catch (SQLException e) {
        e.printStackTrace();
      }

    }
    return numSeats;
  }

  @Override
  public boolean editNumSeat(String flightNum , int numSeats) {
    String sql = "update flight set numSeats = ? where flightNum=?";
    return BaseDao.update(sql,flightNum,numSeats);
  }
}
