package com.danei.travelling.servlet;

import com.danei.travelling.entity.Flight;
import com.danei.travelling.entity.ScenicSpot;
import com.danei.travelling.service.ScenicSpotService;
import com.danei.travelling.service.serviceImp.ScenicSpotServiceImp;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

/**
 * @Describe:
 * @Author: wangdifu
 * @Date: 2022-1-11 , 0011 22:22
 * @Version: 1.0
 */
public class ScenicSpotServlet extends BaseServlet {
  private ScenicSpotService service = new ScenicSpotServiceImp();


  /**
   *  add 景点管理，添加景点
   * @param req
   * @param resp
   * @throws ServletException
   * @throws IOException
   */
  protected void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    String msg = "";
    String spotName = req.getParameter("spotName");
    String p = req.getParameter("price");
    String cityName = req.getParameter("cityName");
    String address = req.getParameter("address");
    String tk = req.getParameter("ticketNum");
    String photo = req.getParameter("photo");
    String descSpot = req.getParameter("descSpot");

    int ticketNum = 0;
    Double price =0.0;
    try {
      price = Double.parseDouble(p);
      ticketNum = Integer.parseInt(tk);
    } catch (NumberFormatException e) {
      e.getMessage();
    }

    ScenicSpot scenicSpot= new ScenicSpot(spotName,price,cityName,address,ticketNum,photo,descSpot);
    boolean flag = service.addScenicSpot(scenicSpot);
    if(flag == true){
      msg = "添加成功";
    }else{
      msg ="添加失败";
    }

    req.setAttribute("msg" , msg);
    req.getRequestDispatcher("ScenicSpotServlet?action=listManage").forward(req, resp);

  }

  /**
   *  edit 景点管理 ，修改景点信息
   * @param req
   * @param resp
   * @throws ServletException
   * @throws IOException
   */
  protected void edit(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    String msg = "";
    String spotName = req.getParameter("spotName");
    String p = req.getParameter("price");
    String cityName = req.getParameter("cityName");
    String address = req.getParameter("address");
    String tk = req.getParameter("ticketNum");
    String photo = req.getParameter("photo");
    String descSpot = req.getParameter("descSpot");

    int ticketNum = 0;
    Double price =0.0;
    try {
      price = Double.parseDouble(p);
      ticketNum = Integer.parseInt(tk);
    } catch (NumberFormatException e) {
      e.getMessage();
    }

    ScenicSpot scenicSpot= new ScenicSpot(spotName,price,cityName,address,ticketNum,photo,descSpot);
    boolean flag = service.updateScenicSpot(scenicSpot);
    if(flag == true){
      msg = "修改成功";
    }else{
      msg ="修改失败";
    }

    req.setAttribute("msg" , msg);
    req.getRequestDispatcher("ScenicSpotServlet?action=list").forward(req, resp);

  }

  /**
   * delete 获取所有的景点属性
   * @param req
   * @param resp
   * @throws ServletException
   * @throws IOException
   */
  protected void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    String msg ="";
    String spotName = req.getParameter("spotName");
    boolean flag =service.deleteScenicSpot(spotName);
    if(flag == true){
      msg = "删除成功";
    }else{
      msg = "删除失败";
    }
    req.setAttribute("msg" , msg);
    req.getRequestDispatcher("ScenicSpotServlet?action=listManage").forward(req, resp);

  }

  /**
   * list 获取所有的景点属性
   * @param req
   * @param resp
   * @throws ServletException
   * @throws IOException
   */
  protected void list(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

   List<ScenicSpot> scenicSpots = service.queryAllScenicSpot();
    System.out.println(scenicSpots.toString());
    req.setAttribute("scenicSpots" , scenicSpots);
    req.getRequestDispatcher("index.jsp").forward(req, resp);

  }
  /**
   * rlist 获取所有的景点属性
   * @param req
   * @param resp
   * @throws ServletException
   * @throws IOException
   */
  protected void rlist(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    List<ScenicSpot> scenicSpots = service.queryAllScenicSpot();
    req.setAttribute("scenicSpots" , scenicSpots);
    req.getRequestDispatcher("RscenicSpot.jsp").forward(req, resp);

  }
  /**
   * listManage 获取所有的景点属性管理员使用
   * @param req
   * @param resp
   * @throws ServletException
   * @throws IOException
   */
  protected void listManage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    List<ScenicSpot> scenicSpots = service.queryAllScenicSpot();
    req.setAttribute("scenicSpots" , scenicSpots);
    req.getRequestDispatcher("ScenicSpot.jsp").forward(req, resp);

  }

  /**
   * listByCity 获取所在城市的所有景点
   * @param req
   * @param resp
   * @throws ServletException
   * @throws IOException
   */
  protected void listByCity(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    String cityName = req.getParameter("cityName");
    List<ScenicSpot> scenicSpots = service.queryCityAllScenicSpot(cityName);
    req.setAttribute("scenicSpots" , scenicSpots);
    req.getRequestDispatcher("RscenicSpot.jsp").forward(req, resp);

  }

  /**
   * getEchat 显示echart页面的，城市所包含的景点个数
   * @param req
   * @param resp
   * @throws ServletException
   * @throws IOException
   */
  protected void getEchart(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    HashMap<String, Integer> hash = service.getCitysScenicCount();
    req.setAttribute("hash", hash);
    System.out.println(11121213);
    for (Integer h : hash.values()) {
      System.out.println(h);
    }
    for (String h : hash.keySet()) {
      System.out.println(h);
    }
    req.getRequestDispatcher("echat.jsp").forward(req, resp);

  }


}
