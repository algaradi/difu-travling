package com.danei.travelling.dao;

import com.danei.travelling.entity.Car;
import com.danei.travelling.entity.Customer;

import java.util.List;

/**
 * @Describe:
 * @Author: wangdifu
 * @Date: 2022-1-11 , 0011 0:13
 * @Version: 1.0
 */
public interface CustomerDao {


  boolean addCustomer(Customer customer);
  boolean deleteCustomer(String custName);
  boolean updateCustomer(Customer customer);

  Customer queryCustomerById(String custName);
  List<Customer> queryAllCustomer();

  Customer queryCustomerByNameAndPassword(String custName , String password);
}
