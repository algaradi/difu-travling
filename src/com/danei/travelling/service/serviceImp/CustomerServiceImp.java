package com.danei.travelling.service.serviceImp;

import com.danei.travelling.dao.CustomerDao;
import com.danei.travelling.dao.daoImp.CustomerDaoImp;
import com.danei.travelling.entity.Customer;
import com.danei.travelling.service.CustomerService;

import java.util.List;

/**
 * @Describe:
 * @Author: wangdifu
 * @Date: 2022-1-11 , 0011 14:48
 * @Version: 1.0
 */
public class CustomerServiceImp implements CustomerService {

  private CustomerDao dao = new CustomerDaoImp();
  @Override
  public boolean addCustomer(Customer customer) {
    return dao.addCustomer(customer);
  }

  @SuppressWarnings("SpellCheckingInspection")
  @Override
  public boolean deleteCustomer(String custName) {
    return dao.deleteCustomer(custName);
  }

  @Override
  public boolean updateCustomer(Customer customer) {
    return dao.updateCustomer(customer);
  }

  @Override
  public Customer queryCustomerById(String custName) {
    return dao.queryCustomerById(custName);
  }

  @Override
  public List<Customer> queryAllCustomer() {
    return dao.queryAllCustomer();
  }

  @Override
  public Customer queryCustomerByNameAndPassword(String custName, String password) {
    return dao.queryCustomerByNameAndPassword(custName,password);
  }
}
