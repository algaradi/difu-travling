package com.danei.travelling.entity;

/**
 * @Describe: 航班实体类
 * @Author: wangdifu
 * @Date: 2022-1-10 , 0010 23:16
 * @Version: 1.0
 */
public class Flight {

  private String flightNum; // 航班号
  private Double price;  // 价格
  private int numSeats; //座位数
  private String fromCity;// 出发城市
  private String fromDate;//出发和时间  年-月-日 点：分钟
  private String arivCity;// 目的城市
  private String arivDate;//到达日期和时间 年-月-日 点：分钟


  @Override
  public String toString() {
    return "Flight{" +
            "flightNum='" + flightNum + '\'' +
            ", price=" + price +
            ", numSeats=" + numSeats +
            ", fromCity='" + fromCity + '\'' +
            ", fromDate='" + fromDate + '\'' +
            ", arivCity='" + arivCity + '\'' +
            ", arivDate='" + arivDate + '\'' +
            '}';
  }

  public Flight() {
  }

  public Flight(String flightNum, Double price, int numSeats, String fromCity, String fromDate, String arivCity, String arivDate) {
    this.flightNum = flightNum;
    this.price = price;
    this.numSeats = numSeats;
    this.fromCity = fromCity;
    this.fromDate = fromDate;
    this.arivCity = arivCity;
    this.arivDate = arivDate;
  }

  public String getFlightNum() {
    return flightNum;
  }

  public void setFlightNum(String flightNum) {
    this.flightNum = flightNum;
  }

  public Double getPrice() {
    return price;
  }

  public void setPrice(Double price) {
    this.price = price;
  }

  public int getNumSeats() {
    return numSeats;
  }

  public void setNumSeats(int numSeats) {
    this.numSeats = numSeats;
  }

  public String getFromCity() {
    return fromCity;
  }

  public void setFromCity(String fromCity) {
    this.fromCity = fromCity;
  }

  public String getFromDate() {
    return fromDate;
  }

  public void setFromDate(String fromDate) {
    this.fromDate = fromDate;
  }

  public String getArivCity() {
    return arivCity;
  }

  public void setArivCity(String arivCity) {
    this.arivCity = arivCity;
  }

  public String getArivDate() {
    return arivDate;
  }

  public void setArivDate(String arivDate) {
    this.arivDate = arivDate;
  }
}
