package edu.unh.rbooking.table;

import javax.ws.rs.Path;

import edu.unh.rbooking.common.GenericControllerImpl;

@Path("/table")
public class TableController extends GenericControllerImpl<TableBO, TableDO, Integer>{
	public TableController(TableService tableService) {
		super(tableService);		
	}
}
