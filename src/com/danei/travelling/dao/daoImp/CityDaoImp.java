package com.danei.travelling.dao.daoImp;

import com.danei.travelling.dao.BaseDao;
import com.danei.travelling.dao.CityDao;
import com.danei.travelling.entity.City;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @Describe:
 * @Author: wangdifu
 * @Date: 2022-1-11 , 0011 14:33
 * @Version: 1.0
 */
public class CityDaoImp implements CityDao {
  @Override
  public boolean addCity(City city) {
    String sql = "insert into city values(?)";
    Object[] obj = new Object[1];
    obj[0] = city.getCityName();
    return BaseDao.update(sql,obj);
  }

  @Override
  public boolean deleteCity(String cityName) {
    String sql = "delete from city where cityName = ?";
    return BaseDao.update(sql,cityName);
  }

  @Override
  public boolean updateCity(City city) {

    return false;
  }

  @Override
  public List<City> queryAllCity() {
    String sql = "select * from city ";
    List<City> list = new ArrayList<City>();
    ResultSet rs = BaseDao.select(sql);

    if (rs != null) {
      try {
        while (rs.next()) {

          City city = new City();
          city.setCityName(rs.getString(1));
        list.add(city);

        }
      } catch (SQLException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }

    }
    return list;
  }
}
