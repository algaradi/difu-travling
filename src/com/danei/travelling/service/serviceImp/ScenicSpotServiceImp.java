package com.danei.travelling.service.serviceImp;

import com.danei.travelling.dao.ScenicSpotDao;
import com.danei.travelling.dao.daoImp.ScenicSpotDaoImp;
import com.danei.travelling.entity.ScenicSpot;
import com.danei.travelling.service.ScenicSpotService;

import java.util.HashMap;
import java.util.List;

/**
 * @Describe:
 * @Author: wangdifu
 * @Date: 2022-1-11 , 0011 15:01
 * @Version: 1.0
 */
public class ScenicSpotServiceImp implements ScenicSpotService {
  private ScenicSpotDao dao = new ScenicSpotDaoImp();
  @Override
  public boolean addScenicSpot(ScenicSpot scenicSpot) {
    return dao.addScenicSpot(scenicSpot);
  }

  @Override
  public boolean deleteScenicSpot(String spotName) {
    return dao.deleteScenicSpot(spotName);
  }

  @Override
  public boolean updateScenicSpot(ScenicSpot scenicSpot) {
    return dao.updateScenicSpot(scenicSpot);
  }

  @Override
  public ScenicSpot queryScenicSpotById(String spotName) {
    return dao.queryScenicSpotById(spotName);
  }

  @Override
  public List<ScenicSpot> queryAllScenicSpot() {
    return dao.queryAllScenicSpot();
  }

  @Override
  public List<ScenicSpot> queryCityAllScenicSpot(String cityName) {
    return dao.queryCityAllScenicSpot(cityName);
  }

  @Override
  public int getTicktNum(String spotName) {
    return dao.getTicktNum(spotName);
  }

  @Override
  public boolean editTicketNum(String spotName, int ticketNum) {
    return dao.editTicketNum(spotName,ticketNum);
  }

  @Override
  public HashMap<String, Integer> getCitysScenicCount() {
    return dao.getCitysScenicCount();
  }
}
