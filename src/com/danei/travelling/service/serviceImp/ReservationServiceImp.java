package com.danei.travelling.service.serviceImp;

import com.danei.travelling.dao.ReservationDao;
import com.danei.travelling.dao.daoImp.ReservationDaoImp;
import com.danei.travelling.entity.Reservation;
import com.danei.travelling.service.ReservationService;

import java.util.List;

/**
 * @Describe:
 * @Author: wangdifu
 * @Date: 2022-1-11 , 0011 14:58
 * @Version: 1.0
 */
public class ReservationServiceImp implements ReservationService {

  private ReservationDao dao = new ReservationDaoImp();
  @Override
  public boolean addReservation(Reservation reservation) {
    return dao.addReservation(reservation);
  }

  @Override
  public boolean deleteReservation(String resvKey, String custName) {
    return dao.deleteReservation(resvKey,custName);
  }

  @Override
  public boolean updateReservation(Reservation reservation) {
    return dao.updateReservation(reservation);
  }

  @Override
  public Reservation queryReservationById(String resvKey) {
    return dao.queryReservationById(resvKey);
  }

  @Override
  public List<Reservation> queryAllReservation() {
    return dao.queryAllReservation();
  }

  @Override
  public List<Reservation> queryCustomerAllReservation(String custName) {
    return dao.queryCustomerAllReservation(custName);
  }

  @Override
  public List<Reservation> queryCustomerReservationByType(String custName, int type) {
    return queryCustomerReservationByType(custName,type);
  }
}
