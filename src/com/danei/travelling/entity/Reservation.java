package com.danei.travelling.entity;

/**
 * @Describe: 预订实体类 resvKey 表示根据预订类型的预订号，type 为 1 表示预订航班，2表示预订出租车，3 表示预订宾馆，4 表示预订景点门票
 * @Author: wangdifu
 * @Date: 2022-1-10 , 0010 23:26
 * @Version: 1.0
 */
public class Reservation {

   private String resvKey;// 预订号 ，可以是车号，宾馆名，航班号，或者景点名
   private String custName;// 顾客名
   private int type;// 预定类型， 1 表示预订航班，2表示预订车，3表示预订宾馆，4表示预订景点票
   private String resDate;// 预订时间
   private String number;// 号， 可以是航班或车座位号，或者是宾馆房间号，或者是景点门票号


  @Override
  public String toString() {
    return "Reservation{" +
            "resvKey='" + resvKey + '\'' +
            ", custName='" + custName + '\'' +
            ", type=" + type +
            ", resDate='" + resDate + '\'' +
            ", number='" + number + '\'' +
            '}';
  }

  public Reservation() {
  }

  public Reservation(String resvKey, String custName, int type, String resDate, String number) {
    this.resvKey = resvKey;
    this.custName = custName;
    this.type = type;
    this.resDate = resDate;
    this.number = number;
  }

  public String getResvKey() {
    return resvKey;
  }

  public void setResvKey(String resvKey) {
    this.resvKey = resvKey;
  }

  public String getCustName() {
    return custName;
  }

  public void setCustName(String custName) {
    this.custName = custName;
  }

  public int getType() {
    return type;
  }

  public void setType(int type) {
    this.type = type;
  }

  public String getResDate() {
    return resDate;
  }

  public void setResDate(String resDate) {
    this.resDate = resDate;
  }

  public String getNumber() {
    return number;
  }

  public void setNumber(String number) {
    this.number = number;
  }
}
