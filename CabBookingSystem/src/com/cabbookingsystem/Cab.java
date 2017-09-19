package com.cabbookingsystem;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class Cab {

	private String id;
	private int currLocation;
	private Date availableFrom;
	private List<CabRequest> requests = new ArrayList<CabRequest>();

	public int getCurrLocation() {
		return currLocation;
	}

	public void setCurrLocation(int currLocation) {
		this.currLocation = currLocation;
	}

	public Date getAvailableFrom() {
		return availableFrom;
	}

	public void setAvailableFrom(Date availableFrom) {
		this.availableFrom = availableFrom;
	}

	public List<CabRequest> getRequests() {
		return requests;
	}

	public void setRequest(CabRequest req) {
		this.requests.add(req);
	}

	public Cab(String id, int location) {
		this.id = id;
		this.currLocation = location;

		Calendar cal = Calendar.getInstance();
		this.availableFrom = cal.getTime();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getLocation() {
		return currLocation;
	}

	public void setLocation(int location) {
		this.currLocation = location;
	}

}
