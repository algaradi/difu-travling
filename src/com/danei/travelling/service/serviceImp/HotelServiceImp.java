package com.danei.travelling.service.serviceImp;

import com.danei.travelling.dao.HotelDao;
import com.danei.travelling.dao.daoImp.HotelDoaImp;
import com.danei.travelling.entity.Hotel;
import com.danei.travelling.service.HoterlService;

import java.util.List;

/**
 * @Describe:
 * @Author: wangdifu
 * @Date: 2022-1-11 , 0011 14:52
 * @Version: 1.0
 */
public class HotelServiceImp implements HoterlService {

  private HotelDao dao = new HotelDoaImp();
  @Override
  public boolean addHotel(Hotel hotel) {
    return dao.addHotel(hotel);
  }

  @Override
  public boolean deleteHotel(String hotelName) {
    return dao.deleteHotel(hotelName);
  }

  @Override
  public boolean updateHotel(Hotel hotel) {
    return dao.updateHotel(hotel);
  }

  @Override
  public Hotel queryHotelById(String hotelName) {
    return dao.queryHotelById(hotelName);
  }

  @Override
  public List<Hotel> queryAllHotel() {
    return dao.queryAllHotel();
  }

  @Override
  public List<Hotel> querCityAllHotel(String cityName) {
    return dao.querCityAllHotel(cityName);
  }

  @Override
  public int getNumRooms(String hotelName) {
    return dao.getNumRooms(hotelName);
  }

  @Override
  public boolean editNumRooms(String hotelName , int numRooms) {
    return dao.editNumRooms(hotelName,numRooms);
  }
}
