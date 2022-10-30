package com.danei.travelling.entity;

/**
 * @Describe: 出租车实体类
 * @Author: wangdifu
 * @Date: 2022-1-10 , 0010 23:14
 * @Version: 1.0
 */
public class Car {

  private String carNum; //车牌号
  private Double price; //价格
  private String cityName;  // 所在城市
  private String driver;// 车主


  @Override
  public String toString() {
    return "Car{" +
            "carNum='" + carNum + '\'' +
            ", price=" + price +
            ", cityName='" + cityName + '\'' +
            ", driver='" + driver + '\'' +
            '}';
  }

  public Car() {
  }


  public Car(String carNum, Double price, String cityName, String driver) {
    this.carNum = carNum;
    this.price = price;
    this.cityName = cityName;
    this.driver = driver;
  }

  public String getDriver() {
    return driver;
  }

  public void setDriver(String driver) {
    this.driver = driver;
  }

  public String getCarNum() {
    return carNum;
  }

  public void setCarNum(String carNum) {
    this.carNum = carNum;
  }

  public Double getPrice() {
    return price;
  }

  public void setPrice(Double price) {
    this.price = price;
  }

  public String getCityName() {
    return cityName;
  }

  public void setCityName(String cityName) {
    this.cityName = cityName;
  }
}
