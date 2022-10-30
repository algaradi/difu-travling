package com.danei.travelling.dao.daoImp;

import com.danei.travelling.dao.BaseDao;
import com.danei.travelling.dao.ReservationDao;
import com.danei.travelling.entity.Hotel;
import com.danei.travelling.entity.Reservation;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @Describe:
 * @Author: wangdifu
 * @Date: 2022-1-11 , 0011 12:22
 * @Version: 1.0
 */
public class ReservationDaoImp implements ReservationDao {
  @Override
  public boolean addReservation(Reservation reservation) {
   String sql = "insert into reservation values(?,?,?,?,?)";
   Object[]  obj = new Object[5];
   obj[0] = reservation.getResvKey();
   obj[1] = reservation.getCustName();
   obj[2] = reservation.getType();
   obj[3] = reservation.getResDate();
   obj[4] = reservation.getNumber();

    return BaseDao.update(sql,obj);
  }

  @Override
  public boolean deleteReservation(String resvKey ,String custName) {
   String sql = "delete from reservation where resvKey = ? and custName=?";


    return BaseDao.update(sql,resvKey,custName);
  }

  @Override
  public boolean updateReservation(Reservation reservation) {
    String sql = "update reservation set custName = ? , type =? ,resDate=? , number=? where resvKey = ?";

    Object[]  obj = new Object[5];
    obj[0] = reservation.getCustName();
    obj[1] = reservation.getType();
    obj[2] = reservation.getResDate();
    obj[3] = reservation.getNumber();
    obj[4] = reservation.getResvKey();
    return BaseDao.update(sql,obj);
  }

  @Override
  public Reservation queryReservationById(String resvKey ) {
    String sql = "select * from reservation where resvKey= '"+resvKey+"'";

    Reservation reservation = new Reservation();
    ResultSet rs = BaseDao.select(sql);

    if (rs != null) {
      try {
        while (rs.next()) {

          reservation.setResvKey(rs.getString(1));
          reservation.setCustName(rs.getString(2));
          reservation.setType(rs.getInt(3));
          reservation.setResDate(rs.getString(4));
          reservation.setNumber(rs.getString(5));

        }
      } catch (SQLException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }

    }
    return reservation;
  }

  @Override
  public List<Reservation> queryAllReservation() {
String sql = "select * from reservation ";
List<Reservation> list = new ArrayList<Reservation>();
    ResultSet rs = BaseDao.select(sql);

    if (rs != null) {
      try {
        while (rs.next()) {
          Reservation reservation = new Reservation();
          reservation.setResvKey(rs.getString(1));
          reservation.setCustName(rs.getString(2));
          reservation.setType(rs.getInt(3));
          reservation.setResDate(rs.getString(4));
          reservation.setNumber(rs.getString(5));
list.add(reservation);
        }
      } catch (SQLException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }

    }
    return list;
  }

  @Override
  public List<Reservation> queryCustomerAllReservation(String custName) {
    String sql = "select * from reservation where custName='"+custName+"'";
    List<Reservation> list = new ArrayList<Reservation>();
    ResultSet rs = BaseDao.select(sql);

    if (rs != null) {
      try {
        while (rs.next()) {
          Reservation reservation = new Reservation();
          reservation.setResvKey(rs.getString(1));
          reservation.setCustName(rs.getString(2));
          reservation.setType(rs.getInt(3));
          reservation.setResDate(rs.getString(4));
          reservation.setNumber(rs.getString(5));
          list.add(reservation);
        }
      } catch (SQLException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }

    }
    return list;
  }

  @Override
  public List<Reservation> queryCustomerReservationByType(String custName , int type) {
    String sql = "select * from reservation where custName='"+custName+"' and type = "+type;
    List<Reservation> list = new ArrayList<Reservation>();
    ResultSet rs = BaseDao.select(sql);

    if (rs != null) {
      try {
        while (rs.next()) {
          Reservation reservation = new Reservation();
          reservation.setResvKey(rs.getString(1));
          reservation.setCustName(rs.getString(2));
          reservation.setType(rs.getInt(3));
          reservation.setResDate(rs.getString(4));
          reservation.setNumber(rs.getString(5));
          list.add(reservation);
        }
      } catch (SQLException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }

    }
    return list;
  }
}
