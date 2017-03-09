package edu.unh.rbooking.table;

import edu.unh.rbooking.common.GenericDaoHibernate;

public class TableDAOImpl extends GenericDaoHibernate<TableDO, Integer> implements TableDAO {

	public TableDAOImpl() {
		super(TableDO.class);
	}
}
