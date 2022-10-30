package com.danei.travelling.service.serviceImp;

import com.danei.travelling.dao.CarDao;
import com.danei.travelling.dao.daoImp.CarDaoImp;
import com.danei.travelling.entity.Car;
import com.danei.travelling.service.CarService;

import java.util.List;

/**
 * @Describe:
 * @Author: wangdifu
 * @Date: 2022-1-11 , 0011 14:43
 * @Version: 1.0
 */
public class CarServiceImp implements CarService {

  private CarDao dao = new CarDaoImp();
  @Override
  public boolean addCar(Car car) {

    return dao.addCar(car);
  }

  @Override
  public boolean deleteCar(String carNum) {
    return dao.deleteCar(carNum);
  }

  @Override
  public boolean updateCar(Car car) {
    return dao.updateCar(car);
  }

  @Override
  public Car queryCarById(String carNum) {
    return dao.queryCarById(carNum);
  }

  @Override
  public List<Car> queryAllCar() {
    return dao.queryAllCar();
  }

  @Override
  public List<Car> queryCityAllCar(String cityName) {
    return dao.queryCityAllCar(cityName);
  }

}
