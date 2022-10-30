package com.danei.travelling.dao.daoImp;

import com.danei.travelling.dao.BaseDao;
import com.danei.travelling.dao.CustomerDao;
import com.danei.travelling.entity.Customer;

import javax.swing.text.DefaultEditorKit;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @Describe:
 * @Author: wangdifu
 * @Date: 2022-1-11 , 0011 10:32
 * @Version: 1.0
 */
public class CustomerDaoImp implements CustomerDao {
  @Override
  public boolean addCustomer(Customer customer) {
  String sql = "insert into customer values(?,?,?,?)";
    Object[] obj = new Object[4];
    obj[0] = customer.getCustName();
    obj[1] = customer.getPassword();
    obj[2] = customer.getType();
    obj[3] = customer.getCustPhone();
    return BaseDao.update(sql,obj);
  }

  @Override
  public boolean deleteCustomer(String custName) {
    String sql = "delete from customer where custName = ?";

    return BaseDao.update(sql,custName);
  }

  @Override
  public boolean updateCustomer(Customer customer) {
    String sql = "update customer set password = ?, type = ? ,custPhone = ? where custName = ?";
    Object[] obj = new Object[4];
    obj[0] = customer.getPassword();
    obj[1] = customer.getType();
    obj[2] = customer.getCustPhone();
    obj[3] = customer.getCustName();
    return BaseDao.update(sql,obj);
  }

  @Override
  public Customer queryCustomerById(String custName) {
    String sql = "select * from customer where custName = '"+custName+"'";
    Customer customer = new Customer();
    ResultSet rs = BaseDao.select(sql);

    if (rs != null) {
      try {
        while (rs.next()) {

          customer.setCustName(rs.getString(1));
          customer.setPassword(rs.getString(2));
          customer.setType(rs.getInt(3));
          customer.setCustPhone(rs.getString(4));

        }
      } catch (SQLException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }

    }
    return customer;
  }

  @Override
  public List<Customer> queryAllCustomer() {
     String sql = "select * from customer ";
     List<Customer> list = new ArrayList<Customer>();
    ResultSet rs = BaseDao.select(sql);

    if (rs != null) {
      try {
        while (rs.next()) {

          Customer customer= new Customer();
          customer.setCustName(rs.getString(1));
          customer.setPassword(rs.getString(2));
          customer.setType(rs.getInt(3));
          customer.setCustPhone(rs.getString(4));
          list.add(customer);
        }
      } catch (SQLException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }

    }
    return list;
  }

  @Override
  public Customer queryCustomerByNameAndPassword(String custName, String password) {
    String sql = "select * from customer where custName = '"+custName+"' and password= '"+password+"'";
    Customer customer = new Customer();
    ResultSet rs = BaseDao.select(sql);

    if (rs != null) {
      try {
        while (rs.next()) {

          customer.setCustName(rs.getString(1));
          customer.setPassword(rs.getString(2));
          customer.setType(rs.getInt(3));
          customer.setCustPhone(rs.getString(4));

        }
      } catch (SQLException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }

    }
    return customer;
  }
}
