package com.cabbookingsystem;

import java.util.Date;

public class CabRequest {
	
	private String bookingId;
	private int piupArea;
	private int dropArea;
	private Date pickupTime;
	
	public CabRequest(String bookingId, int piupArea, 
			int dropArea, Date pickupTime) {
		this.bookingId = bookingId;
		this.piupArea = piupArea;
		this.dropArea = dropArea;
		this.pickupTime = pickupTime;
	}
	public String getBookingId() {
		return bookingId;
	}
	public void setBookingId(String bookingId) {
		this.bookingId = bookingId;
	}
	public int getPiupArea() {
		return piupArea;
	}
	public void setPiupArea(int piupArea) {
		this.piupArea = piupArea;
	}
	public int getDropArea() {
		return dropArea;
	}
	public void setDropArea(int dropArea) {
		this.dropArea = dropArea;
	}
	public Date getPickupTime() {
		return pickupTime;
	}
	public void setPickupTime(Date pickupTime) {
		this.pickupTime = pickupTime;
	}

}
