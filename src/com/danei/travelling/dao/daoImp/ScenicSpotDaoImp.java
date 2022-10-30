package com.danei.travelling.dao.daoImp;

import com.danei.travelling.dao.BaseDao;
import com.danei.travelling.dao.ScenicSpotDao;
import com.danei.travelling.entity.ScenicSpot;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @Describe:
 * @Author: wangdifu
 * @Date: 2022-1-11 , 0011 12:22
 * @Version: 1.0
 */
public class ScenicSpotDaoImp implements ScenicSpotDao {
  @Override
  public boolean addScenicSpot(ScenicSpot scenicSpot) {
    String sql = "insert into scenicspots values(?,?,?,?,?,?,?)";
    Object[] obj = new Object[7];
    obj[0] = scenicSpot.getSpotName();
    obj[1] = scenicSpot.getPrice();
    obj[2] = scenicSpot.getCityName();
    obj[3] = scenicSpot.getAddress();
    obj[4] = scenicSpot.getTicketNum();
    obj[5] = scenicSpot.getPhoto();
    obj[6] = scenicSpot.getDescSpot();
    return BaseDao.update(sql,obj);
  }

  @Override
  public boolean deleteScenicSpot(String spotName) {
    String sql = "delete from scenicspots where spotName=?";
    return BaseDao.update(sql,spotName);
  }

  @Override
  public boolean updateScenicSpot(ScenicSpot scenicSpot) {
    String sql = "update scenicspots set price=? , cityName=? , address = ? ,ticketNum = ? ,photo=?, descSpot=? where spotName =?";
    Object[] obj = new Object[7];

    obj[0] = scenicSpot.getPrice();
    obj[1] = scenicSpot.getCityName();
    obj[2] = scenicSpot.getAddress();
    obj[3] = scenicSpot.getTicketNum();
    obj[4] = scenicSpot.getPhoto();
    obj[5] = scenicSpot.getDescSpot();
    obj[6] = scenicSpot.getSpotName();
    return BaseDao.update(sql,obj);
  }

  @Override
  public ScenicSpot queryScenicSpotById(String spotName) {
    String sql = "select * from scenicspots where spotName= '"+spotName+"'";
    ScenicSpot scenicSpot = new ScenicSpot();
    ResultSet rs = BaseDao.select(sql);

    if (rs != null) {
      try {
        while (rs.next()) {

          scenicSpot.setSpotName(rs.getString(1));
          scenicSpot.setPrice(rs.getDouble(2));
          scenicSpot.setCityName(rs.getString(3));
          scenicSpot.setAddress(rs.getString(4));
          scenicSpot.setTicketNum(rs.getInt(5));
          scenicSpot.setPhoto(rs.getString(6));
          scenicSpot.setDescSpot(rs.getString(7));

        }
      } catch (SQLException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }

    }
    return scenicSpot;
  }

  @Override
  public List<ScenicSpot> queryAllScenicSpot() {
    String sql = "select * from scenicspots ";
    List<ScenicSpot> list = new ArrayList<>();
    ResultSet rs = BaseDao.select(sql);

    if (rs != null) {
      try {
        while (rs.next()) {
          ScenicSpot scenicSpot = new ScenicSpot();
          scenicSpot.setSpotName(rs.getString(1));
          scenicSpot.setPrice(rs.getDouble(2));
          scenicSpot.setCityName(rs.getString(3));
          scenicSpot.setAddress(rs.getString(4));
          scenicSpot.setTicketNum(rs.getInt(5));
          scenicSpot.setPhoto(rs.getString(6));
          scenicSpot.setDescSpot(rs.getString(7));
          list.add(scenicSpot);

        }
      } catch (SQLException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }

    }
    return list;
  }

  @Override
  public List<ScenicSpot> queryCityAllScenicSpot(String cityName) {

    String sql = "select * from scenicspots where cityName= '"+cityName+"'";
    List<ScenicSpot> list = new ArrayList<>();
    ResultSet rs = BaseDao.select(sql);

    if (rs != null) {
      try {
        while (rs.next()) {
          ScenicSpot scenicSpot = new ScenicSpot();
          scenicSpot.setSpotName(rs.getString(1));
          scenicSpot.setPrice(rs.getDouble(2));
          scenicSpot.setCityName(rs.getString(3));
          scenicSpot.setAddress(rs.getString(4));
          scenicSpot.setTicketNum(rs.getInt(5));
          scenicSpot.setPhoto(rs.getString(6));
          scenicSpot.setDescSpot(rs.getString(7));
          list.add(scenicSpot);

        }
      } catch (SQLException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }

    }
    return list;
  }

  @Override
  public int getTicktNum(String spotName) {
    String sql= "select ticketNum from scenicspots where spotName = '"+spotName+"'";
    ResultSet rs = BaseDao.select(sql);

    int ticketNum = 0;
    if (rs != null) {
      try {
        while (rs.next()) {
          ticketNum = rs.getInt(1);
        }
      } catch (SQLException e) {
        e.printStackTrace();
      }

    }
    return ticketNum;
  }

  @Override
  public boolean editTicketNum(String spotName, int ticketNum) {
    String sql = "update scenicspots set ticketNum = ? where  spotName = ?";
    return BaseDao.update(sql,spotName,ticketNum);
  }

  @Override
  public HashMap<String, Integer> getCitysScenicCount() {
    String sql = "select cityName , count(*)  from scenicspots GROUP BY cityName";
    HashMap<String,Integer> hash = new HashMap<>();
    ResultSet rs =BaseDao.select(sql);

    if(rs != null) {
      try {
        while(rs.next()) {
          hash.put(rs.getString(1), rs.getInt(2));
        }
      } catch (SQLException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }

    }


    return hash;
  }
}
