/**
 * 
 */
package com.spring.mvc.vo;

/**
 * @author Vinaya Nayak
 * Jul 26, 2017
 * LeaveDetailsVo.java
 */
public class LeaveDetailsVo {
	
	private String startdate;
	private String enddate;
	private String leaveType;
	private String reason;
	
	
	public String getLeaveType() {
		return leaveType;
	}
	public void setLeaveType(String leaveType) {
		this.leaveType = leaveType;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public String getStartdate() {
		return startdate;
	}
	public void setStartdate(String startdate) {
		this.startdate = startdate;
	}
	public String getEnddate() {
		return enddate;
	}
	public void setEnddate(String enddate) {
		this.enddate = enddate;
	}
	
	

}
