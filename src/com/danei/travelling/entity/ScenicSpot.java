package com.danei.travelling.entity;

/**
 * @Describe: ����ʵ����
 * @Author: wangdifu
 * @Date: 2022-1-10 , 0010 23:35
 * @Version: 1.0
 */
public class ScenicSpot {


  private String spotName;// ������
  private Double price;//�۸�
  private String cityName;// ���ڳ���
  private String address;// ��ϸ��ַ
  private int ticketNum;// Ʊ����
  private String photo;// ��Ƭ·���� ����Ƭ�����ڱ���·����photo�������ݿ���
  private String descSpot;//��������


  @Override
  public String toString() {
    return "ScenicSpot{" +
            "spotName='" + spotName + '\'' +
            ", price=" + price +
            ", cityName='" + cityName + '\'' +
            ", address='" + address + '\'' +
            ", ticketNum=" + ticketNum +
            ", photo='" + photo + '\'' +
            ", descSpot='" + descSpot + '\'' +
            '}';
  }
  
  public ScenicSpot() {
  }

  public ScenicSpot(String spotName, Double price, String cityName, String address, int ticketNum, String photo, String descSpot) {
    this.spotName = spotName;
    this.price = price;
    this.cityName = cityName;
    this.address = address;
    this.ticketNum = ticketNum;
    this.photo = photo;
    this.descSpot = descSpot;
  }

  public String getSpotName() {
    return spotName;
  }

  public void setSpotName(String spotName) {
    this.spotName = spotName;
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

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public int getTicketNum() {
    return ticketNum;
  }

  public void setTicketNum(int ticketNum) {
    this.ticketNum = ticketNum;
  }

  public String getPhoto() {
    return photo;
  }

  public void setPhoto(String photo) {
    this.photo = photo;
  }

  public String getDescSpot() {
    return descSpot;
  }

  public void setDescSpot(String descSpot) {
    this.descSpot = descSpot;
  }
}
