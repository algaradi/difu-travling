package com.danei.travelling.servlet;

import com.danei.travelling.entity.Customer;
import com.danei.travelling.service.CustomerService;
import com.danei.travelling.service.serviceImp.CustomerServiceImp;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @Describe:
 * @Author: wangdifu
 * @Date: 2022-1-11 , 0011 0:22
 * @Version: 1.0
 */
public class CustomerServlet extends BaseServlet {
  private CustomerService service = new CustomerServiceImp();


  /**
   * regist 方法实现注册
   *
   * @param req
   * @param resp
   * @throws ServletException
   * @throws IOException
   */
  protected void regist(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    // 1 获取参数， 用户名和密码
    String custName = req.getParameter("custName");
    String password = req.getParameter("password");
    String custPhone = req.getParameter("custPhone");

    // 设置用户类型， 只能是2 ，表示该用户是顾客，管理员才有权限修改用户类型
    int type = 2;

//    确实是否有用户重名，有就返回注册失败 msg 为’该用户已经存在，可以登录，或用其他用户名注册‘
    Customer registCust = service.queryCustomerById(custName);
    String msg = "";
    if (registCust.getCustName() == null) {
      msg = "该用户已经存在，可以登录，或用其他用户名注册";
      // 把错误信息，和回显的表单项信息，保存到Request域中
      req.setAttribute("msg", msg);
      //   跳回注册页面
      req.getRequestDispatcher("regist.jsp").forward(req, resp);
    } else {
      //表示该用户数据库里不存在，则可以注册
      // 创建用户
      Customer customer = new Customer(custName, password, type, custPhone);
      //保存到数据库里
      boolean flag = service.addCustomer(customer);
      if (flag == false) {
        //注册失败
        msg = "注册失败！，请用别的用户名来注册";
        // 把错误信息，和回显的表单项信息，保存到Request域中
        req.setAttribute("msg", msg);
        //   跳回注册页面
        req.getRequestDispatcher("regist.jsp").forward(req, resp);
      } else {
        //  注册成功
        msg = "恭喜！注册成功";
        // 保存到Request域中
        req.setAttribute("msg", msg);
        //   跳回登录页面 ， 让用户进行登录
        req.getRequestDispatcher("login.jsp").forward(req, resp);
      }

    }


  }


  /**
   * login 方法实现登录
   *
   * @param req
   * @param resp
   * @throws ServletException
   * @throws IOException
   */
  @edu.umd.cs.findbugs.annotations.SuppressFBWarnings("J2EE_STORE_OF_NON_SERIALIZABLE_OBJECT_INTO_SESSION")
  protected void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    // 1 获取参数， 用户名和密码
    String custName = req.getParameter("custName");
    String password = req.getParameter("password");

    //2 查看数据库里改用户是否存在， 存在就登录成功，则登录失败msg为’用户名或密码错误‘
    String msg = "";
    Customer loginCust = service.queryCustomerByNameAndPassword(custName, password);
    if (loginCust.getCustName() == null || loginCust.getPassword() == null) {
      msg = "登录失败，用户名或密码错误";
      // 把错误信息，和回显的表单项信息，保存到Request域中
      req.setAttribute("msg", msg);
      //   跳回登录页面
      req.getRequestDispatcher("login.jsp").forward(req, resp);
    } else {
      // 登录成功
      // 保存用户登录的信息到Session域中
      req.getSession().setAttribute("cust", loginCust);
      // 跳到登录成功页面
      req.getRequestDispatcher("index1.jsp").forward(req, resp);
    }

  }


  /**
   * add 用户管理添加用户
   *
   * @param req
   * @param resp
   * @throws ServletException
   * @throws IOException
   */
  protected void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    // 1 获取参数， 用户名和密码
    String custName = req.getParameter("custName");
    String password = req.getParameter("password");
    String custPhone = req.getParameter("custPhone");
    String t = req.getParameter("type");
    int type = 2;
    try {
      // Integer转换，加try catch 避免出现错误信息
      type = Integer.parseInt(t);

    } catch (NumberFormatException e) {
      e.getMessage();
    }

    //2 查看数据库里改用户是否存在， 不存在就添加成功，则添加失败msg为’用户名已存在‘
    String msg = "";
    Customer cust = service.queryCustomerByNameAndPassword(custName, password);
    if (cust.getCustName() == custName) {
      msg = "用户名已存在";

    } else {
      //表示该用户数据库里不存在，则可以添加
      // 创建用户
      Customer customer = new Customer(custName, password, type, custPhone);
      //保存到数据库里
      boolean flag = service.addCustomer(customer);
      if (flag == false) {
        //添加失败
        msg = "添加失败！，请用别的用户名来注册";

      } else {
        //  添加成功
        msg = "添加成功！";

      }

    }
    // 保存到Request域中
    req.setAttribute("msg", msg);
    //   跳回添加用户页面
    req.getRequestDispatcher("customerServlet?action=list").forward(req, resp);
  }


  /**
   * edit 用户管理 修改用户信息
   * @param req
   * @param resp
   * @throws ServletException
   * @throws IOException
   */
  protected void edit(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    // 1 获取参数， 用户名和密码
    String custName = req.getParameter("custName");
    String password = req.getParameter("password");
    String custPhone = req.getParameter("custPhone");
    String t = req.getParameter("type");
    int type = 2;
    try {
      // Integer转换，加try catch 避免出现错误信息
      type = Integer.parseInt(t);

    } catch (NumberFormatException e) {
      e.getMessage();
    }

    Customer customer = new Customer(custName,password,type,custPhone);
    boolean flag = service.updateCustomer(customer);
    String msg = "";
    if(flag== false){
      msg="修改失败！";
      req.setAttribute("msg", msg);
      // 返回到用户修改页面
      req.getRequestDispatcher("customer_modify.jsp").forward(req, resp);
    }else{
      msg = "修改成功！";
      req.setAttribute("msg", msg);
      // 返回到用户修改页面
      req.getRequestDispatcher("customer_modify.jsp").forward(req, resp);
    }

  }


  /**
   * delete 用户管理 删除用户,由管理员能实现
   * @param req
   * @param resp
   * @throws ServletException
   * @throws IOException
   */
  protected void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    String custName = req.getParameter("custName");

    // 获取会话中，当前的用户信息，确定是否管理员 ， 是继续删除，则返回不能删
   Customer cust =  (Customer)req.getSession().getAttribute("cust");
   String msg = "";
   if(cust.getType() == 1){
     boolean flag  = service.deleteCustomer(custName);
     if(flag == true){
       msg = "删除成功";


     }else{
       msg = "删除失败";

     }

   }else {
     msg = "对不起！ 您没有权限删这条信息";
   }
    // 保存到request 域种
    req.setAttribute("msg",msg);
    // 返回到原来的页面
    req.getRequestDispatcher("customerServlet?action=list").forward(req,resp);


  }

  /**
   * list 用户管理 列出所有的用户信息
   * @param req
   * @param resp
   * @throws ServletException
   * @throws IOException
   */
  protected void list(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    System.out.println("11111111111111111111111111111111111111111111111111111");
    List<Customer> customers = service.queryAllCustomer();
    //保存到request域种
    req.setAttribute("customers",customers);
    req.getRequestDispatcher("customer.jsp").forward(req,resp);

  }



  /**
   * listCN 用户管理 列出指定名的用户信息
   * @param req
   * @param resp
   * @throws ServletException
   * @throws IOException
   */
  protected void listCN(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    String custName = req.getParameter("custName");
    System.out.println("11111111111111111111111111111111111111111111111111111");
    Customer c = service.queryCustomerById(custName);
    List<Customer> customers = new ArrayList<Customer>();
    customers.add(c);
    //保存到request域种
    req.setAttribute("customers",customers);
    req.getRequestDispatcher("customer.jsp").forward(req,resp);

  }

  /**
   * editMe 用户修改本人信息，比如手机号， 或者密码，无权限修改自己的用户类型
   * @param req
   * @param resp
   * @throws ServletException
   * @throws IOException
   */
  protected void editMe(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    // 1 获取参数， 用户名和密码
    // 获取会话中，当前的用户信息，更具当前的用户信息来修改当前的信息，这样安全一点，避免修改他人信息的发生
    Customer cust =  (Customer)req.getSession().getAttribute("cust");
    String password = req.getParameter("password");
    String custPhone = req.getParameter("custPhone");
    int type = 2; // 顾客无权修改自己的用户类型


    Customer customer = new Customer(cust.getCustName(),password,type,custPhone);
    boolean flag = service.updateCustomer(customer);
    String msg = "";
    if(flag== false){
      msg="个人信息修改失败！";
      req.setAttribute("msg", msg);
      // 返回到修改个人信息页面
      req.getRequestDispatcher("Mycustomer_modify.jsp").forward(req, resp);
    }else{
      msg = "个人信息修改成功！";
      req.setAttribute("msg", msg);
      // 返回到修改个人信息页面
      req.getRequestDispatcher("login.jsp").forward(req, resp);
    }



  }





}
