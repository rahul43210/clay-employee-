package com.mandeep.employeetracking.model;

public class OrderDetailsPullBackPojo {
	public OrderDetailsPullBackPojo(String fields, String fiels_value) {
		super();
		this.fields = fields;
		this.fiels_value = fiels_value;
	}

	public String fields,fiels_value;

	public String getFields() {
		return fields;
	}

	public void setFields(String fields) {
		this.fields = fields;
	}

	public String getFiels_value() {
		return fiels_value;
	}

	public void setFiels_value(String fiels_value) {
		this.fiels_value = fiels_value;
	}
}
