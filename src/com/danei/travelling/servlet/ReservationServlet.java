package com.danei.travelling.servlet;

import com.danei.travelling.entity.Customer;
import com.danei.travelling.entity.Reservation;
import com.danei.travelling.service.*;
import com.danei.travelling.service.serviceImp.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @Describe:
 * @Author: wangdifu
 * @Date: 2022-1-12 , 0012 11:30
 * @Version: 1.0
 */
public class ReservationServlet extends BaseServlet {
  private ReservationService service = new ReservationServiceImp();

  /**
   * reservation 用来实现预订功能，可以是航班，景点门票，出租车，宾馆
   * @param req
   * @param resp
   * @throws ServletException
   * @throws IOException
   */
  protected void reservation(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    String msg ="";

    String resvKey = req.getParameter("resvKey");
    String custName = req.getParameter("custName");
    String t = req.getParameter("type");
    String resDate = req.getParameter("resDate");
    String number = "";// 随机完成的，根据type类型来实现
    int type = 0;
    try {
      type = Integer.parseInt(t);
    } catch (NumberFormatException e) {
      e.getMessage();
    }


    /**
     * 预订类型，确实是否在范围内 1 预订航班，2 预订车，3 预订宾馆 4 预订景点门票
     */
    if(type<=4 && type>=1){
      Reservation reservation ;

      boolean flag = false;
        switch (type){
          case 1: // 表示要订航班
            //1. 查看当前航班是否有空座位,如果有可以预订，则返回msg”对不起，当前无空座位“
            FlightService fs = new FlightServiceImp();
            int numSeats = fs.getNumSeats(resvKey);
            if(numSeats>=1){//有空位

            //2. 更具飞机的座位号规律生成随机数，实现座位号 以A12，C20 的格式
              char[] varstr={'A','A','B','D','C','G','K','H','J','K','K','H','B','C'};
              int ran = (int)(Math.random()*varstr.length)+1;
              String seat =""+varstr[ran];
              int[] varint ={20,10,12,13,14,15,27,16,17,18,19,20,21,22,23,24,25,26,29,30};
              ran = (int)(Math.random()*20)+1;
              seat +=" "+String.valueOf(varint[ran]);
              number = seat;

              reservation = new Reservation(resvKey,custName,type,resDate,number);
              flag = service.addReservation(reservation);
                // 判断是否预订成功，成功就将座位数减一，则返回失败msg
              if(flag == true){
                msg = "预订成功！"+"您的座位号为："+number;
                numSeats=numSeats-1;
                fs.editNumSeat(resvKey,numSeats);
              }else{
                msg = "预订失败";
              }
            }else{
              msg = "对不起，当前航班无空座，无法预订";
            }

            break;
          case 2: // 表示要订出租车
            //3. 根据车号规律生成随机数，实现座位号 以A2，B1，B2 的格式
            String[] ch = {"A2","B1","B2","B1","A2","B2","A2","B2","B1","A2","B2","A2","B2","B1","A2","B2","A2","B2","B1","A2","B2","A2","B2","B1","A2","B2","A2"};
            int ran2 = (int)(Math.random()*ch.length)+1;
            number = ""+ch[ran2];

            reservation = new Reservation(resvKey,custName,type,resDate,number);
            flag = service.addReservation(reservation);

            // 判断是否预订成功，成功，则返回失败msg
            if(flag == true){
              msg = "预订成功！"+"您车座位为："+number;
            }else{
              msg = "预订失败";
            }

            break;
          case 3:// 表示要订宾馆
            // 查看当前宾馆是否有空房间,如果有可以预订，则返回msg”对不起，当前无房间“
            HoterlService hs = new HotelServiceImp();
            int numRooms = hs.getNumRooms(resvKey);
            if(numRooms>=1){

              //4. 根据车号规律生成随机数，实现座位号 以1101，1202，9002 的格式
              String[] hn = {"1001","1002","1101","1201","1202","1203","1204","1205","5001","5001","5002","5003","5004","4001","4002","4006","1105","1504","1508","9001","9005","9006","3002","3001","3008","8002","8004"};
              int ran3 = (int)(Math.random()*(hn.length))+1;
              number = ""+hn[ran3];

              reservation = new Reservation(resvKey,custName,type,resDate,number);
              flag = service.addReservation(reservation);
              // 判断是否预订成功，成功就将房间数减一，则返回失败msg
              if(flag == true){
                msg = "预订成功！您的房间号为："+number;
                numRooms=numRooms-1;
                hs.editNumRooms(resvKey,numRooms);
              }else{
                msg = "预订失败";
              }
            }else{
              msg = "对不起，宾馆无空房，无法预订";
            }


            break;
          case 4:// 表示要订景点门票
            // 查看当前景点门票是否有门票,如果有可以预订，则返回msg”对不起，当前该景点无票“
            ScenicSpotService ss = new ScenicSpotServiceImp();
            int ticktNum = ss.getTicktNum(resvKey);
            if(ticktNum>=1){

              //4. 根据车号规律生成随机数，实现座位号 以[A-K][1-8]-[1-10] 的格式如'A1-13'
              char[] chs={'A','A','B','D','C','G','K','H','J','K','K','H','B','C'};
              int ran4 = (int)(Math.random()*(chs.length))+1;
              number = ""+chs[ran4]+"-";
               ran4 = (int)(Math.random()*30)+1;
               number += ""+String.valueOf(ran4);


              reservation = new Reservation(resvKey,custName,type,resDate,number);
              flag = service.addReservation(reservation);
              // 判断是否预订成功，成功就将票数减一，则返回失败msg
              if(flag == true){
                msg = "预订成功！您的预订门票号为："+number;
                ticktNum=ticktNum-1;
                ss.editTicketNum(resvKey,ticktNum);
              }else{
                msg = "预订失败";
              }
            }else{
              msg = "对不起，宾馆无票，无法预订";
            }
            break;
          default: msg = "预订失败！";
        }

    }else {
      msg =" 预订类型不存在";
    }


    req.setAttribute("msg",msg);
    req.getRequestDispatcher("booking.jsp").forward(req,resp);


  }

  /**
   * list  预订管理 获取所有的预订信息
   * 只有管理员用
   * @param req
   * @param resp
   * @throws ServletException
   * @throws IOException
   */
  protected void list(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    List<Reservation> reservations = service.queryAllReservation();
    req.setAttribute("reservations",reservations);
    req.getRequestDispatcher("").forward(req,resp);
  }

  /**
   * mylist  获取我的所有的预订信息
   * @param req
   * @param resp
   * @throws ServletException
   * @throws IOException
   */
  protected void mylist(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    String msg ="";
    Customer cust = (Customer) req.getSession().getAttribute("cust");
    String custName = cust.getCustName();
    List<Reservation> reservations = null;
    if (custName != null) {
      reservations = service.queryCustomerAllReservation(custName);
      req.setAttribute("reservations",reservations);
    }else{
      msg="当前没有预订";
    }
    System.out.println(reservations.toString());
    req.getRequestDispatcher("Myreservation.jsp").forward(req,resp);
  }
  /**
   * mylist  获取我的所有的预订信息
   * @param req
   * @param resp
   * @throws ServletException
   * @throws IOException
   */
  protected void listType(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    String msg ="";
    Customer cust = (Customer) req.getSession().getAttribute("cust");
    String custName = cust.getCustName();
    String t = req.getParameter("type");
    int type = 0;
    try {
      type = Integer.parseInt(t);
    } catch (NumberFormatException e) {
      e.getMessage();
    }
    List<Reservation> reservations = null;
    if (custName.equals("")) {
      reservations = service.queryCustomerReservationByType(custName,type);
      req.setAttribute("reservations",reservations);
    }else{
      msg="当前没有订单";
    }
    System.out.println(reservations.toString());
    req.getRequestDispatcher("Myreservation.jsp").forward(req,resp);
  }



}
