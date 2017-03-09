package edu.unh.rbooking.reservation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import edu.unh.rbooking.common.DTO;
import edu.unh.rbooking.common.GenericServiceImpl;
import edu.unh.rbooking.exception.RBookingException;
import edu.unh.rbooking.table.TableBO;
import edu.unh.rbooking.table.TableService;

public class ReservationServiceImpl extends GenericServiceImpl<ReservationBO, ReservationDO, Integer>implements ReservationService {

	private ReservationDAO reservationDAO;
	private TableService tableService;
	public ReservationServiceImpl(ReservationDAO serervationDAO, DTO<ReservationBO, ReservationDO> dto, TableService tableService) {
		super(serervationDAO, dto);
		this.reservationDAO = serervationDAO;
		this.tableService = tableService;
	}
	
	@Override
	@Transactional(value="coreTransactionManager")
	public boolean checkin(Integer reservationId, Integer tableId, Integer serverId) throws RBookingException {
		ReservationBO reservation = findById(reservationId);
		List<ReservationTableMappingBO> mapping = new ArrayList<ReservationTableMappingBO>();
		ReservationTableMappingBO reservationTableMappingBO = new ReservationTableMappingBO();
		reservationTableMappingBO.setReservation(reservation);
		
		TableBO table = tableService.findById(tableId);
		reservationTableMappingBO.setTable(table);
		
		mapping.add(reservationTableMappingBO);
		reservation.setReservationTableMappings(mapping);
		
		saveOrUpdate(reservation);
		return true;
	}
}
