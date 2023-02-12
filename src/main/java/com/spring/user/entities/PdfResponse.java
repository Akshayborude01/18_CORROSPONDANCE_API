package com.spring.user.entities;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PDF_RESPONSE")
public class PdfResponse {

	@Id
	@GeneratedValue
	private Integer PdfId;
	private String email;
	private long moNumber;
	private String gender;
	private LocalDate dob;
	private long caseNum;
	private String holderName;
	private long holderSsn;
	private String planName;
	private String planStatus;
	private LocalDate planStartDate;
	private LocalDate planEndDate;
	private long benfitAmount;
	private String deniedReason;
	/**
	 * @return the pdfId
	 */
	public Integer getPdfId() {
		return PdfId;
	}
	/**
	 * @param pdfId the pdfId to set
	 */
	public void setPdfId(Integer pdfId) {
		PdfId = pdfId;
	}
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * @return the moNumber
	 */
	public long getMoNumber() {
		return moNumber;
	}
	/**
	 * @param moNumber the moNumber to set
	 */
	public void setMoNumber(long moNumber) {
		this.moNumber = moNumber;
	}
	/**
	 * @return the gender
	 */
	public String getGender() {
		return gender;
	}
	/**
	 * @param gender the gender to set
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}
	/**
	 * @return the dob
	 */
	public LocalDate getDob() {
		return dob;
	}
	/**
	 * @param dob the dob to set
	 */
	public void setDob(LocalDate dob) {
		this.dob = dob;
	}
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
	 * @return the holderName
	 */
	public String getHolderName() {
		return holderName;
	}
	/**
	 * @param holderName the holderName to set
	 */
	public void setHolderName(String holderName) {
		this.holderName = holderName;
	}
	/**
	 * @return the holderSsn
	 */
	public long getHolderSsn() {
		return holderSsn;
	}
	/**
	 * @param holderSsn the holderSsn to set
	 */
	public void setHolderSsn(long holderSsn) {
		this.holderSsn = holderSsn;
	}
	/**
	 * @return the planName
	 */
	public String getPlanName() {
		return planName;
	}
	/**
	 * @param planName the planName to set
	 */
	public void setPlanName(String planName) {
		this.planName = planName;
	}
	/**
	 * @return the planStatus
	 */
	public String getPlanStatus() {
		return planStatus;
	}
	/**
	 * @param planStatus the planStatus to set
	 */
	public void setPlanStatus(String planStatus) {
		this.planStatus = planStatus;
	}
	/**
	 * @return the planStartDate
	 */
	public LocalDate getPlanStartDate() {
		return planStartDate;
	}
	/**
	 * @param planStartDate the planStartDate to set
	 */
	public void setPlanStartDate(LocalDate planStartDate) {
		this.planStartDate = planStartDate;
	}
	/**
	 * @return the planEndDate
	 */
	public LocalDate getPlanEndDate() {
		return planEndDate;
	}
	/**
	 * @param planEndDate the planEndDate to set
	 */
	public void setPlanEndDate(LocalDate planEndDate) {
		this.planEndDate = planEndDate;
	}
	/**
	 * @return the benfitAmount
	 */
	public long getBenfitAmount() {
		return benfitAmount;
	}
	/**
	 * @param benfitAmount the benfitAmount to set
	 */
	public void setBenfitAmount(long benfitAmount) {
		this.benfitAmount = benfitAmount;
	}
	/**
	 * @return the deniedReason
	 */
	public String getDeniedReason() {
		return deniedReason;
	}
	/**
	 * @param deniedReason the deniedReason to set
	 */
	public void setDeniedReason(String deniedReason) {
		this.deniedReason = deniedReason;
	}
	@Override
	public String toString() {
		return "PdfResponse [PdfId=" + PdfId + ", email=" + email + ", moNumber=" + moNumber + ", gender=" + gender
				+ ", dob=" + dob + ", caseNum=" + caseNum + ", holderName=" + holderName + ", holderSsn=" + holderSsn
				+ ", planName=" + planName + ", planStatus=" + planStatus + ", planStartDate=" + planStartDate
				+ ", planEndDate=" + planEndDate + ", benfitAmount=" + benfitAmount + ", deniedReason=" + deniedReason
				+ "]";
	}
	public PdfResponse(Integer pdfId, String email, long moNumber, String gender, LocalDate dob, long caseNum,
			String holderName, long holderSsn, String planName, String planStatus, LocalDate planStartDate,
			LocalDate planEndDate, long benfitAmount, String deniedReason) {
		super();
		PdfId = pdfId;
		this.email = email;
		this.moNumber = moNumber;
		this.gender = gender;
		this.dob = dob;
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
	public PdfResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
