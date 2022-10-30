package com.danei.travelling.test;

/**
 * @Describe:
 * @Author: wangdifu
 * @Date: 2022-4-10 , 0010 15:22
 * @Version: 1.0
 */
public class Test {


  @org.junit.Test
    public void test() {
      int H = 7, W = 7;//高和宽必须是相等的奇数
      for(int i=0; i<(H+1) / 2; i++) {
        for(int j=0; j<W/2-i; j++) {
          System.out.print(" ");

        }
        for(int k=1; k<(i+1)*2; k++) {
          System.out.print('*');
        }
        System.out.println();
      }
      for(int i=1; i<=H/2; i++) {
        for(int j=1; j<=i; j++) {
          System.out.print(" ");
        }
        for(int k=1; k<=W-2*i; k++) {
          System.out.print('*');
        }
        System.out.println();
      }
    }
  }

