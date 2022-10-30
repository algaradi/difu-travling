package com.danei.wangdifu;



import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * @Describe:
 * @Author: wangdifu
 * @Date: 2022-5-21 , 0021 11:30
 * @Version: 1.0
 */
class Oracle {
  Connection conn;
  public Connection oracleConn(){

      String driver="oracle.jdbc.driver.OracleDriver";
      String url="jdbc:oracle:thin:@localhost:1521:lianxi";
      try
      {
        Class.forName(driver);
        conn= DriverManager.getConnection(url,"scott","tigger");
      }
      catch(Exception e)
      {
        System.out.println("数据库连接失败，原因如下所示：");
        e.printStackTrace();
      }
      return conn;
  }

  @Test
   public void test() {
    Oracle o = new Oracle();
    Connection oracleConn = o.oracleConn();
    System.out.println(oracleConn);
  }
  }



