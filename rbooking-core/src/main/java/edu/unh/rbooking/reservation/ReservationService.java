package edu.unh.rbooking.reservation;

import edu.unh.rbooking.common.GenericService;
import edu.unh.rbooking.exception.RBookingException;

public interface ReservationService extends GenericService<ReservationBO, ReservationDO, Integer>{
	public boolean checkin(Integer reservationId, Integer tableId, Integer serverId) throws RBookingException;
}
