package com.spring.user.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "FINAL_RESPONSE")
public class FinalResponse {
	
	    @Id
	    @GeneratedValue
		private Integer id;
		private Integer totalRecordsProcessed;
		private Integer approvedCitizenCount;
		private Integer deniedCitizenCount;
		/**
		 * @return the id
		 */
		public Integer getId() {
			return id;
		}
		/**
		 * @param id the id to set
		 */
		public void setId(Integer id) {
			this.id = id;
		}
		/**
		 * @return the totalRecordsProcessed
		 */
		public Integer getTotalRecordsProcessed() {
			return totalRecordsProcessed;
		}
		/**
		 * @param totalRecordsProcessed the totalRecordsProcessed to set
		 */
		public void setTotalRecordsProcessed(Integer totalRecordsProcessed) {
			this.totalRecordsProcessed = totalRecordsProcessed;
		}
		/**
		 * @return the approvedCitizenCount
		 */
		public Integer getApprovedCitizenCount() {
			return approvedCitizenCount;
		}
		/**
		 * @param approvedCitizenCount the approvedCitizenCount to set
		 */
		public void setApprovedCitizenCount(Integer approvedCitizenCount) {
			this.approvedCitizenCount = approvedCitizenCount;
		}
		/**
		 * @return the deniedCitizenCount
		 */
		public Integer getDeniedCitizenCount() {
			return deniedCitizenCount;
		}
		/**
		 * @param deniedCitizenCount the deniedCitizenCount to set
		 */
		public void setDeniedCitizenCount(Integer deniedCitizenCount) {
			this.deniedCitizenCount = deniedCitizenCount;
		}
		@Override
		public String toString() {
			return "FinalResponse [id=" + id + ", totalRecordsProcessed=" + totalRecordsProcessed
					+ ", approvedCitizenCount=" + approvedCitizenCount + ", deniedCitizenCount=" + deniedCitizenCount
					+ "]";
		}
		public FinalResponse(Integer id, Integer totalRecordsProcessed, Integer approvedCitizenCount,
				Integer deniedCitizenCount) {
			super();
			this.id = id;
			this.totalRecordsProcessed = totalRecordsProcessed;
			this.approvedCitizenCount = approvedCitizenCount;
			this.deniedCitizenCount = deniedCitizenCount;
		}
		public FinalResponse() {
			super();
			// TODO Auto-generated constructor stub
		}
		
		
		

}
