package com.danei.travelling.dao.daoImp;

import com.alibaba.druid.support.json.JSONUtils;
import com.danei.travelling.dao.BaseDao;
import com.danei.travelling.dao.CarDao;
import com.danei.travelling.entity.Car;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @Describe:
 * @Author: wangdifu
 * @Date: 2022-1-11 , 0011 8:50
 * @Version: 1.0
 */
public class CarDaoImp  implements CarDao {
  @Override
  public boolean addCar(Car car) {
    String sql = "insert into car (`carNum`,`price`,`cityName`,`driver`) values(?,?,?,?)";
    Object[] obj = new Object[4];
    obj[0] = car.getCarNum();
    obj[1] = car.getPrice();
    obj[2] = car.getCityName();
    obj[3] = car.getDriver();

    return BaseDao.update(sql, obj);
  }

  @Override
  public boolean deleteCar(String carNum) {
    String sql = " delete from car where carNum = ?";
    return BaseDao.update(sql, carNum);
  }

  @Override
  public boolean updateCar(Car car) {
    String sql = " update car set price =?,cityName=?, driver=? where carNum = ?";

    Object[] obj = new Object[4];
    obj[0] = car.getPrice();
    obj[1] = car.getCityName();
    obj[2] = car.getDriver();
    obj[3] = car.getCarNum();
    return BaseDao.update(sql, obj);
  }

  @Override
  public Car queryCarById(String carNum) {
    String sql = "select * from car where carNum = '" + carNum+"' ";
    Car car = new Car();
    ResultSet rs = BaseDao.select(sql);

    if (rs != null) {
      try {
        while (rs.next()) {

          car.setCarNum(rs.getString(1));
          car.setPrice(rs.getDouble(2));
          car.setCityName(rs.getString(3));
          car.setDriver(rs.getString(4));

        }
      } catch (SQLException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }

    }
      return car;
    }

    @Override
    public List<Car> queryAllCar () {
      String sql = "select * from car ";

      List<Car> list = new ArrayList<Car>();
      ResultSet rs = BaseDao.select(sql);

      if (rs != null) {
        try {
          while (rs.next()) {

            Car car = new Car();
            car.setCarNum(rs.getString(1));
            car.setPrice(rs.getDouble(2));
            car.setCityName(rs.getString(3));
            car.setDriver(rs.getString(4));
list.add(car);
          }
        } catch (SQLException e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
        }


      }
      return list;
    }

  @Override
  public List<Car> queryCityAllCar(String cityName) {
    String sql = "select * from car where cityName ='"+cityName+"'";

    List<Car> list = new ArrayList<Car>();
    ResultSet rs = BaseDao.select(sql);

    if (rs != null) {
      try {
        while (rs.next()) {

          Car car = new Car();
          car.setCarNum(rs.getString(1));
          car.setPrice(rs.getDouble(2));
          car.setCityName(rs.getString(3));
          car.setDriver(rs.getString(4));
          list.add(car);
        }
      } catch (SQLException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }


    }
    return list;
  }

}