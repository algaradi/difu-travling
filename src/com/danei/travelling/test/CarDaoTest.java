package com.danei.travelling.test;

import com.danei.travelling.dao.CarDao;
import com.danei.travelling.dao.daoImp.CarDaoImp;
import com.danei.travelling.entity.Car;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @Describe:
 * @Author: wangdifu
 * @Date: 2022-1-11 , 0011 9:09
 * @Version: 1.0
 */
class CarDaoTest {
  private static CarDao dao = new CarDaoImp();

//  public static void main(String[] args) {
//    Car car = new Car("X111111111",200.0,"厦门","王迪夫");
//    boolean i = dao.addCar(car);
//    System.out.println(i);
//  }

  @Test
  public void addCar() {

//    Car car = new Car("XM1003",200.0,"厦门","王迪夫");
    Car car = new Car("Xfds",200.0,"厦门","王迪夫");
    boolean i = dao.addCar(car);
    System.out.println(i);

  }

  @Test
  void deleteCar() {
    boolean xfds = dao.deleteCar("Xfds");
    System.out.println(xfds);
  }

  @Test
  void updateCar() {
    Car car = new Car("X111111111",200.0,"西安","王迪夫");
    boolean b = dao.updateCar(car);
    System.out.println(b);
  }

  @Test
  void queryCarById() {
    Car x111111111 = dao.queryCarById("X111111111");
    System.out.println(x111111111);
  }

  @Test
  void queryAllCar() {
 List<Car> car = dao.queryAllCar();
    System.out.println(car.toString());

  }

  @Test
  void queryCityAllCar() {
    System.out.println(dao.queryCityAllCar("北京").toString());
  }
}
