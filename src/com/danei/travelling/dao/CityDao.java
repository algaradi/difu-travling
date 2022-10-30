package com.danei.travelling.dao;

import com.danei.travelling.entity.Car;
import com.danei.travelling.entity.City;

import java.util.List;

/**
 * @Describe:
 * @Author: wangdifu
 * @Date: 2022-1-11 , 0011 0:16
 * @Version: 1.0
 */
public interface CityDao {


  boolean addCity(City city);
  boolean deleteCity(String cityName);
  boolean updateCity(City city);

  List<City> queryAllCity();

}
