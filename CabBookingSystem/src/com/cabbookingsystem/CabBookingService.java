package com.cabbookingsystem;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class CabBookingService {

	private Set<Cab> availableCabs = new HashSet<>();

	public void addCab(Cab cab) {
		availableCabs.add(cab);
	}

	public String submitRequest(CabRequest req) {
		
		Cab selectedCab = null;
        double maxProfit = 0;

		for (Cab cab : availableCabs) {
			if (isCabAvailable(req, cab)) {
				double profit = getProfit(req, cab);
				if (profit > 20 && profit > maxProfit) {
                    selectedCab = cab;
                    maxProfit = profit;
                }				
			}
		}
		
		if (selectedCab != null) {
            addJourney(req,selectedCab);
            System.out.println(selectedCab.getId());
            return selectedCab.getId();
        }
		
		return null;
	}

	private boolean isCabAvailable(CabRequest req, Cab cab) {

		int minsToReach = getTimeToReach(req, cab);
		Date currTime = addMinsToDate(minsToReach, cab.getAvailableFrom());
		Date pickupTime = req.getPickupTime();

		int spareTime = (int) (pickupTime.getTime() 
				- currTime.getTime()) / (1000 * 60);
		return spareTime >= 15;

	}

	private int getTimeToReach(CabRequest req, Cab cab) {

		return Math.abs(cab.getLocation() 
				- req.getPiupArea()) * 2 * 2;
	}

	private Date addMinsToDate(int mins, Date date) {

		long currTime = date.getTime();
		return new Date(currTime + mins * 60000);
	}

	private void addJourneyMinutes(Date pickUpTime, int minutes, Cab cab) {
		long curTimeInMs = pickUpTime.getTime();
		cab.setAvailableFrom(new Date(curTimeInMs 
				+ (minutes * 60000)));
	}

	private double getProfit(CabRequest req, Cab cab) {

		int distance = Math.abs(cab.getLocation() - req.getPiupArea())*2;
		double costInCurred = distance * 5;
		int travelDistance = Math.abs(req.getPiupArea() - req.getDropArea());
		costInCurred += travelDistance * 5;
		double costCollected = travelDistance * 10;
		return ((costCollected - costInCurred) / costInCurred) * 100;

	}
	
	public void addJourney(CabRequest req, Cab cab) {
        addJourneyMinutes(req.getPickupTime(), getTimeForDrive(req), cab);
        cab.setLocation(req.getDropArea());
        cab.setRequest(req);
    }
	
	private int getTimeForDrive(CabRequest req) {
        int distance = Math.abs(req.getPiupArea() - req.getDropArea()) * 2;
        return distance * 2;
    }
}
