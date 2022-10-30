package com.danei.travelling.test;

import com.danei.travelling.dao.CustomerDao;
import com.danei.travelling.dao.daoImp.CustomerDaoImp;
import com.danei.travelling.entity.Customer;
import org.junit.jupiter.api.Test;

import java.time.temporal.ChronoUnit;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @Describe:
 * @Author: wangdifu
 * @Date: 2022-1-11 , 0011 10:48
 * @Version: 1.0
 */
class CustomerDaoTest {
private CustomerDao dao = new CustomerDaoImp();

  @Test
  void addCustomer() {
     Customer customer = new Customer("ahmed","123456",2,"181646564");
    System.out.println(dao.addCustomer(customer));

  }

  @Test
  void deleteCustomer() {
    System.out.println(dao.deleteCustomer("ahmed"));

  }

  @Test
  void updateCustomer() {

    Customer customer = new Customer("ahmed","111111",2,"181646564");
    System.out.println(dao.updateCustomer(customer));
  }

  @Test
  void queryCarById() {
    System.out.println(dao.queryCustomerById("王迪夫"));
  }

  @Test
  void queryAllCar() {

    List<Customer> customers = dao.queryAllCustomer();
    System.out.println(customers.toString());
  }

  @Test
  void queryCustomerByNameAndPassword() {

    Customer customer = dao.queryCustomerByNameAndPassword("wang", "111111");

  }
}