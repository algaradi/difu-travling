package com.danei.travelling.test;

import com.danei.travelling.dao.CityDao;
import com.danei.travelling.dao.daoImp.CityDaoImp;
import com.danei.travelling.entity.City;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @Describe:
 * @Author: wangdifu
 * @Date: 2022-1-11 , 0011 14:39
 * @Version: 1.0
 */
class CityDaoTest {
private CityDao dao = new CityDaoImp();
  @Test
  void addCity() {
    City city = new City("Sana'a");
    System.out.println(dao.addCity(city));
  }

  @Test
  void deleteCity() {
    System.out.println(dao.deleteCity("Sana'a"));
  }

  @Test
  void updateCity() {
//    City city = new City("Aden");
//    System.out.println(dao.updateCity(city));

  }

  @Test
  void queryAllCity() {
    System.out.println(dao.queryAllCity().toString());
  }



  }