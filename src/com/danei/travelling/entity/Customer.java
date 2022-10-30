package com.danei.travelling.entity;

/**
 * @Describe:用户实体类，type为1 表示管理员，2表示顾客，3 表示车主
 * @Author: wangdifu
 * @Date: 2022-1-10 , 0010 23:08
 * @Version: 1.0
 */
public class Customer {

  private String custName ;
  private String password;
  private int type;
  private String custPhone;


  public Customer(String custName, String password, int type, String custPhone) {
    this.custName = custName;
    this.password = password;
    this.type = type;
    this.custPhone = custPhone;
  }

  public Customer() {
  }

  @Override
  public String toString() {
    return "Customer{" +
            "custName='" + custName + '\'' +
            ", password='" + password + '\'' +
            ", type=" + type +
            ", custPhone='" + custPhone + '\'' +
            '}';
  }

  public String getCustName() {
    return custName;
  }

  public void setCustName(String custName) {
    this.custName = custName;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public int getType() {
    return type;
  }

  public void setType(int type) {
    this.type = type;
  }

  public String getCustPhone() {
    return custPhone;
  }

  public void setCustPhone(String custPhone) {
    this.custPhone = custPhone;
  }
}
