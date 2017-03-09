package edu.unh.rbooking.timing;

import edu.unh.rbooking.common.DTO;
import edu.unh.rbooking.common.GenericServiceImpl;

public class TimingServiceImpl extends GenericServiceImpl<TimingBO, TimingDO, Integer>implements TimingService {

	private TimingDAO timingDAO;
	
	public TimingServiceImpl(TimingDAO timingDAO, DTO<TimingBO, TimingDO> dto) {
		super(timingDAO, dto);
		this.timingDAO = timingDAO;
	}
	
	
}
