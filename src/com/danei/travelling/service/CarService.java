package com.danei.travelling.service;

import com.danei.travelling.entity.Car;

import java.util.List;

/**
 * @Describe:
 * @Author: wangdifu
 * @Date: 2022-1-11 , 0011 0:16
 * @Version: 1.0
 */
public interface CarService {
  boolean addCar(Car car);
  boolean deleteCar(String carNum);
  boolean updateCar(Car car);

  Car queryCarById(String carNum);
  List<Car> queryAllCar();
  List<Car> queryCityAllCar(String cityName);
}
