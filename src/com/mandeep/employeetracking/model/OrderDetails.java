package com.mandeep.employeetracking.model;

public class OrderDetails {
	
	int RAF_NO;
	String order_type,sim_type,location,time;
	
	public int getRAF_NO() {
		return RAF_NO;
	}
	public void setRAF_NO(int rAF_NO) {
		RAF_NO = rAF_NO;
	}
	public String getOrder_type() {
		return order_type;
	}
	public void setOrder_type(String order_type) {
		this.order_type = order_type;
	}
	public String getSim_type() {
		return sim_type;
	}
	public void setSim_type(String sim_type) {
		this.sim_type = sim_type;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getTime() {
		return time;
	}
	public OrderDetails() {
		super();
		// TODO Auto-generated constructor stub
	}
	public void setTime(String time) {
		this.time = time;
	}
	
	public OrderDetails(int rAF_NO, String order_type, String sim_type,
			String location, String time) {
		super();
		RAF_NO = rAF_NO;
		this.order_type = order_type;
		this.sim_type = sim_type;
		this.location = location;
		this.time = time;
	}

}
