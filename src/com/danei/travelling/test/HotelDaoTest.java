package com.danei.travelling.test;

import com.danei.travelling.dao.HotelDao;
import com.danei.travelling.dao.daoImp.HotelDoaImp;
import com.danei.travelling.entity.Hotel;
import javafx.geometry.HPos;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @Describe:
 * @Author: wangdifu
 * @Date: 2022-1-11 , 0011 11:26
 * @Version: 1.0
 */
class HotelDaoTest {
private HotelDao dao = new HotelDoaImp();
  @Test
  void addHotel() {
    Hotel hotel = new Hotel("HotelA11",250.0,20,"北京","Beijing 详细地址");
    System.out.println(dao.addHotel(hotel));

  }

  @Test
  void deleteHotel() {

    System.out.println(dao.deleteHotel("HotelA11"));
  }

  @Test
  void updateHotel() {
    Hotel hotel = new Hotel("HotelA11",250.0,20,"天津","Beijing 详细地址");
    System.out.println(dao.updateHotel(hotel));
  }

  @Test
  void queryHotelById() {
    System.out.println(dao.queryHotelById("HZ-HotelA1"));
  }

  @Test
  void queryAllHotel() {
    List<Hotel> hotel = dao.queryAllHotel();
    System.out.println(hotel.toString());
  }

  @Test
  void querCityAllHotel() {
    System.out.println(dao.querCityAllHotel("北京").toString());
  }

  @Test
  void getNumRooms() {
    int numRooms = dao.getNumRooms("SZ-HotelA2");
    System.out.println(numRooms);
  }

  @Test
  void editNumRooms() {
    System.out.println(dao.editNumRooms("SZ-HotelA2", 4));
  }
}