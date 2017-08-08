package com.surveyin.entity;

import javax.xml.bind.annotation.XmlElement;

public abstract class BaseEntity implements IEntity {
	
	protected long rowUpdated;
	
	@XmlElement(name=IEntity.ROW_UPDATED)
	public long getRowUpdated() {
		return rowUpdated;
	}

	public void setRowUpdated(long rowUpdated) {
		this.rowUpdated = rowUpdated;
	}
}
