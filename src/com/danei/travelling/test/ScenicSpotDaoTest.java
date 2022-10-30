package com.danei.travelling.test;

import com.danei.travelling.dao.ScenicSpotDao;
import com.danei.travelling.dao.daoImp.ScenicSpotDaoImp;
import com.danei.travelling.entity.ScenicSpot;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @Describe:
 * @Author: wangdifu
 * @Date: 2022-1-11 , 0011 14:23
 * @Version: 1.0
 */
class ScenicSpotDaoTest {

  private ScenicSpotDao dao = new ScenicSpotDaoImp();

  @Test
  void addScenicSpot() {
    ScenicSpot scenicSpot = new ScenicSpot("景点深圳C11",70.0,"深圳","详细地址",80,"照片地址","景点C的描述");
    System.out.println(dao.addScenicSpot(scenicSpot));
  }

  @Test
  void deleteScenicSpot() {
    System.out.println(dao.deleteScenicSpot("景点深圳C11"));
  }

  @Test
  void updateScenicSpot() {
    ScenicSpot scenicSpot = new ScenicSpot("景点深圳C11",70.0,"北京","详细地址",80,"照片地址","景点C的描述");
    System.out.println(dao.updateScenicSpot(scenicSpot));
  }

  @Test
  void queryScenicSpotById() {
    System.out.println(dao.queryScenicSpotById("景点深圳C11"));
  }

  @Test
  void queryAllScenicSpot() {
    System.out.println(dao.queryAllScenicSpot().toString());
  }

  @Test
  void queryCityAllScenicSpot() {
    System.out.println(dao.queryCityAllScenicSpot("北京").toString());
  }

  @Test
  void getTicktNum() {
    int ticktNum = dao.getTicktNum("景点杭州A");
    System.out.println(ticktNum);
  }

  @Test
  void editTicketNum() {
    System.out.println(dao.editTicketNum("景点杭州A", 44));
  }
}