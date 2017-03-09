package edu.unh.rbooking.timing;

import edu.unh.rbooking.common.GenericDaoHibernate;

public class TimingDAOImpl extends GenericDaoHibernate<TimingDO, Integer> implements TimingDAO {

	public TimingDAOImpl() {
		super(TimingDO.class);
	}
}
