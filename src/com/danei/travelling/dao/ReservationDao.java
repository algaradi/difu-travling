package com.danei.travelling.dao;

import com.danei.travelling.entity.Flight;
import com.danei.travelling.entity.Reservation;

import java.util.List;

/**
 * @Describe:
 * @Author: wangdifu
 * @Date: 2022-1-11 , 0011 0:15
 * @Version: 1.0
 */
public interface ReservationDao {


  boolean addReservation( Reservation reservation);
  boolean deleteReservation(String resvKey,String custName);
  boolean updateReservation(Reservation reservation);

  Reservation queryReservationById(String resvKey);
  List<Reservation> queryAllReservation();

  List<Reservation> queryCustomerAllReservation(String custName);
  List<Reservation> queryCustomerReservationByType(String custName,int type);
}
