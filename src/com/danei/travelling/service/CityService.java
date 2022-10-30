package com.danei.travelling.service;

import com.danei.travelling.entity.City;

import java.util.List;

/**
 * @Describe:
 * @Author: wangdifu
 * @Date: 2022-1-11 , 0011 0:20
 * @Version: 1.0
 */
public interface CityService {

  boolean addCity(City city);
  boolean deleteCity(String cityName);
  boolean updateCity(City city);

  List<City> queryAllCity();
}
