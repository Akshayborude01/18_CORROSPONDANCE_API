package com.spring.user.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "DC_CASES")

public class DcCaseEntity {
	
	@Id
	@GeneratedValue
	private long caseNum;
	private Integer planId;
	private Integer appId;
	/**
	 * @return the caseNum
	 */
	public long getCaseNum() {
		return caseNum;
	}
	/**
	 * @param caseNum the caseNum to set
	 */
	public void setCaseNum(long caseNum) {
		this.caseNum = caseNum;
	}
	/**
	 * @return the planId
	 */
	public Integer getPlanId() {
		return planId;
	}
	/**
	 * @param planId the planId to set
	 */
	public void setPlanId(Integer planId) {
		this.planId = planId;
	}
	/**
	 * @return the appId
	 */
	public Integer getAppId() {
		return appId;
	}
	/**
	 * @param appId the appId to set
	 */
	public void setAppId(Integer appId) {
		this.appId = appId;
	}
	@Override
	public String toString() {
		return "DcCaseEntity [caseNum=" + caseNum + ", planId=" + planId + ", appId=" + appId + "]";
	}
	public DcCaseEntity(long caseNum, Integer planId, Integer appId) {
		super();
		this.caseNum = caseNum;
		this.planId = planId;
		this.appId = appId;
	}
	public DcCaseEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	
}
