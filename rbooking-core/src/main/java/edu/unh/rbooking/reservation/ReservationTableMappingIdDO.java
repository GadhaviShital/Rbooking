package edu.unh.rbooking.reservation;
// default package
// Generated Dec 3, 2016 3:39:47 PM by Hibernate Tools 5.2.0.Beta1

/**
 * ReservationTableMappingId generated by hbm2java
 */
public class ReservationTableMappingIdDO implements java.io.Serializable {

	private int reservationId;
	private int tableId;

	public ReservationTableMappingIdDO() {
	}

	public ReservationTableMappingIdDO(int reservationId, int tableId) {
		this.reservationId = reservationId;
		this.tableId = tableId;
	}

	public int getReservationId() {
		return this.reservationId;
	}

	public void setReservationId(int reservationId) {
		this.reservationId = reservationId;
	}

	public int getTableId() {
		return this.tableId;
	}

	public void setTableId(int tableId) {
		this.tableId = tableId;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof ReservationTableMappingIdDO))
			return false;
		ReservationTableMappingIdDO castOther = (ReservationTableMappingIdDO) other;

		return (this.getReservationId() == castOther.getReservationId())
				&& (this.getTableId() == castOther.getTableId());
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + this.getReservationId();
		result = 37 * result + this.getTableId();
		return result;
	}

}
