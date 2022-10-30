package com.danei.travelling.entity;

/**
 * @Describe:宾馆实体类
 * @Author: wangdifu
 * @Date: 2022-1-10 , 0010 23:21
 * @Version: 1.0
 */
public class Hotel {

  private String hotelName ;// 宾馆名
  private Double price;// 价格
  private int numRooms ;// 房间数量
  private String cityName;// 所在城市
  private String address;// 详细地址


  @Override
  public String toString() {
    return "hotel{" +
            "hotelName='" + hotelName + '\'' +
            ", price=" + price +
            ", numRooms=" + numRooms +
            ", cityName='" + cityName + '\'' +
            ", address='" + address + '\'' +
            '}';
  }

  public Hotel() {
  }

  public Hotel(String hotelName, Double price, int numRooms, String cityName, String address) {
    this.hotelName = hotelName;
    this.price = price;
    this.numRooms = numRooms;
    this.cityName = cityName;
    this.address = address;
  }

  public String getHotelName() {
    return hotelName;
  }

  public void setHotelName(String hotelName) {
    this.hotelName = hotelName;
  }

  public Double getPrice() {
    return price;
  }

  public void setPrice(Double price) {
    this.price = price;
  }

  public int getNumRooms() {
    return numRooms;
  }

  public void setNumRooms(int numRooms) {
    this.numRooms = numRooms;
  }

  public String getCityName() {
    return cityName;
  }

  public void setCityName(String cityName) {
    this.cityName = cityName;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }
}
