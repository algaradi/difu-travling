package com.danei.travelling.entity;

/**
 * @Describe: Ԥ��ʵ���� resvKey ��ʾ����Ԥ�����͵�Ԥ���ţ�type Ϊ 1 ��ʾԤ�����࣬2��ʾԤ�����⳵��3 ��ʾԤ�����ݣ�4 ��ʾԤ��������Ʊ
 * @Author: wangdifu
 * @Date: 2022-1-10 , 0010 23:26
 * @Version: 1.0
 */
public class Reservation {

   private String resvKey;// Ԥ���� �������ǳ��ţ�������������ţ����߾�����
   private String custName;// �˿���
   private int type;// Ԥ�����ͣ� 1 ��ʾԤ�����࣬2��ʾԤ������3��ʾԤ�����ݣ�4��ʾԤ������Ʊ
   private String resDate;// Ԥ��ʱ��
   private String number;// �ţ� �����Ǻ������λ�ţ������Ǳ��ݷ���ţ������Ǿ�����Ʊ��


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
