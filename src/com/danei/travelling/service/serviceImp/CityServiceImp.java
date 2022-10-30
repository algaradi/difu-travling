package com.danei.travelling.service.serviceImp;

import com.danei.travelling.dao.CityDao;
import com.danei.travelling.dao.daoImp.CityDaoImp;
import com.danei.travelling.entity.City;
import com.danei.travelling.service.CityService;

import java.util.List;

/**
 * @Describe:
 * @Author: wangdifu
 * @Date: 2022-1-11 , 0011 14:46
 * @Version: 1.0
 */
public class CityServiceImp implements CityService {
  private CityDao dao  = new CityDaoImp();
  @Override
  public boolean addCity(City city) {
    return dao.addCity(city);
  }

  @Override
  public boolean deleteCity(String cityName) {
    return dao.deleteCity(cityName);
  }

  @Override
  public boolean updateCity(City city) {
    return dao.updateCity(city);
  }

  @Override
  public List<City> queryAllCity() {
    return dao.queryAllCity();
  }
}
