package com.danei.travelling.entity;

/**
 * @Describe: ����ʵ����
 * @Author: wangdifu
 * @Date: 2022-1-10 , 0010 23:24
 * @Version: 1.0
 */
public class City {

  private String cityName;//������


  @Override
  public String toString() {
    return "City{" +
            "cityName='" + cityName + '\'' +
            '}';
  }

  public City() {
  }

  public City(String cityName) {
    this.cityName = cityName;
  }

  public String getCityName() {
    return cityName;
  }

  public void setCityName(String cityName) {
    this.cityName = cityName;
  }
}
