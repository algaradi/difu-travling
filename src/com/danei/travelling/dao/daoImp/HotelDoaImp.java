package com.danei.travelling.dao.daoImp;

import com.danei.travelling.dao.BaseDao;
import com.danei.travelling.dao.HotelDao;
import com.danei.travelling.entity.Hotel;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @Describe:
 * @Author: wangdifu
 * @Date: 2022-1-11 , 0011 11:12
 * @Version: 1.0
 */
public class HotelDoaImp implements HotelDao {
  @Override
  public boolean addHotel(Hotel hotel) {
    String sql ="insert into hotel values(?,?,?,?,?)";
     Object[] obj = new Object[5];
    obj[0] = hotel.getHotelName();
    obj[1] = hotel.getPrice();
    obj[2] = hotel.getNumRooms();
    obj[3] = hotel.getCityName();
    obj[4] = hotel.getAddress();

    return BaseDao.update(sql,obj);
  }

  @Override
  public boolean deleteHotel(String hotelName) {
    String sql = "delete from hotel where hotelName = ?";
    return BaseDao.update(sql,hotelName);
  }

  @Override
  public boolean updateHotel(Hotel hotel) {
    String sql = "update hotel set price=?, numRooms =? , cityName =? ,address=? where hotelName=?";
    Object[] obj = new Object[5];

    obj[0] = hotel.getPrice();
    obj[1] = hotel.getNumRooms();
    obj[2] = hotel.getCityName();
    obj[3] = hotel.getAddress();
    obj[4] = hotel.getHotelName();
    return BaseDao.update(sql,obj);
  }

  @Override
  public Hotel queryHotelById(String hotelName) {
    String sql = "select * from hotel where hotelName = '"+hotelName+"'";
    Hotel hotel = new Hotel();
    ResultSet rs = BaseDao.select(sql);

    if (rs != null) {
      try {
        while (rs.next()) {

          hotel.setHotelName(rs.getString(1));
          hotel.setPrice(rs.getDouble(2));
          hotel.setNumRooms(rs.getInt(3));
          hotel.setCityName(rs.getString(4));
          hotel.setAddress(rs.getString(5));

        }
      } catch (SQLException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }

    }
    return hotel;
  }

  @Override
  public List<Hotel> queryAllHotel() {
    String sql = "select * from hotel";
    List<Hotel> list = new ArrayList<Hotel>();
    ResultSet rs = BaseDao.select(sql);

    if (rs != null) {
      try {
        while (rs.next()) {

          Hotel hotel = new Hotel();
          hotel.setHotelName(rs.getString(1));
          hotel.setPrice(rs.getDouble(2));
          hotel.setNumRooms(rs.getInt(3));
          hotel.setCityName(rs.getString(4));
          hotel.setAddress(rs.getString(5));
     list.add(hotel);
        }
      } catch (SQLException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }

    }

    return list;
  }

  @Override
  public List<Hotel> querCityAllHotel(String cityName) {
    String sql = "select * from hotel where cityName = '"+cityName+"'";
    List<Hotel> list = new ArrayList<Hotel>();
    ResultSet rs = BaseDao.select(sql);

    if (rs != null) {
      try {
        while (rs.next()) {

          Hotel hotel = new Hotel();
          hotel.setHotelName(rs.getString(1));
          hotel.setPrice(rs.getDouble(2));
          hotel.setNumRooms(rs.getInt(3));
          hotel.setCityName(rs.getString(4));
          hotel.setAddress(rs.getString(5));
          list.add(hotel);
        }
      } catch (SQLException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }

    }

    return list;
  }

  @Override
  public int getNumRooms(String hotelName) {
    String sql = "select numRooms from hotel where hotelName= '" + hotelName+"'";
    ResultSet rs = BaseDao.select(sql);

    int numRooms = 0;
    if (rs != null) {
      try {
        while (rs.next()) {
          numRooms = rs.getInt(1);
        }
      } catch (SQLException e) {
        e.printStackTrace();
      }

    }
    return numRooms;
  }

  @Override
  public boolean editNumRooms(String hotelName ,int numRooms) {
    String sql = "update hotel set numRooms = ? where hotelName=?";
    return BaseDao.update(sql,hotelName,numRooms);
  }
}
