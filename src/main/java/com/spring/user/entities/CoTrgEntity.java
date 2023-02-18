package com.spring.user.entities;

import java.util.Arrays;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name = "CO_TRIGGERS")
public class CoTrgEntity {

	@Id
	@GeneratedValue
	private Integer inCoTrgId;
	
	private Long caseNum;
	
	@Lob
	private byte[] pdf;
	
	private String trgStatus;

	public Integer getInCoTrgId() {
		return inCoTrgId;
	}

	public void setInCoTrgId(Integer inCoTrgId) {
		this.inCoTrgId = inCoTrgId;
	}

	public Long getCaseNum() {
		return caseNum;
	}

	public void setCaseNum(Long caseNum) {
		this.caseNum = caseNum;
	}

	public byte[] getPdf() {
		return pdf;
	}

	public void setPdf(byte[] pdf) {
		this.pdf = pdf;
	}

	public String getTrgStatus() {
		return trgStatus;
	}

	public void setTrgStatus(String trgStatus) {
		this.trgStatus = trgStatus;
	}

	public CoTrgEntity(Integer inCoTrgId, Long caseNum, byte[] pdf, String trgStatus) {
		super();
		this.inCoTrgId = inCoTrgId;
		this.caseNum = caseNum;
		this.pdf = pdf;
		this.trgStatus = trgStatus;
	}

	@Override
	public String toString() {
		return "CoTrgEntity [inCoTrgId=" + inCoTrgId + ", caseNum=" + caseNum + ", pdf=" + Arrays.toString(pdf)
				+ ", trgStatus=" + trgStatus + "]";
	}

	public CoTrgEntity() {
		super();

	}

}
