package edu.unh.rbooking.table;

import edu.unh.rbooking.common.DTO;
import edu.unh.rbooking.common.GenericServiceImpl;

public class TableServiceImpl extends GenericServiceImpl<TableBO, TableDO, Integer>implements TableService {

	private TableDAO tableDAO;
	
	public TableServiceImpl(TableDAO tableDAO, DTO<TableBO, TableDO> dto) {
		super(tableDAO, dto);
		this.tableDAO = tableDAO;
	}
	
	
}
