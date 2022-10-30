package com.danei.travelling.test;

import com.danei.travelling.dao.ReservationDao;
import com.danei.travelling.dao.daoImp.ReservationDaoImp;
import com.danei.travelling.entity.Reservation;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @Describe:
 * @Author: wangdifu
 * @Date: 2022-1-11 , 0011 13:50
 * @Version: 1.0
 */
class ReservationDaoTest {

  private ReservationDao dao = new ReservationDaoImp();
  @Test
  void addReservation() {

    Reservation reservation = new Reservation("SY1002","王迪夫",1,"2022-01-10","A1-A");
    System.out.println(dao.addReservation(reservation));
  }

  @Test
  void deleteReservation() {
    System.out.println(dao.deleteReservation("SH-BJ10A1", "李建国"));
  }

  @Test
  void updateReservation() {


    Reservation reservation = new Reservation("SH-BJ10A1","李建国",1,"2022-01-10","A1-A");
    System.out.println(dao.updateReservation(reservation));
  }

  @Test
  void queryReservationById() {
    System.out.println(dao.queryReservationById("SY1002"));
  }

  @Test
  void queryAllReservation() {
    List<Reservation> reservations = dao.queryAllReservation();
    System.out.println(reservations.toString());
  }


  @Test
  void queryCustomerAllReservation() {

    System.out.println(dao.queryCustomerAllReservation("王迪夫").toString());;
  }

  @Test
  void queryCustomerReservationByType() {

    System.out.println(dao.queryCustomerReservationByType("王迪夫", 1).toString());
  }
}