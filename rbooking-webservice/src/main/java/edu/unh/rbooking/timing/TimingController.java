package edu.unh.rbooking.timing;

import javax.ws.rs.Path;

import edu.unh.rbooking.common.GenericControllerImpl;

@Path("/timing")
public class TimingController extends GenericControllerImpl<TimingBO, TimingDO, Integer>{
	public TimingController(TimingService timingService) {
		super(timingService);		
	}
}
