package com.danei.travelling.servlet;

import com.danei.travelling.entity.Customer;
import com.danei.travelling.entity.Hotel;
import com.danei.travelling.service.HoterlService;
import com.danei.travelling.service.serviceImp.HotelServiceImp;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @Describe:
 * @Author: wangdifu
 * @Date: 2022-1-11 , 0011 17:02
 * @Version: 1.0
 */
public class HotelServlet extends BaseServlet{

private HoterlService service = new HotelServiceImp();
  /**
   * add 宾馆管理， 添加方法
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
      String hotelName = req.getParameter("hotelName");
      String p = req.getParameter("price");
      String nr = req.getParameter("numRooms");
      String cityName = req.getParameter("cityName");
      String address = req.getParameter("address");
      Double price = 50.0;
      int numRooms = 30;
      try {
        price = Double.parseDouble(p);
        numRooms = Integer.parseInt(nr);
      } catch (NumberFormatException e) {
        e.getMessage();
      }

      Hotel hotel = new Hotel(hotelName,price,numRooms,cityName,address);
      boolean flag = service.addHotel(hotel);
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
    req.getRequestDispatcher("HotelServlet?action=list").forward(req, resp);

  }

  /**
   * edit 宾馆管理 修改宾馆信息 比如 地址，价格，房间数量，所在的城市
   * 只有管理员由权限使用
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
      String hotelName = req.getParameter("hotelName");
      String p = req.getParameter("price");
      String nr = req.getParameter("numRooms");
      String cityName = req.getParameter("cityName");
      String address = req.getParameter("address");
      Double price = 50.0;
      int numRooms = 30;
      try {
        price = Double.parseDouble(p);
        numRooms = Integer.parseInt(nr);
      } catch (NumberFormatException e) {
        e.getMessage();
      }

      Hotel hotel = new Hotel(hotelName,price,numRooms,cityName,address);
      boolean flag = service.updateHotel(hotel);
      if(flag == true){
        msg = "修改成功";
      }else{
        msg = "修改失败";
      }



    }else {
      msg = "本用户不是管理员， 没有权限添加信息";
    }
    req.setAttribute("msg", msg);
    //返回到原来的页面
    req.getRequestDispatcher("hotel_modify.jsp").forward(req, resp);


}


  /**
   * delete 宾馆管理，删除宾馆
   * 只有管理员由权限使用
   * @param req
   * @param resp
   * @throws ServletException
   * @throws IOException
   */
  protected void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    String msg = "";
    // 获取会话中，当前的用户信息，确定是否管理员 ， 是继续操作，则返回不能操作，没有权限
    Customer cust =  (Customer)req.getSession().getAttribute("cust");
    if(cust.getType() == 1) {
      String hotelName = req.getParameter("hotelName");
      boolean flag = service.deleteHotel(hotelName);
      if(flag == true){
        msg = "删除成功";
      }else{
        msg = "删除失败";
      }

    }else {
      msg = "本用户不是管理员， 没有权限删除信息";
    }
    req.setAttribute("msg", msg);
    //返回到原来的页面
    req.getRequestDispatcher("HotelServlet?action=list").forward(req, resp);


  }


  /**
   * list 获取所有的宾馆信息
   * @param req
   * @param resp
   * @throws ServletException
   * @throws IOException
   */
  protected void list(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    List<Hotel> hotels = service.queryAllHotel();
    req.setAttribute("hotels" , hotels);
    req.getRequestDispatcher("hotel.jsp").forward(req, resp);

  }

  /**
   * rlist 获取所有的宾馆信息，顾客使用实现查找以及预定
   * @param req
   * @param resp
   * @throws ServletException
   * @throws IOException
   */
  protected void rlist(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    List<Hotel> hotels = service.queryAllHotel();
    req.setAttribute("hotels" , hotels);
    req.getRequestDispatcher("Rhotel.jsp").forward(req, resp);

  }

  /**
   * listBycity 获取所有的宾馆信息
   * @param req
   * @param resp
   * @throws ServletException
   * @throws IOException
   */
  protected void listBycity(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    String cityName = req.getParameter("cityName");
    List<Hotel> hotels = service.querCityAllHotel(cityName);
    req.setAttribute("hotels" , hotels);
    req.getRequestDispatcher("Rhotel.jsp").forward(req, resp);

  }



}
