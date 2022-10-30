package com.danei.travelling.service;

import com.danei.travelling.entity.ScenicSpot;

import java.util.HashMap;
import java.util.List;

/**
 * @Describe:
 * @Author: wangdifu
 * @Date: 2022-1-11 , 0011 0:19
 * @Version: 1.0
 */
public interface ScenicSpotService {
  boolean addScenicSpot( ScenicSpot scenicSpot);
  boolean deleteScenicSpot(String spotName);
  boolean updateScenicSpot(ScenicSpot scenicSpot);

  ScenicSpot queryScenicSpotById(String spotName);
  List<ScenicSpot> queryAllScenicSpot();
  List<ScenicSpot> queryCityAllScenicSpot(String cityName);

  int getTicktNum(String spotName);
  boolean editTicketNum(String spotName , int ticketNum);

  HashMap<String,Integer> getCitysScenicCount();
}
