package com.spring.user.entities;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table( name = "ELIGIBILITY_RESPONSE")
public class EligibilityResponse {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer edTraceId;
	private long caseNum;
	private String holderName;
	private long holderSsn;
	private String planName;
	private String planStatus;
	private LocalDate planStartDate;
	private LocalDate planEndDate;
	private long benfitAmount;
	private String deniedReason;

	public Integer getEdTraceId() {
		return edTraceId;
	}

	public void setEdTraceId(Integer edTraceId) {
		this.edTraceId = edTraceId;
	}

	public long getCaseNum() {
		return caseNum;
	}

	public void setCaseNum(long caseNum) {
		this.caseNum = caseNum;
	}

	public String getHolderName() {
		return holderName;
	}

	public void setHolderName(String holderName) {
		this.holderName = holderName;
	}

	public long getHolderSsn() {
		return holderSsn;
	}

	public void setHolderSsn(long holderSsn) {
		this.holderSsn = holderSsn;
	}

	public String getPlanName() {
		return planName;
	}

	public void setPlanName(String planName) {
		this.planName = planName;
	}

	public String getPlanStatus() {
		return planStatus;
	}

	public void setPlanStatus(String planStatus) {
		this.planStatus = planStatus;
	}

	public LocalDate getPlanStartDate() {
		return planStartDate;
	}

	public void setPlanStartDate(LocalDate planStartDate) {
		this.planStartDate = planStartDate;
	}

	public LocalDate getPlanEndDate() {
		return planEndDate;
	}

	public void setPlanEndDate(LocalDate planEndDate) {
		this.planEndDate = planEndDate;
	}

	public long getBenfitAmount() {
		return benfitAmount;
	}

	public void setBenfitAmount(long benfitAmount) {
		this.benfitAmount = benfitAmount;
	}

	public String getDeniedReason() {
		return deniedReason;
	}

	public void setDeniedReason(String deniedReason) {
		this.deniedReason = deniedReason;
	}

	@Override
	public String toString() {
		return "EligibilityDetails [edTraceId=" + edTraceId + ", caseNum=" + caseNum + ", holderName=" + holderName
				+ ", holderSsn=" + holderSsn + ", planName=" + planName + ", planStatus=" + planStatus
				+ ", planStartDate=" + planStartDate + ", planEndDate=" + planEndDate + ", benfitAmount=" + benfitAmount
				+ ", deniedReason=" + deniedReason + "]";
	}

	public EligibilityResponse(Integer edTraceId, long caseNum, String holderName, long holderSsn, String planName,
			String planStatus, LocalDate planStartDate, LocalDate planEndDate, long benfitAmount, String deniedReason) {
		super();
		this.edTraceId = edTraceId;
		this.caseNum = caseNum;
		this.holderName = holderName;
		this.holderSsn = holderSsn;
		this.planName = planName;
		this.planStatus = planStatus;
		this.planStartDate = planStartDate;
		this.planEndDate = planEndDate;
		this.benfitAmount = benfitAmount;
		this.deniedReason = deniedReason;
	}

	public EligibilityResponse() {
		super();

	}

}
