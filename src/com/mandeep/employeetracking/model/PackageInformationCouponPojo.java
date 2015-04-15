package com.mandeep.employeetracking.model;

public class PackageInformationCouponPojo {
	

	
	
	public PackageInformationCouponPojo(String items, String call_type,
			String unit_price, String min_price, String off_peak_price,
			String unit) {
		super();
		this.items = items;
		this.call_type = call_type;
		this.unit_price = unit_price;
		this.min_price = min_price;
		this.off_peak_price = off_peak_price;
		this.unit = unit;
	}

	public String items,call_type,unit_price,min_price,off_peak_price,unit;

	public String getItems() {
		return items;
	}

	public void setItems(String items) {
		this.items = items;
	}

	public String getCall_type() {
		return call_type;
	}

	public void setCall_type(String call_type) {
		this.call_type = call_type;
	}

	public String getUnit_price() {
		return unit_price;
	}

	public void setUnit_price(String unit_price) {
		this.unit_price = unit_price;
	}

	public String getMin_price() {
		return min_price;
	}

	public void setMin_price(String min_price) {
		this.min_price = min_price;
	}

	public String getOff_peak_price() {
		return off_peak_price;
	}

	public void setOff_peak_price(String off_peak_price) {
		this.off_peak_price = off_peak_price;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

}