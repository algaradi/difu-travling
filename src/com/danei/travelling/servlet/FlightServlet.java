package com.danei.travelling.servlet;

import com.danei.travelling.dao.FlightDao;
import com.danei.travelling.dao.daoImp.FlightDaoImp;
import com.danei.travelling.entity.Customer;
import com.danei.travelling.entity.Flight;
import com.danei.travelling.entity.Hotel;
import com.danei.travelling.service.FlightService;
import com.danei.travelling.service.serviceImp.FlightServiceImp;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @Describe:
 * @Author: wangdifu
 * @Date: 2022-1-11 , 0011 17:26
 * @Version: 1.0
 */
public class FlightServlet extends BaseServlet {
  private FlightService service = new FlightServiceImp();

  /**
   * add 航班管理，添加航班方法
   * 只有管理员有该权限
   * @param req
   * @param resp
   * @throws ServletException
   * @throws IOException
   */
  protected void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    String msg = "";
    // 获取会话中，当前的用户信息，确定是否管理员 ， 是继续操作，则返回不能操作，没有权限
    Customer cust =  (Customer)req.getSession().getAttribute("cust");
    if(cust.getType() == 1) {
      String flightNum = req.getParameter("flightNum");
      String p = req.getParameter("price");
      String ns = req.getParameter("numSeats");
      String fromCity = req.getParameter("fromCity");
      String fromDate = req.getParameter("fromDate");
      String arivCity = req.getParameter("arivCity");
      String arivDate = req.getParameter("arivDate");

      Double price = 200.0;
      int numSeats = 30;
      try {
        price = Double.parseDouble(p);
        numSeats = Integer.parseInt(ns);
      } catch (NumberFormatException e) {
        e.getMessage();
      }

      Flight flight = new Flight(flightNum,price,numSeats,fromCity,fromDate,arivCity,arivDate);
      boolean flag = service.addFlight(flight);
      if(flag == true){
        msg = "添加成功";
      }else{
        msg = "添加失败";
      }

    }else {
      msg = "本用户不是管理员， 没有权限添加信息";
    }
    req.setAttribute("msg", msg);
    //返回到原来的页面
    req.getRequestDispatcher("FlightServlet?action=list").forward(req, resp);

  }


  /**
   * edit 航班管理，修改航班信息方法
   * 只有管理员有该权限
   * @param req
   * @param resp
   * @throws ServletException
   * @throws IOException
   */
  protected void edit(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    String msg = "";
    // 获取会话中，当前的用户信息，确定是否管理员 ， 是继续操作，则返回不能操作，没有权限
    Customer cust =  (Customer)req.getSession().getAttribute("cust");
    if(cust.getType() == 1) {
      String flightNum = req.getParameter("flightNum");
      String p = req.getParameter("price");
      String ns = req.getParameter("numSeats");
      String fromCity = req.getParameter("fromCity");
      String fromDate = req.getParameter("fromDate");
      String arivCity = req.getParameter("arivCity");
      String arivDate = req.getParameter("arivDate");

      Double price = 200.0;
      int numSeats = 30;
      try {
        price = Double.parseDouble(p);
        numSeats = Integer.parseInt(ns);
      } catch (NumberFormatException e) {
        e.getMessage();
      }

      Flight flight = new Flight(flightNum,price,numSeats,fromCity,fromDate,arivCity,arivDate);
      boolean flag = service.updateFlight(flight);
      if(flag == true){
        msg = "修改成功";
      }else{
        msg = "修改失败";
      }

    }else {
      msg = "本用户不是管理员， 没有权限修改信息";
    }
    req.setAttribute("msg", msg);
    //返回到原来的页面
    req.getRequestDispatcher("flight_modify.jsp").forward(req, resp);

  }


  /**
   * delete 航班管理，删航班
   * 只有管理员有该权限
   * @param req
   * @param resp
   * @throws ServletException
   * @throws IOException
   */
  protected void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    String msg = "";
    // 获取会话中，当前的用户信息，确定是否管理员 ， 是继续删除，则返回不能删
    Customer cust =  (Customer)req.getSession().getAttribute("cust");
    if(cust.getType() == 1) {
      String flightNum = req.getParameter("flightNum");
      boolean flag = service.deleteFlight(flightNum);
      if(flag == true){
        msg ="删除成功";
      }else{
        msg ="删除失败";
      }


    }else {
      msg = "本用户不是管理员， 没有权限删除信息";
    }
    req.setAttribute("msg", msg);
    //返回到原来的页面
    req.getRequestDispatcher("FlightServlet?action=list").forward(req, resp);

  }

  /**
   * list 获取所有的航班信息
   * @param req
   * @param resp
   * @throws ServletException
   * @throws IOException
   */
  protected void list(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    List<Flight> flights = service.queryAllFlight();
    req.setAttribute("flights" , flights);
    req.getRequestDispatcher("flight.jsp").forward(req, resp);

  }
  /**
   * rlist 获取所有的航班信息，顾客使用实现查找以及预定
   * @param req
   * @param resp
   * @throws ServletException
   * @throws IOException
   */
  protected void rlist(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    List<Flight> flights = service.queryAllFlight();
    req.setAttribute("flights" , flights);
    req.getRequestDispatcher("Rflight.jsp").forward(req, resp);

  }

  /**
   * listWithDP 根据出发城市，目的城市，出发日期，到达日期
   * @param req
   * @param resp
   * @throws ServletException
   * @throws IOException
   */
  protected void listWithDP(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    String fromCity = req.getParameter("fromCity");
    String arivCity = req.getParameter("arivCity");
    String fromDate = req.getParameter("fromDate");
    String arivDate = req.getParameter("arivDate");
    System.out.println(fromCity + arivCity+ fromDate+ " 11111 "+arivDate);
    List<Flight> flights = service.querFromArivCityWithTimeAllflight(fromCity, arivCity, fromDate, arivDate);
    String msg = fromDate+"至"+arivDate+"日期 : 从"+fromCity+"到"+arivCity+"的航班";
    req.setAttribute("msg",msg);
    req.setAttribute("flights" , flights);
    req.getRequestDispatcher("Rflight.jsp").forward(req, resp);

  }







}
