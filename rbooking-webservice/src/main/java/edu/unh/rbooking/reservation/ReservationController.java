package edu.unh.rbooking.reservation;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import edu.unh.rbooking.common.GenericControllerImpl;
import edu.unh.rbooking.customer.CustomerService;
import edu.unh.rbooking.exception.RBookingException;

@Path("/reservation")
public class ReservationController extends GenericControllerImpl<ReservationBO, ReservationDO, Integer>{
	
	private final ReservationService reservationService;
	private final CustomerService customerService;
	
	public ReservationController(ReservationService reservationService, CustomerService customerService) {
		super(reservationService);		
		this.reservationService = reservationService;
		this.customerService = customerService;
	}

	@Path("/checkin/reservationId/{reservationId}/tableId/{tableId}/serverId/{serverId}")
	@POST
	public boolean checkin(@PathParam("reservationId") Integer reservationId, @PathParam("tableId") Integer tableId, @PathParam("serverId") Integer serverId) throws RBookingException
	{
		return reservationService.checkin(reservationId, tableId, serverId);
	}
}
