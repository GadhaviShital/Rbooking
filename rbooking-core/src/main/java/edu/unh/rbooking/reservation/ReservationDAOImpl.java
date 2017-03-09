package edu.unh.rbooking.reservation;

import java.util.List;

import edu.unh.rbooking.common.GenericDaoHibernate;
import edu.unh.rbooking.exception.DAOException;

public class ReservationDAOImpl extends GenericDaoHibernate<ReservationDO, Integer> implements ReservationDAO {

	public ReservationDAOImpl() {
		super(ReservationDO.class);
	}
}
