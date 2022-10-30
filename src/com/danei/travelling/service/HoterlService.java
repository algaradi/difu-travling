package com.danei.travelling.service;

import com.danei.travelling.entity.Hotel;

import java.util.List;

/**
 * @Describe:
 * @Author: wangdifu
 * @Date: 2022-1-11 , 0011 0:18
 * @Version: 1.0
 */
public interface HoterlService {

  boolean addHotel( Hotel hotel);
  boolean deleteHotel(String hotelName);
  boolean updateHotel(Hotel hotel);

  Hotel queryHotelById(String hotelName);
  List<Hotel> queryAllHotel();
  List<Hotel> querCityAllHotel(String cityName);

  int getNumRooms(String hotelName);
  boolean editNumRooms(String hotelName, int numRooms);
}
