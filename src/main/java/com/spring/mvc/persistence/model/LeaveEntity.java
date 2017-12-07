/**
 * 
 */
package com.spring.mvc.persistence.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @author Vinaya Nayak
 * Jul 25, 2017
 * LeaveEntity.java
 */
@Entity
@Table(name = "LEAVE_MST")
public class LeaveEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "LEAVE_ID" , nullable=false)
	private int leaveId;
	
	@Temporal(TemporalType.DATE)
	 @Column(name = "START_DATE")
	private Date startDate;
	
	@Temporal(TemporalType.DATE)
	 @Column(name = "END_DATE")
	private Date endDate;
	
	 @Column(name = "LEAVE_TYPE")
	private String leaveType;
	
	@Column(name = "REASON")
	@Lob
	private String reason;
	
	@OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ACCOUNT_ID")
	// @PrimaryKeyJoinColumn
	private Account account;

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public int getLeaveId() {
		return leaveId;
	}

	public void setLeaveId(int leaveId) {
		this.leaveId = leaveId;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

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
	
}
