package edu.unh.rbooking.timing;
// default package
// Generated Dec 3, 2016 3:39:47 PM by Hibernate Tools 5.2.0.Beta1

/**
 * Timing generated by hbm2java
 */
public class TimingDO implements java.io.Serializable {

	private Integer id;
	private String day;
	private String startTime;
	private String endTime;

	public TimingDO() {
	}

	public TimingDO(String day, String startTime, String endTime) {
		this.day = day;
		this.startTime = startTime;
		this.endTime = endTime;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDay() {
		return this.day;
	}

	public void setDay(String day) {
		this.day = day;
	}

	public String getStartTime() {
		return this.startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return this.endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

}
