package com.danei.travelling.service;

import com.danei.travelling.entity.Customer;

import java.util.List;

/**
 * @Describe:
 * @Author: wangdifu
 * @Date: 2022-1-11 , 0011 0:18
 * @Version: 1.0
 */
public interface CustomerService {


  boolean addCustomer(Customer customer);
  boolean deleteCustomer(String custName);
  boolean updateCustomer(Customer customer);

  Customer queryCustomerById(String custName);
  List<Customer> queryAllCustomer();

  Customer queryCustomerByNameAndPassword(String custName , String password);
}
