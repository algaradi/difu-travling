package com.danei.travelling.dao;

import com.danei.travelling.entity.Flight;
import com.danei.travelling.entity.Hotel;

import java.util.List;

/**
 * @Describe:
 * @Author: wangdifu
 * @Date: 2022-1-11 , 0011 0:14
 * @Version: 1.0
 */
public interface HotelDao {

  boolean addHotel( Hotel hotel);
  boolean deleteHotel(String hotelName);
  boolean updateHotel(Hotel hotel);

  Hotel queryHotelById(String hotelName);
  List<Hotel> queryAllHotel();
  List<Hotel> querCityAllHotel(String cityName);

  int getNumRooms(String hotelName);
  boolean editNumRooms(String hotelName,int numRooms);

}
