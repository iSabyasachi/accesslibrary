package com.lms.accesslibrary.entity.library;

import java.sql.Timestamp;

public class BaseEntity {
	
	private Timestamp createdTS;
	private Timestamp updatedTS;
	
	public Timestamp getCreatedTS() {
		return createdTS;
	}
	public void setCreatedTS(Timestamp createdTS) {
		this.createdTS = createdTS;
	}
	
	public Timestamp getUpdatedTS() {
		return updatedTS;
	}
	public void setUpdatedTS(Timestamp updatedTS) {
		this.updatedTS = updatedTS;
	}

}
