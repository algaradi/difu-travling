package com.danei.travelling.entity;

/**
 * @Describe: ����ʵ����
 * @Author: wangdifu
 * @Date: 2022-1-10 , 0010 23:16
 * @Version: 1.0
 */
public class Flight {

  private String flightNum; // �����
  private Double price;  // �۸�
  private int numSeats; //��λ��
  private String fromCity;// ��������
  private String fromDate;//������ʱ��  ��-��-�� �㣺����
  private String arivCity;// Ŀ�ĳ���
  private String arivDate;//�������ں�ʱ�� ��-��-�� �㣺����


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
