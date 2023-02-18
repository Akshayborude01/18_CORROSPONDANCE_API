package com.spring.user.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "FINAL_RESPONSE")
public class CoResponse {
	
	    @Id
	    @GeneratedValue
		private Integer id;
		private long totalRecordsProcessed;
		private long approvedCitizenCount;
		private long deniedCitizenCount;
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
		public long getTotalRecordsProcessed() {
			return totalRecordsProcessed;
		}
		/**
		 * @param totalRecordsProcessed the totalRecordsProcessed to set
		 */
		public void setTotalRecordsProcessed(long totalRecordsProcessed) {
			this.totalRecordsProcessed = totalRecordsProcessed;
		}
		/**
		 * @return the approvedCitizenCount
		 */
		public long getApprovedCitizenCount() {
			return approvedCitizenCount;
		}
		/**
		 * @param approvedCitizenCount the approvedCitizenCount to set
		 */
		public void setApprovedCitizenCount(long approvedCitizenCount) {
			this.approvedCitizenCount = approvedCitizenCount;
		}
		/**
		 * @return the deniedCitizenCount
		 */
		public long getDeniedCitizenCount() {
			return deniedCitizenCount;
		}
		/**
		 * @param deniedCitizenCount the deniedCitizenCount to set
		 */
		public void setDeniedCitizenCount(long deniedCitizenCount) {
			this.deniedCitizenCount = deniedCitizenCount;
		}
		@Override
		public String toString() {
			return "CoResponse [id=" + id + ", totalRecordsProcessed=" + totalRecordsProcessed
					+ ", approvedCitizenCount=" + approvedCitizenCount + ", deniedCitizenCount=" + deniedCitizenCount
					+ "]";
		}
		public CoResponse(Integer id, long totalRecordsProcessed, long approvedCitizenCount, long deniedCitizenCount) {
			super();
			this.id = id;
			this.totalRecordsProcessed = totalRecordsProcessed;
			this.approvedCitizenCount = approvedCitizenCount;
			this.deniedCitizenCount = deniedCitizenCount;
		}
		public CoResponse() {
			super();
			// TODO Auto-generated constructor stub
		}
		

		
}
