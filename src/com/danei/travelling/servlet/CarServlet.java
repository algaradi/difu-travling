package com.danei.travelling.servlet;

import com.danei.travelling.entity.Car;
import com.danei.travelling.entity.Customer;
import com.danei.travelling.service.CarService;
import com.danei.travelling.service.serviceImp.CarServiceImp;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @Describe:
 * @Author: wangdifu
 * @Date: 2022-1-11 , 0011 16:24
 * @Version: 1.0
 */
public class CarServlet extends BaseServlet {

  private CarService service =  new CarServiceImp();

  /**
   *  add 车管理， 添加方法
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
      String carNum = req.getParameter("carNum");
      String p = req.getParameter("price");
      Double price = 50.0;
      try {
        price = Double.parseDouble(p);
      } catch (NumberFormatException e) {
        e.getMessage();
      }
      String cityName = req.getParameter("cityName");
      String driver = req.getParameter("driver");

      Car car = new Car(carNum, price, cityName, driver);
      boolean flag = service.addCar(car);

      if (flag == true) {
        msg = "添加成功";
      } else {
        msg = "添加失败";
      }

    }else{
      msg = "本用户不是管理员， 没有权限添加信息";
    }
    req.setAttribute("msg", msg);
    //返回到原来的页面
    req.getRequestDispatcher("CarServlet?action=list").forward(req, resp);

  }


  /**
   * edit 车管理，修改车信息，如司机名，价格
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
      String carNum = req.getParameter("carNum");
      String p = req.getParameter("price");
      Double price = 50.0;
      try {
        price = Double.parseDouble(p);
      } catch (NumberFormatException e) {
        e.getMessage();
      }
      String cityName = req.getParameter("cityName");
      String driver = req.getParameter("driver");

      Car car = new Car(carNum, price, cityName, driver);
      boolean flag = service.updateCar(car);

      if (flag == true) {
        msg = "修改成功";
      } else {
        msg = "修改失败,司机没注册";
      }

    }else{
      msg = "本用户不是管理员， 没有权限修改信息";
    }
    req.setAttribute("msg", msg);
    //返回到原来的页面
    req.getRequestDispatcher("car_modify.jsp").forward(req, resp);

  }


  /**
   * delete 车管理， 删除车信息
   * @param req
   * @param resp
   * @throws ServletException
   * @throws IOException
   */
  protected void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    String carNum = req.getParameter("carNum");
    // 获取会话中，当前的用户信息，确定是否管理员 ， 是继续操作，则返回不能操作，没有权限
    Customer cust =  (Customer)req.getSession().getAttribute("cust");
    String msg = "";
    if(cust.getType() == 1){
      boolean flag = service.deleteCar(carNum);
      if(flag == true){
        msg="修改成功";
      }else{
        msg = "修改失败";
      }
    }else{
      msg = "本用户不是管理员，没权限删除";
    }
    req.setAttribute("msg", msg);
    //返回到原来的页面
    req.getRequestDispatcher("CarServlet?action=list").forward(req, resp);

  }


  /**
   * list 获取所有车的信息
   * @param req
   * @param resp
   * @throws ServletException
   * @throws IOException
   */
  protected void list(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    List<Car> cars = service.queryAllCar();
    req.setAttribute("cars",cars);
    req.getRequestDispatcher("car.jsp").forward(req,resp);

  }

  /**
   * rlist 获取所有车信息，顾客使用实现查找以及预定
   * @param req
   * @param resp
   * @throws ServletException
   * @throws IOException
   */
  protected void rlist(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    List<Car> cars = service.queryAllCar();
    req.setAttribute("cars",cars);
    req.getRequestDispatcher("Rcar.jsp").forward(req,resp);

  }

  /**
   * listByCity 获取指定城市的所有车信息
   * @param req
   * @param resp
   * @throws ServletException
   * @throws IOException
   */
  protected void listBycity(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    String cityName = req.getParameter("cityName");
    List<Car> carsCity = service.queryCityAllCar(cityName);
    req.setAttribute("cars",carsCity);
    req.getRequestDispatcher("Rcar.jsp").forward(req,resp);

  }

}
